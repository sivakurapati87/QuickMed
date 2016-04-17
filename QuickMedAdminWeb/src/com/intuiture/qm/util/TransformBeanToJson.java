package com.intuiture.qm.util;

import org.apache.log4j.Logger;

import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.managedbean.AddEmployeeManagedBean;

public class TransformBeanToJson {
	private static Logger LOG = Logger.getLogger(TransformBeanToJson.class);

	public static AdminJson getUserJsonFromRegistrationBean(AdminJson adminJson, AddEmployeeManagedBean addEmployeeManagedBean) {
		try {
			if (addEmployeeManagedBean != null) {
				adminJson.setPassword(addEmployeeManagedBean.getPassword());
				adminJson.setUserName(addEmployeeManagedBean.getUserName());
			}
		} catch (Exception e) {
			LOG.error("error at getUserJsonFromRegistrationBean() in TransformBeanToJson" + e.getMessage());
		}
		return adminJson;
	}

	//
	// public static CouponJson getCouponJsonFromBean(GenerateCouponManagedBean
	// generateCouponManagedBean) {
	// CouponJson couponJson = null;
	// try {
	// if (generateCouponManagedBean.getCouponJson() != null) {
	// couponJson = generateCouponManagedBean.getCouponJson();
	// couponJson.setUpdatedOn(new Date());
	// } else {
	// couponJson = new CouponJson();
	// couponJson.setCreatedOn(new Date());
	// }
	// couponJson.setCouponCode(generateCouponManagedBean.getCouponCode());
	// couponJson.setDiscountPercentage(generateCouponManagedBean.getDiscountPercentage());
	// couponJson.setExpiryDate(CommonUtil.convertStringToDate(CommonUtil.convertDateToString(generateCouponManagedBean.getExpiryDate())));
	// couponJson.setIsDeleted(Boolean.FALSE);
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.equals(e.getMessage());
	// }
	// return couponJson;
	// }
	//
	// public static PromotionalSMSJson
	// getPromotionalSMSJsonFromBean(PromotionalSmsManagedBean bean) {
	// PromotionalSMSJson json = null;
	// if (bean.getPromotionalSMSJson() != null) {
	// json = bean.getPromotionalSMSJson();
	// json.setUpdatedOn(new Date());
	// } else {
	// json = new PromotionalSMSJson();
	// json.setCreatedOn(new Date());
	// }
	// json.setCouponId(bean.getSelectedCoupon());
	// json.setMessage(bean.getMessage());
	// json.setPurchasedAmount(CommonUtil.convertStringToDouble(bean.getAmountPurchaged()));
	// return json;
	// }
}
