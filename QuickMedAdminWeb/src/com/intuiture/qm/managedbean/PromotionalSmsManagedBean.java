//package com.intuiture.qm.managedbean;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//
//import org.apache.log4j.Logger;
//
//import com.intuiture.storetodoorgrocer.bean.PromotionalSmsBean;
//import com.intuiture.storetodoorgrocer.json.CouponJson;
//import com.intuiture.storetodoorgrocer.json.CustomerJson;
//import com.intuiture.storetodoorgrocer.json.PromotionalSMSJson;
//import com.intuiture.storetodoorgrocer.util.CommonUtil;
//import com.intuiture.storetodoorgrocer.util.TransformBeanToJson;
//
//@ManagedBean(name = "PromotionalSmsBean")
//@SessionScoped
//public class PromotionalSmsManagedBean extends PromotionalSmsBean {
//	private static Logger logger = Logger.getLogger(PromotionalSmsManagedBean.class);
//
//	public void init() {
//		setSelectedCoupon(0);
//		setAmountPurchaged(null);
//		setCouponList(CommonUtil.getAllCouponList(CommonUtil.convertDateToString(new Date())));
//		setPromotionalSMSJsonList(CommonUtil.getAllPromotionalSms());
//		setMessage(null);
//		setErrMessage(null);
//		setPromotionalSMSJson(null);
//	}
//
//	public String sendPromotionalSms() {
//		setErrMessage(null);
//		if (getAmountPurchaged() != null && getAmountPurchaged().trim().length() == 0) {
//			setErrMessage("Please Enter Amount Purchased");
//			logger.error("Please Enter Amount Purchased");
//			return "";
//		}
//		if (getSelectedCoupon() == 0) {
//			setErrMessage("Please Select Coupon Code");
//			logger.error("Please Select Coupon Code");
//			return "";
//		}
////		if (getMessage() != null && getMessage().trim().length() == 0) {
////			setErrMessage("Please Enter Message");
////			logger.error("Please Enter Message");
////			return "";
////		}
//		List<CustomerJson> customers_by_purchaseList = CommonUtil.getCustomerByTheirPurchase(getAmountPurchaged());
//		String customerPhoneNumbers = null;
//		if (customers_by_purchaseList != null && customers_by_purchaseList.size() > 0) {
//			for (CustomerJson customerJson : customers_by_purchaseList) {
//				if (customerPhoneNumbers == null) {
//					customerPhoneNumbers = String.valueOf(customerJson.getPhoneNo());
//				} else {
//					customerPhoneNumbers += "," + customerJson.getPhoneNo();
//				}
//			}
//		}
//		String coupon = "";
//		CouponJson selectedCouponJson = null;
//		for (CouponJson couponJson : getCouponList()) {
//			if (couponJson.getCouponCodeId().equals(getSelectedCoupon())) {
//				coupon = couponJson.getCouponCode();
//				selectedCouponJson = couponJson;
//			}
//		}
//		setMessage("Hi this is very crazy offer ," + " Plase Apply : " + coupon + " to get " + selectedCouponJson.getDiscountPercentage() + " % on your purchase");
//		if (customerPhoneNumbers != null && customerPhoneNumbers.trim().length() > 0) {
//			CommonUtil.sendPromotionalSms(getMessage(), customerPhoneNumbers);
//		}
//		FacesContext context = FacesContext.getCurrentInstance();
//		// Get all the registration bean instance
//		PromotionalSmsManagedBean promotionalSmsManagedBean = context.getApplication().evaluateExpressionGet(context, "#{PromotionalSmsBean}", PromotionalSmsManagedBean.class);
//		PromotionalSMSJson promotionalSMSJson = TransformBeanToJson.getPromotionalSMSJsonFromBean(promotionalSmsManagedBean);
//		CommonUtil.submitPromotionalSMS(promotionalSMSJson);
//		init();
//		return "";
//	}
//
//	public String editPromotionalSms() {
//		setSelectedCoupon(getPromotionalSMSJson().getCouponId());
//		setAmountPurchaged(CommonUtil.convertDoubleToString(getPromotionalSMSJson().getPurchasedAmount()));
//		setMessage(getPromotionalSMSJson().getMessage());
//		return "";
//	}
//}
