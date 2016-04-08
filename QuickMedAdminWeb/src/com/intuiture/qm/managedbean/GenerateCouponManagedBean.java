//package com.intuiture.qm.managedbean;
//
//import java.util.Calendar;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//
//import org.apache.log4j.Logger;
//
//import com.intuiture.storetodoorgrocer.bean.GenerateCouponBean;
//import com.intuiture.storetodoorgrocer.json.CouponJson;
//import com.intuiture.storetodoorgrocer.util.CommonUtil;
//import com.intuiture.storetodoorgrocer.util.TransformBeanToJson;
//
//@ManagedBean(name = "GenerateCouponBean")
//@SessionScoped
//public class GenerateCouponManagedBean extends GenerateCouponBean {
//	private static Logger LOG = Logger.getLogger(GenerateCouponBean.class);
//
//	/**
//	 * This method is the initial method
//	 */
//	public void init() {
//		setCouponCode(null);
//		setDiscountPercentage(0f);
//		setErrMessage(null);
//		setExpiryDate(null);
//		setCouponJson(null);
//		setCouponList(CommonUtil.getAllCouponList(null));
//	}
//
//	/**
//	 * This method to generate a coupon
//	 * 
//	 * @return
//	 */
//	public String saveCoupon() {
//		try {
//			setErrMessage(null);
//			if (getCouponCode() != null && getCouponCode().trim().length() == 0) {
//				setErrMessage("Please Enter Coupon Code");
//				return "";
//			}
//			if (getDiscountPercentage() != null && getDiscountPercentage() == 0) {
//				setErrMessage("Please Enter Discount");
//				return "";
//			}
//			if (getExpiryDate() == null) {
//				setErrMessage("Please Pick Expiry Date");
//				return "";
//			}
//			if (CommonUtil.convertStringToDate(CommonUtil.convertDateToString(getExpiryDate())).before(CommonUtil.convertStringToDate(CommonUtil.convertDateToString(Calendar.getInstance().getTime())))) {
//				LOG.error("Expiry Date should be greater than or equals to Today's Date");
//				setErrMessage("Expiry Date should be greater than or equals to Today's Date");
//				return "";
//			}
//			FacesContext context = FacesContext.getCurrentInstance();
//			GenerateCouponManagedBean generateCouponManagedBean = context.getApplication().evaluateExpressionGet(context, "#{GenerateCouponBean}", GenerateCouponManagedBean.class);
//			CouponJson json = TransformBeanToJson.getCouponJsonFromBean(generateCouponManagedBean);
//			LoginManagedBean loginManagedBean = context.getApplication().evaluateExpressionGet(context, "#{LoginBean}", LoginManagedBean.class);
//			if (json.getUserId() == null) {
//				json.setUserId(loginManagedBean.getUserJson().getUserId());
//			}
//			CommonUtil.saveOrUpdateCoupon(json);
//			init();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e.getMessage());
//		}
//		return "";
//	}
//
//	public String updateCoupon() {
//		setCouponCode(getCouponJson().getCouponCode());
//		setDiscountPercentage(getCouponJson().getDiscountPercentage());
//		setExpiryDate(getCouponJson().getExpiryDate());
//		return "";
//	}
//
//	public String deleteCoupon() {
//		CommonUtil.deleteCoupon(getCouponJson().getCouponCodeId());
//		setCouponJson(null);
//		setCouponList(CommonUtil.getAllCouponList(null));
//		return "";
//	}
//}
