package com.intuiture.qm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.AddToCart;

@Repository
public class AddToCartRepository extends BaseRepository {
	private static final Logger LOG = Logger.getLogger(AddToCartRepository.class);

	// public static final String FINDALLBYCUSTOMERID =
	// "AddToCart.findAllByCustomerId";
	// public static final String GETALLORDEREDITEMSBYCUSTOMERIDAND_TOTALORDERID
	// = "AddToCart.getAllOrderedItemsCustomerIdAndTotalOrderID";
	// public static final String GETALLORDEREDITEMSBYCUSTOMERID =
	// "AddToCart.getAllOrderedItemsCustomerId";
	// public static final String GETALLORDEREDITEMSBY_TOTALORDERIDS =
	// "AddToCart.getAllOrderedItemsByTotalOrderIDs";
	// public static final String GETALLORDEREDITEMSBY_TOTALORDERID =
	// "AddToCart.getAllOrderedItemsByTotalOrderID";
	//
	// public List<AddToCart> findAllCartByCustomerId(Integer customerId) {
	// List<AddToCart> addToCartList = null;
	// TypedQuery<AddToCart> tpQuery =
	// getEntityManager().createNamedQuery(FINDALLBYCUSTOMERID,
	// AddToCart.class);
	// tpQuery.setParameter(1, customerId);
	// addToCartList = tpQuery.getResultList();
	// return addToCartList;
	// }
	//
	// public List<AddToCart>
	// getAllOrderedItemsCustomerIdAndTotalOrderId(Integer customerId, Integer
	// totalOrderId) {
	// List<AddToCart> addToCartList = null;
	// TypedQuery<AddToCart> tpQuery =
	// getEntityManager().createNamedQuery(GETALLORDEREDITEMSBYCUSTOMERIDAND_TOTALORDERID,
	// AddToCart.class);
	// tpQuery.setParameter(1, customerId);
	// tpQuery.setParameter(2, totalOrderId);
	// addToCartList = tpQuery.getResultList();
	// return addToCartList;
	// }
	//
	// public List<AddToCart> getAllDeliverableOrderItems(Integer totalOrderId)
	// {
	// List<AddToCart> addToCartList = null;
	// TypedQuery<AddToCart> tpQuery =
	// getEntityManager().createNamedQuery(GETALLORDEREDITEMSBY_TOTALORDERID,
	// AddToCart.class);
	// tpQuery.setParameter(1, totalOrderId);
	// addToCartList = tpQuery.getResultList();
	// return addToCartList;
	// }
	//
	// public List<AddToCart> getAllOrderedItemsCustomerId(Integer customerId) {
	// List<AddToCart> addToCartList = null;
	// TypedQuery<AddToCart> tpQuery =
	// getEntityManager().createNamedQuery(GETALLORDEREDITEMSBYCUSTOMERID,
	// AddToCart.class);
	// tpQuery.setParameter(1, customerId);
	// addToCartList = tpQuery.getResultList();
	// return addToCartList;
	// }

	@SuppressWarnings("unchecked")
	public List<AddToCart> getAllOrderedItemsTotalOrderIds(List<Integer> totalOrderIds) {
		List<AddToCart> addToCartList = null;
		try {
			Criteria criteria = getSession().createCriteria(AddToCart.class);
			criteria.add(Restrictions.and(Restrictions.eq("isItemOrdered", Boolean.TRUE),
					Restrictions.or(Restrictions.isNull("isItemDelivered"), Restrictions.eq("isItemDelivered", Boolean.FALSE)),
					Restrictions.in("totalOrderId", totalOrderIds)));
			addToCartList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return addToCartList;
	}
	// public AddToCart findByCartId(Integer addToCartId) {
	// return getEntityManager().find(AddToCart.class, addToCartId);
	// }
	//
	// public synchronized Integer persist(AddToCart addToCart) {
	// getEntityManager().persist(addToCart);
	// return addToCart.getAddToCartId();
	// }
	//
	// public synchronized void merge(AddToCart addToCart) {
	// getEntityManager().merge(addToCart);
	// }
}
