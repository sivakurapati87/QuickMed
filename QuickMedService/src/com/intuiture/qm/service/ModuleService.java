package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.entity.Module;
import com.intuiture.qm.json.ModuleJson;
import com.intuiture.qm.util.TransformDomainToJson;

@Service
@Transactional
public class ModuleService {
	@Autowired
	private CommonRepository commonRepository;

	@SuppressWarnings("unchecked")
	public List<ModuleJson> getAllModules() {
		List<ModuleJson> moduleJsonList = null;
		try {
			List<Module> moduleList = (List<Module>) commonRepository.getAllActiveRecords(Module.class);
			if (moduleList != null && moduleList.size() > 0) {
				moduleJsonList = new ArrayList<ModuleJson>();
				for (Module module : moduleList) {
					moduleJsonList.add(TransformDomainToJson.getModuleJson(module));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return moduleJsonList;
	}
}
