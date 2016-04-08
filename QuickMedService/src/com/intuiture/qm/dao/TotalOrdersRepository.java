package com.intuiture.qm.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class TotalOrdersRepository extends BaseRepository {
	private final Logger LOG = Logger.getLogger(TotalOrdersRepository.class);
	private static final String FINDALL = "TotalOrders.findAll";
	// private static final String FINDALL_DELIVERED =
	// "TotalOrders.findAllDelivered";
//	private static final String FINDALLBY_CUSTOMERID = "TotalOrders.findAllByCustomerId";
//
//	public synchronized void persist(TotalOrders totalOrders) {
//		getEntityManager().persist(totalOrders);
//	}
//
//	public synchronized void merge(TotalOrders totalOrders) {
//		getEntityManager().merge(totalOrders);
//	}
//
//	public TotalOrders getTotalOrderById(Integer totalOrderId) {
//		return getEntityManager().find(TotalOrders.class, totalOrderId);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<TotalOrders> getDeliveredTotalOrders(Integer locationId) {
//		List<TotalOrders> totalOrders = null;
//		try {
//			String strQuery = "select t from TotalOrders t where ";
//			if (locationId != 0) {
//				strQuery += "t.locationId =?1 and ";
//			}
//			strQuery += "t.isDeleted = true and t.isItemInvoiced = false and t.isDelivered = true order by t.updateOn desc";
//			Query query = getEntityManager().createQuery(strQuery);
//			// TypedQuery<TotalOrders> tpQuery =
//			// getEntityManager().createNamedQuery(FINDALL_DELIVERED,
//			// TotalOrders.class);
//			if (locationId != 0) {
//				query.setParameter(1, locationId);
//			}
//			totalOrders = query.getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e);
//		}
//		return totalOrders;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<TotalOrders> getAllTotalOrders(GridInfoJson gridInfoJson) {
//		List<TotalOrders> totalOrders = null;
//		try {
//			if (gridInfoJson != null) {
//				// TypedQuery<TotalOrders> tpQuery =
//				// getEntityManager().createNamedQuery(FINDALL,
//				// TotalOrders.class);
//				// totalOrders = tpQuery.getResultList();
//				String sqlQuery = "select t from TotalOrders t";
//				sqlQuery = SearchQueryBuilder.generateSearchQuery(gridInfoJson, sqlQuery);
//				if (sqlQuery.contains("where")) {
//					sqlQuery += " and ";
//				} else {
//					sqlQuery += " where ";
//				}
//				sqlQuery += "isDeleted = false";
//				Query query = getEntityManager().createQuery(sqlQuery);
//				query.setFirstResult(gridInfoJson.getFirstResults());
//				query.setMaxResults(gridInfoJson.getRecordsPerPage());
//				totalOrders = query.getResultList();
//			} else {
//				TypedQuery<TotalOrders> tpQuery = getEntityManager().createNamedQuery(FINDALL, TotalOrders.class);
//				totalOrders = tpQuery.getResultList();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e);
//		}
//		return totalOrders;
//	}
//
//	public List<TotalOrders> getAllTotalOrdersByCustomerId(Integer customerId) {
//		List<TotalOrders> totalOrders = null;
//		try {
//			TypedQuery<TotalOrders> tpQuery = getEntityManager().createNamedQuery(FINDALLBY_CUSTOMERID, TotalOrders.class);
//			tpQuery.setParameter(1, customerId);
//			totalOrders = tpQuery.getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e);
//		}
//		return totalOrders;
//	}
}
