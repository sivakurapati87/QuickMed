package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.dao.CustomerRepository;
import com.intuiture.qm.entity.Customer;
import com.intuiture.qm.entity.CustomerDeliveryAddress;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.util.MethodUtil;
import com.intuiture.qm.util.SendEmail;
import com.intuiture.qm.util.TransformDomainToJson;
import com.intuiture.qm.util.TransformJsonToDomain;

@Service
@Transactional
public class CustomerService {
	private static Logger LOG = Logger.getLogger(CustomerService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerJson registrationAction(CustomerJson customerJson) {
		try {
			customerJson.setErrorMsg(null);
			Customer customer = null;
			if (customerJson.getEmailId() != null) {
				customer = customerRepository.getCustomerByEmailOrUserName(customerJson.getEmailId());
			}
			if (customer == null) {
				customer = new Customer();
			}
			TransformJsonToDomain.getCustomer(customerJson, customer);
			if (customer.getCustomerId() != null) {
				// commonRepository.update(customer);
				customerJson.setErrorMsg("Email Already Exists");
			} else {
				commonRepository.persist(customer);
				customerJson.setCustomerId(customer.getCustomerId());
				SendEmail.sentEmail(customerJson.getEmailId(), null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			customerJson.setErrorMsg("Something wrong with the website, sorry for inconvenience..");
			LOG.error(e.getMessage(), e);
		}

		return customerJson;
	}

	public CustomerJson forgetPassword(String email) {
		CustomerJson customerJson = new CustomerJson();
		try {
			customerJson.setErrorMsg(null);
			Customer customer = null;
			if (email != null) {
				customer = customerRepository.getCustomerByEmailOrUserName(email);
			}
			if (customer != null) {
				SendEmail.sentEmail(customer.getEmailId(), MethodUtil.passwordDecryption(customer.getPassword()));
				customerJson.setErrorMsg("Password sent");
			} else {
				customerJson.setErrorMsg("Email/Username not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
			customerJson.setErrorMsg("Something wrong with the website, sorry for inconvenience..");
			LOG.error(e.getMessage(), e);
		}

		return customerJson;
	}

	public CustomerJson placeCustomerDeliverAddress(CustomerJson customerJson) {
		try {
			Customer customer = null;
			if (customerJson.getCustomerId() != null) {
				customer = (Customer) commonRepository.findById(customerJson.getCustomerId(), Customer.class);
				TransformJsonToDomain.getCustomer(customerJson, customer);

				customer.setState(customerJson.getCustomerDeliveryAddressJson().getState());
				customer.setCity(customerJson.getCustomerDeliveryAddressJson().getCity());
				customer.setAddress(customerJson.getCustomerDeliveryAddressJson().getAddress());
				customer.setPincode(customerJson.getCustomerDeliveryAddressJson().getPincode());

				CustomerDeliveryAddress customerDeliveryAddress = new CustomerDeliveryAddress();
				customerDeliveryAddress.setPhoneNumber(customerJson.getPhoneNumber());
				customerDeliveryAddress.setAddress(customerJson.getCustomerDeliveryAddressJson().getAddress());
				customerDeliveryAddress.setCity(customerJson.getCustomerDeliveryAddressJson().getCity());
				customerDeliveryAddress.setIsDeleted(Boolean.FALSE);
				customerDeliveryAddress.setPincode(customerJson.getCustomerDeliveryAddressJson().getPincode());
				customerDeliveryAddress.setState(customerJson.getCustomerDeliveryAddressJson().getState());
				customerDeliveryAddress.setTotalOrderId(customerJson.getCustomerDeliveryAddressJson().getTotalOrderId());
				commonRepository.persist(customerDeliveryAddress);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}

		return customerJson;
	}

	public CustomerJson loginAction(String username, String password) {
		CustomerJson customerJson = null;
		try {
			Customer customer = customerRepository.loginAction(username, MethodUtil.passwordEncryption(password));
			if (customer != null) {
				customerJson = TransformDomainToJson.getCustomerJson(customer);
			} else {
				customerJson = new CustomerJson();
				customerJson.setErrorMsg("Credentials are wrong please try again");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customerJson;
	}

	public List<CustomerJson> getAllCustomer(GridInfoJson gridInfoJson) {

		List<CustomerJson> customerJsonList = null;
		try {
			List<Customer> customerList = customerRepository.getAllCustomer(gridInfoJson);
			if (customerList != null && customerList.size() > 0) {
				customerJsonList = new ArrayList<CustomerJson>();
				for (Customer customer : customerList) {
					CustomerJson customerJson = TransformDomainToJson.getCustomerJson(customer);
					customerJsonList.add(customerJson);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getAllCustomer() in CustomerService:" + e.getMessage(), e);
		}
		return customerJsonList;
	}

	public Long getNoOfItemsList(GridInfoJson gridInfoJson) {
		Long noOfRecords = null;
		try {

			noOfRecords = customerRepository.getNoOfCustomers(gridInfoJson);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getNoOfItemsList() in CustomerService:" + e.getMessage(), e);
		}
		return noOfRecords;
	}

}
