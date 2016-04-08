package com.intuiture.qm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;

@Service
@Transactional
public class JobTitlesService {
	@Autowired
	private CommonRepository commonRepository;

//	public Boolean saveJobTitles(JobTitlesJson jobTitlesJson) {
//		JobTitles jobTitles = null;
//
//		try {
//			if (jobTitlesJson.getJobtitlesId() != null) {
//				jobTitles = (JobTitles) commonRepository.findById(jobTitlesJson.getJobtitlesId(), JobTitles.class);
//			} else {
//				jobTitles = new JobTitles();
//			}
//			TransformJsonToDomain.getJobTitles(jobTitles, jobTitlesJson);
//			if (jobTitlesJson.getJobtitlesId() != null) {
//				commonRepository.update(jobTitles);
//			} else {
//				commonRepository.persist(jobTitles);
//			}
//		} catch (Exception e) {
//			return false;
//		}
//		return true;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<JobTitlesJson> getAllJobTitlesList(Integer companyId) {
//		List<JobTitlesJson> jobTitlesJsonList = null;
//		try {
//			List<JobTitles> jobTitlesList = (List<JobTitles>) commonRepository.getAllRecordsByCompanyId(companyId, JobTitles.class);
//			if (jobTitlesList != null && jobTitlesList.size() > 0) {
//				jobTitlesJsonList = new ArrayList<JobTitlesJson>();
//				for (JobTitles jobTitle : jobTitlesList) {
//					jobTitlesJsonList.add(TransformDomainToJson.getJobTitlesJson(jobTitle));
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return jobTitlesJsonList;
//	}
//
//	public Boolean deleteJobTitle(Integer jobTitleId) {
//		try {
//			JobTitles jobTitles = (JobTitles) commonRepository.findById(jobTitleId, JobTitles.class);
//			if (jobTitles != null) {
//				jobTitles.setIsDeleted(Boolean.TRUE);
//				commonRepository.update(jobTitles);
//			}
//		} catch (Exception e) {
//			return false;
//		}
//		return true;
//	}

}
