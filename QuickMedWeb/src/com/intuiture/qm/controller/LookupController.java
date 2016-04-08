package com.intuiture.qm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LookUpController")
public class LookupController {

//	@RequestMapping(value = "/lookupInit")
//	@ResponseBody
//	public LookupBean lookupInit() {
//		LookupBean lookupBean = new LookupBean();
//
//		String[] lookUpTypes = { Constants.TYPEOFBUSINESS, Constants.YEAR, Constants.MONTHS, Constants.MQHS, Constants.PAYMENT_STATUS,
//				Constants.BANKS, Constants.DAYS, Constants.STATES, Constants.DMW, Constants.LEAVETYPE, Constants.WORKERTYPE, Constants.TIMETYPE,
//				Constants.GENDER, Constants.MARITALSTATUS, Constants.BLOODGROUP, Constants.RELATION, Constants.TRUEORFALSE, Constants.MONTH,
//				Constants.DAY, Constants.PAYDAYINAMONTH, Constants.CURRENCY, Constants.STATUS };
//
//		List<String> typesList = Arrays.asList(lookUpTypes);
//		Map<String, List<LookUpDetailJson>> lookUpMap = CommonUtil.getLookupDetailsListByTypeList(Constants.LookUp.GETLOOKUPDETAILSBYTYPELIST,
//				typesList);
//		lookupBean.setBanksList(lookUpMap.get(Constants.BANKS));
//		lookupBean.setMonthList(lookUpMap.get(Constants.MONTHS));
//		lookupBean.setYearList(lookUpMap.get(Constants.YEAR));
//		lookupBean.setTypeOfBusinessList(lookUpMap.get(Constants.TYPEOFBUSINESS));
//		lookupBean.setStatesList(lookUpMap.get(Constants.STATES));
//		lookupBean.setDaysWeeksMonthsList(lookUpMap.get(Constants.DMW));
//		lookupBean.setWorkerTypeList(lookUpMap.get(Constants.WORKERTYPE));
//		lookupBean.setTimeTypeList(lookUpMap.get(Constants.TIMETYPE));
//		lookupBean.setGenderList(lookUpMap.get(Constants.GENDER));
//		lookupBean.setMaritalStatusList(lookUpMap.get(Constants.MARITALSTATUS));
//		lookupBean.setBloodGroupList(lookUpMap.get(Constants.BLOODGROUP));
//		lookupBean.setRelationsList(lookUpMap.get(Constants.RELATION));
//		lookupBean.setTrueorfalseList(lookUpMap.get(Constants.TRUEORFALSE));
////		lookupBean.setMonthList(lookUpMap.get(Constants.MONTH));
//		lookupBean.setDayList(lookUpMap.get(Constants.DAY));
//		lookupBean.setPayDAYInAMonthList(lookUpMap.get(Constants.PAYDAYINAMONTH));
//		lookupBean.setCurrencyList(lookUpMap.get(Constants.CURRENCY));
//		lookupBean.setStatusList(lookUpMap.get(Constants.STATUS));
//		lookupBean.setDaysList(lookUpMap.get(Constants.DAYS));
//		lookupBean.setLeaveTypeList(lookUpMap.get(Constants.LEAVETYPE));
//		lookupBean.setMonthQuerertyList(lookUpMap.get(Constants.MQHS));
//		lookupBean.setPaymentStatusList(lookUpMap.get(Constants.PAYMENT_STATUS));
//		lookupBean.setReasonTypeList(lookUpMap.get(Constants.REASONTYPE));
//
//		return lookupBean;
//	}
}
