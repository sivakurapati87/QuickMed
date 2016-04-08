package com.intuiture.qm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.intuiture.qm.entity.Category;
import com.intuiture.qm.entity.Module;
import com.intuiture.qm.entity.SubModule;

@Repository
public class DataInsertRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(DataInsertRepository.class);

	@SuppressWarnings("unchecked")
	public List<Module> getModuleCodesByList(List<String> codesList) {
		List<Module> moduleList = null;
		try {
			Criteria criteria = getSession().createCriteria(Module.class)
					.setProjection(Projections.projectionList().add(Projections.property("moduleCode"), "moduleCode"))
					.setResultTransformer(Transformers.aliasToBean(Module.class));
			criteria.add(Restrictions.in("moduleCode", codesList));
			moduleList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return moduleList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getSubModuleCodesByList(List<String> codesList) {
		List<String> list = null;
		try {
			Criteria criteria = getSession().createCriteria(SubModule.class).setProjection(Projections.property("subModuleCode"));
			criteria.add(Restrictions.in("subModuleCode", codesList));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryCodesByList(List<String> codesList) {
		List<Category> categoryList = null;
		try {
			Criteria criteria = getSession().createCriteria(Category.class).setProjection(Projections.property("categoryCode"));
			criteria.add(Restrictions.in("categoryCode", codesList));
			categoryList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return categoryList;
	}

}
