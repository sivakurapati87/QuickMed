package com.intuiture.qm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.AdminRepository;
import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.entity.Admin;
import com.intuiture.qm.entity.Customer;
import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.util.MethodUtil;
import com.intuiture.qm.util.TransformDomainToJson;
import com.intuiture.qm.util.TransformJsonToDomain;

@Service
@Transactional
public class AdminLoginService {
	private static Logger LOG = Logger.getLogger(AdminLoginService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private AdminRepository adminRepository;

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

	public AdminJson loginAction(String username, String password) {
		AdminJson adminJson = null;
		try {
			Admin admin = adminRepository.loginAction(username, password);
			if (admin != null) {
				adminJson = TransformDomainToJson.getAdminJson(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return adminJson;
	}
}
