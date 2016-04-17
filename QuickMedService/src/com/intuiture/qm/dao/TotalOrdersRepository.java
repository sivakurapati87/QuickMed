package com.intuiture.qm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.TotalOrders;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.util.SearchQueryBuilder;

@Repository
public class TotalOrdersRepository extends BaseRepository {
	private final Logger LOG = Logger.getLogger(TotalOrdersRepository.class);

	// private static final String FINDALL_DELIVERED =
	// "TotalOrders.findAllDelivered";
	// private static final String FINDALLBY_CUSTOMERID =
	// "TotalOrders.findAllByCustomerId";
	//
	// public synchronized void persist(TotalOrders totalOrders) {
	// getEntityManager().persist(totalOrders);
	// }
	//
	// public synchronized void merge(TotalOrders totalOrders) {
	// getEntityManager().merge(totalOrders);
	// }
	//
	// public TotalOrders getTotalOrderById(Integer totalOrderId) {
	// return getEntityManager().find(TotalOrders.class, totalOrderId);
	// }
	//
	@SuppressWarnings("unchecked")
	public List<TotalOrders> getDeliveredTotalOrders() {
		List<TotalOrders> totalOrders = null;
		try {
			Criteria criteria = getSession().createCriteria(TotalOrders.class);
			criteria.add(Restrictions.and(Restrictions.eq("isDeleted", Boolean.TRUE), Restrictions.eq("isItemInvoiced", Boolean.FALSE),
					Restrictions.eq("isDelivered", Boolean.TRUE)));
			criteria.addOrder(Order.desc("updateOn"));
			totalOrders = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return totalOrders;
	}

	//
	@SuppressWarnings("unchecked")
	public List<TotalOrders> getAllTotalOrders(GridInfoJson gridInfoJson) {
		List<TotalOrders> totalOrders = null;
		try {
			if (gridInfoJson != null) {

				// TypedQuery<TotalOrders> tpQuery =
				// getEntityManager().createNamedQuery(FINDALL,
				// TotalOrders.class);
				// totalOrders = tpQuery.getResultList();
				String sqlQuery = "select t from TotalOrders t";
				sqlQuery = SearchQueryBuilder.generateSearchQuery(gridInfoJson, sqlQuery);
				if (sqlQuery.contains("where")) {
					sqlQuery += " and ";
				} else {
					sqlQuery += " where ";
				}
				sqlQuery += "isDeleted = false";
				Query query = getSession().createQuery(sqlQuery);
				query.setFirstResult(gridInfoJson.getFirstResults());
				query.setMaxResults(gridInfoJson.getRecordsPerPage());
				totalOrders = query.list();
			} else {
				Criteria criteria = getSession().createCriteria(TotalOrders.class);
				criteria.add(Restrictions.eq("isDeleted", Boolean.FALSE));
				totalOrders = criteria.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return totalOrders;
	}
	//
	// public List<TotalOrders> getAllTotalOrdersByCustomerId(Integer
	// customerId) {
	// List<TotalOrders> totalOrders = null;
	// try {
	// TypedQuery<TotalOrders> tpQuery =
	// getEntityManager().createNamedQuery(FINDALLBY_CUSTOMERID,
	// TotalOrders.class);
	// tpQuery.setParameter(1, customerId);
	// totalOrders = tpQuery.getResultList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error(e);
	// }
	// return totalOrders;
	// }
}
