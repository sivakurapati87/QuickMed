package com.intuiture.qm.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.Admin;

@Repository
public class AdminRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(AdminRepository.class);

	public Admin loginAction(String username, String password) {
		Admin admin = null;
		try {
			Criteria criteria = getSession().createCriteria(Admin.class);
			criteria.add(Restrictions.and((Restrictions.eq("userName", username)), Restrictions.eq("password", password), Restrictions.eq("isDeleted", Boolean.FALSE)));
			admin = (Admin) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return admin;
	}

	public Admin checkUserNameExists(String username) {
		Admin admin = null;
		try {
			Criteria criteria = getSession().createCriteria(Admin.class);
			criteria.add(Restrictions.and(Restrictions.eq("userName", username), Restrictions.eq("isDeleted", Boolean.FALSE)));
			admin = (Admin) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return admin;
	}
}
