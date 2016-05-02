package com.intuiture.qm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.Item;
import com.intuiture.qm.util.Constants;

@Repository
public class ItemRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(ItemRepository.class);

	@SuppressWarnings("unchecked")
	public List<Item> getAllCategoriesWithItemsBySubModuleCode(String subModuleCode) {
		List<Item> itemList = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.createAlias("category", "category");
			criteria.add(Restrictions.eq("category.subModuleCode", subModuleCode));
			itemList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAllProductsByManufacturerName(String manufacturer) {
		List<Item> itemList = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.add(Restrictions.like("manufacturerName", manufacturer, MatchMode.ANYWHERE));
			itemList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllManufacturers() {
		List<String> manufacturersList = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.setProjection(Projections.distinct(Projections.property("manufacturerName")));
			manufacturersList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return manufacturersList;
	}

	@SuppressWarnings("unchecked")
	public List<Item> searchProduct(String productName) {
		List<Item> itemList = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.createAlias("category", "category");
			criteria.createAlias("category.subModule", "submodule");
			criteria.add(Restrictions.or(Restrictions.like("itemName", productName, MatchMode.ANYWHERE),
					Restrictions.like("category.categoryName", productName, MatchMode.ANYWHERE),
					Restrictions.like("submodule.subModuleName", productName, MatchMode.ANYWHERE)));

			itemList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getRequiredsearchProducts(String productName, Integer pageNo) {
		List<Item> itemList = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.createAlias("category", "category");
			criteria.add(Restrictions.or(Restrictions.eq("itemName", productName), Restrictions.eq("categoryCode", productName),
					Restrictions.eq("category.subModuleCode", productName)));
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(Constants.MAX_DISPLAYED_RECORDS);
			itemList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAllSimilarItems(String chemicalIngradient) {
		List<Item> itemList = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.add(Restrictions.eq("chemicalIngredient", chemicalIngradient));
			itemList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return itemList;
	}

	public Long getNoOfRequiredsearchProducts(String productName) {
		Long number = null;
		try {
			Criteria criteria = getSession().createCriteria(Item.class);
			criteria.setProjection(Projections.rowCount());
			criteria.createAlias("category", "category");
			criteria.add(Restrictions.or(Restrictions.eq("itemName", productName), Restrictions.eq("categoryCode", productName),
					Restrictions.eq("category.subModuleCode", productName)));

			number = (Long) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return number;
	}
}
