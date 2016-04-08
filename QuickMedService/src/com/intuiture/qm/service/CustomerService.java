package com.intuiture.qm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.dao.CustomerRepository;
import com.intuiture.qm.entity.Customer;
import com.intuiture.qm.entity.CustomerDeliveryAddress;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.util.MethodUtil;
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
			Customer customer = null;
			if (customerJson.getCustomerId() != null) {
				customer = (Customer) commonRepository.findById(customerJson.getCustomerId(), Customer.class);
			} else {
				customer = new Customer();
			}
			TransformJsonToDomain.getCustomer(customerJson, customer);
			if (customerJson.getCustomerId() != null) {
				commonRepository.update(customer);
			} else {
				commonRepository.persist(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customerJson;
	}
}
