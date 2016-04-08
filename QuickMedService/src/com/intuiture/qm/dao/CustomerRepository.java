package com.intuiture.qm.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.Customer;

@Repository
public class CustomerRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(CustomerRepository.class);

	public Customer loginAction(String username, String password) {
		Customer customer = null;
		try {
			Criteria criteria = getSession().createCriteria(Customer.class);
			criteria.add(Restrictions.and(Restrictions.or(Restrictions.eq("emailId", username), Restrictions.eq("userName", username)),
					Restrictions.eq("password", password)));
			customer = (Customer) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customer;
	}
}
