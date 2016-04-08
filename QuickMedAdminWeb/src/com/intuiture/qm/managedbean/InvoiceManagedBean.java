//package com.intuiture.qm.managedbean;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//
//import org.apache.log4j.Logger;
//
//import com.intuiture.storetodoorgrocer.bean.InvoiceBean;
//import com.intuiture.storetodoorgrocer.json.TotalOrdersJson;
//import com.intuiture.storetodoorgrocer.util.CommonUtil;
//import com.intuiture.storetodoorgrocer.util.Constants;
//
//@ManagedBean(name = "InvoiceBean")
//@SessionScoped
//public class InvoiceManagedBean extends InvoiceBean {
//	private final static Logger LOG = Logger.getLogger(InvoiceManagedBean.class);
//
//	public void init() {
//		try {
//			Integer locationId = 0;
//			FacesContext context = FacesContext.getCurrentInstance();
//			LoginManagedBean loginManagedBean = context.getApplication().evaluateExpressionGet(context, "#{LoginBean}", LoginManagedBean.class);
//			if (loginManagedBean.getSelectedEmpType().equals(Constants.BILLINGID)) {
//				locationId = loginManagedBean.getSelectedLocation();
//			}
//			setTotalOrderComboList(CommonUtil.getAllTotalOrdersJsonList(Constants.TotalOrdersController.GETDELIVERED_TOTALORDERS, locationId));
//			setSelectedTotalOrder(0);
//			setOrderItemsList(null);
//			setTotalOrdersJson(new TotalOrdersJson());
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("Error at init() in InvoiceManagedBean-->" + e.getMessage(), e);
//		}
//	}
//
//	public void onChangeTotalOrderComboAction() {
//		try {
//			if (!getSelectedTotalOrder().equals(0)) {
//				setOrderItemsList(CommonUtil.getAllDeliverableOrderItems(getSelectedTotalOrder()));
//				if (getOrderItemsList() != null)
//					setOrdersSize(getOrderItemsList().size());
//				for (TotalOrdersJson json : getTotalOrderComboList()) {
//					if (getSelectedTotalOrder().equals(json.getTotalOrderId())) {
//						setTotalOrdersJson(json);
//						break;
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("Error at onChangeTotalOrderComboAction() in InvoiceManagedBean-->" + e.getMessage(), e);
//		}
//	}
//
//	public void removeItemFromInvoiceCombo() {
//		try {
//			// System.out.println("hi Siva Kurapati");
//			if (getTotalOrdersJson().getTotalOrderId() != null) {
//				CommonUtil.removeTotalOrder(Constants.TotalOrdersController.REMOVEITEMFROMINVOICE, getTotalOrdersJson().getTotalOrderId());
//				init();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("Error at removeItemFromInvoiceCombo() in InvoiceManagedBean-->" + e.getMessage(), e);
//		}
//	}
//}
