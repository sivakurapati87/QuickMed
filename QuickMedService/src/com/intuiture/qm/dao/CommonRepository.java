package com.intuiture.qm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(CommonRepository.class);

	/*
	 * This method is to save an object
	 */
	public synchronized void persist(Object object) {
		try {
			getSession().persist(object);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}

	}

	/*
	 * This method is to update an object
	 */
	public synchronized void update(Object object) {
		getSession().merge(object);
	}

	/**
	 * Get an object based on id
	 * 
	 * @param id
	 * @return
	 */
	public Object findById(Integer id, Class<?> classType) {
		return getSession().get(classType, id);
	}

	/**
	 * This method is to get all the records based on employee Id
	 * 
	 * @param employeeId
	 * @param clazz
	 * @return
	 */
	public List<?> getAllRecordsByList(String fieldName, List<?> ids, Class<?> clazz) {
		List<?> list = null;
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			criteria.add(Restrictions.in(fieldName, ids));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at CommonRepository getAllRecordsByList()" + e.getMessage(), e);
		}
		return list;
	}

	/**
	 * This method is to get a single column values
	 * 
	 * @param codesList
	 * @return
	 */
	public List<?> getCodesByList(List<String> codesList, Class<?> clazz, String fieldName) {
		List<?> list = null;
		try {
			Criteria criteria = getSession().createCriteria(clazz).setProjection(Projections.property(fieldName));
			criteria.add(Restrictions.in(fieldName, codesList));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return list;
	}

	public List<?> getAllActiveRecords(Class<?> clazz) {
		List<?> list = null;
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			criteria.setCacheable(true);
			criteria.add(Restrictions.eq("isDeleted", Boolean.FALSE));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return list;
	}
}
