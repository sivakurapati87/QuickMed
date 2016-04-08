package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.entity.SubModule;
import com.intuiture.qm.json.SubModuleJson;
import com.intuiture.qm.util.TransformDomainToJson;

@Service
@Transactional
public class SubModuleService {
	@Autowired
	private CommonRepository commonRepository;

	@SuppressWarnings("unchecked")
	public Map<String, List<SubModuleJson>> getAllSubModulesWithModuleNameMap() {
		Map<String, List<SubModuleJson>> subModuleMap = null;
		try {
			List<SubModule> subModuleList = (List<SubModule>) commonRepository.getAllActiveRecords(SubModule.class);
			if (subModuleList != null && subModuleList.size() > 0) {
				subModuleMap = new LinkedHashMap<String, List<SubModuleJson>>();
				for (SubModule subModule : subModuleList) {
					SubModuleJson subModuleJson = TransformDomainToJson.getSubModuleJson(subModule);
					if (subModuleJson.getModuleName() != null) {
						if (subModuleMap.get(subModuleJson.getModuleName()) != null) {
							subModuleMap.get(subModuleJson.getModuleName()).add(subModuleJson);
						} else {
							List<SubModuleJson> subModuleJsonList = new ArrayList<SubModuleJson>();
							subModuleJsonList.add(subModuleJson);
							subModuleMap.put(subModuleJson.getModuleName(), subModuleJsonList);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subModuleMap;
	}

}
