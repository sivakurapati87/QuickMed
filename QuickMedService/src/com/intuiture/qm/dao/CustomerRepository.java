package com.intuiture.qm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.Customer;
import com.intuiture.qm.entity.CustomerDeliveryAddress;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.util.SearchQueryBuilder;

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

	public Customer getCustomerByEmailOrUserName(String username) {
		Customer customer = null;
		try {
			Criteria criteria = getSession().createCriteria(Customer.class);
			criteria.add(Restrictions.and(Restrictions.or(Restrictions.eq("emailId", username), Restrictions.eq("userName", username))));
			customer = (Customer) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customer;
	}

	@SuppressWarnings("unchecked")
	public CustomerDeliveryAddress findAddressByTotalOrderId(Integer totalOrderId) {
		CustomerDeliveryAddress customerDeliveryAddress = null;
		try {
			Criteria criteria = getSession().createCriteria(CustomerDeliveryAddress.class);
			criteria.add(Restrictions.and(Restrictions.eq("isDeleted", Boolean.FALSE), Restrictions.eq("totalOrderId", totalOrderId)));
			List<CustomerDeliveryAddress> list = criteria.list();
			if (list != null && list.size() > 0) {
				customerDeliveryAddress = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customerDeliveryAddress;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer(GridInfoJson gridInfoJson) {
		List<Customer> customerList = null;
		try {
			String sqlQuery = "select c from Customer c";
			sqlQuery = SearchQueryBuilder.generateSearchQuery(gridInfoJson, sqlQuery);
			Query query = getSession().createQuery(sqlQuery);
			query.setFirstResult(gridInfoJson.getFirstResults());
			query.setMaxResults(gridInfoJson.getRecordsPerPage());
			customerList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customerList;
	}

	public Long getNoOfCustomers(GridInfoJson gridInfoJson) {
		Long numberOfProperties = null;
		try {
			String sqlQuery = "Select count(*) from Customer c ";
			sqlQuery = SearchQueryBuilder.generateSearchQuery(gridInfoJson, sqlQuery);
			Query query = getSession().createQuery(sqlQuery);
			numberOfProperties = (Long) query.uniqueResult();
			// long endTime = Calendar.getInstance().getTimeInMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberOfProperties;
	}

}
