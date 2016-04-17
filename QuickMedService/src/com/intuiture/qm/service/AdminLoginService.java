package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.AdminRepository;
import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.entity.Admin;
import com.intuiture.qm.json.AdminJson;
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

	public Boolean registrationAction(AdminJson adminJson) {
		try {
			Admin admin = null;
			if (adminJson.getAdminId() != null) {
				admin = (Admin) commonRepository.findById(adminJson.getAdminId(), Admin.class);
			} else {
				admin = new Admin();
			}
			TransformJsonToDomain.getAdmin(admin, adminJson);
			if (adminJson.getAdminId() != null) {
				commonRepository.update(admin);
			} else {
				commonRepository.persist(admin);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}

		return false;
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

	public AdminJson checkUserNameExists(String userName) {
		AdminJson adminJson = null;
		try {
			Admin admin = adminRepository.checkUserNameExists(userName);
			if (admin != null) {
				adminJson = TransformDomainToJson.getAdminJson(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return adminJson;
	}

	@SuppressWarnings("unchecked")
	public List<AdminJson> getAllAdmins() {
		List<AdminJson> adminJsonList = null;
		try {
			List<Admin> adminList = (List<Admin>) commonRepository.getAllActiveRecords(Admin.class);
			if (adminList != null && adminList.size() > 0) {
				adminJsonList = new ArrayList<AdminJson>();
				for (Admin admin : adminList) {
					adminJsonList.add(TransformDomainToJson.getAdminJson(admin));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return adminJsonList;
	}

	public Boolean deleteAdmin(Integer adminId) {
		try {
			Admin admin = (Admin) commonRepository.findById(adminId, Admin.class);
			admin.setIsDeleted(Boolean.TRUE);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return false;
	}
}
