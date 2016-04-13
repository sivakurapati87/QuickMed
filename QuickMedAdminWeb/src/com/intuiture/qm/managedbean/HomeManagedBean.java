package com.intuiture.qm.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.intuiture.qm.bean.HomeBean;

@ManagedBean(name = "HomeBean")
@SessionScoped
public class HomeManagedBean extends HomeBean {
	private static Logger LOG = Logger.getLogger(HomeManagedBean.class);
	// @ManagedProperty(value = "#{CategoryBean}")
	// private CategoryManagedBean categoryManagedBean;
	// @ManagedProperty(value = "#{SubCategoryBean}")
	// private SubCategoryManagedBean subCategoryManagedBean;
	// @ManagedProperty(value = "#{AddItemBean}")
	// private AddItemManagedBean itemInfoManagedBean;
	// @ManagedProperty(value = "#{AddEmployeeBean}")
	// private AddEmployeeManagedBean addEmployeeManagedBean;
	// @ManagedProperty(value = "#{PromotionalSmsBean}")
	// private PromotionalSmsManagedBean promotionalSmsManagedBean;
	// @ManagedProperty(value = "#{CustomerBean}")
	// private CustomerManagedBean customerManagedBean;
	// @ManagedProperty(value = "#{GenerateCouponBean}")
	// private GenerateCouponManagedBean generateCouponManagedBean;
	@ManagedProperty(value = "#{OrdersBean}")
	private OrdersManagedBean ordersManagedBean;

	// @ManagedProperty(value = "#{InvoiceBean}")
	// private InvoiceManagedBean invoiceManagedBean;
	//
	// public InvoiceManagedBean getInvoiceManagedBean() {
	// return invoiceManagedBean;
	// }
	//
	// public void setInvoiceManagedBean(InvoiceManagedBean invoiceManagedBean)
	// {
	// this.invoiceManagedBean = invoiceManagedBean;
	// }
	//
	public OrdersManagedBean getOrdersManagedBean() {
		return ordersManagedBean;
	}

	public void setOrdersManagedBean(OrdersManagedBean ordersManagedBean) {
		this.ordersManagedBean = ordersManagedBean;
	}

	//
	// public GenerateCouponManagedBean getGenerateCouponManagedBean() {
	// return generateCouponManagedBean;
	// }
	//
	// public void setGenerateCouponManagedBean(GenerateCouponManagedBean
	// generateCouponManagedBean) {
	// this.generateCouponManagedBean = generateCouponManagedBean;
	// }
	//
	// public CustomerManagedBean getCustomerManagedBean() {
	// return customerManagedBean;
	// }
	//
	// public void setCustomerManagedBean(CustomerManagedBean
	// customerManagedBean) {
	// this.customerManagedBean = customerManagedBean;
	// }
	//
	// public PromotionalSmsManagedBean getPromotionalSmsManagedBean() {
	// return promotionalSmsManagedBean;
	// }
	//
	// public void setPromotionalSmsManagedBean(PromotionalSmsManagedBean
	// promotionalSmsManagedBean) {
	// this.promotionalSmsManagedBean = promotionalSmsManagedBean;
	// }
	//
	// public AddEmployeeManagedBean getAddEmployeeManagedBean() {
	// return addEmployeeManagedBean;
	// }
	//
	// public void setAddEmployeeManagedBean(AddEmployeeManagedBean
	// addEmployeeManagedBean) {
	// this.addEmployeeManagedBean = addEmployeeManagedBean;
	// }
	//
	// public CategoryManagedBean getCategoryManagedBean() {
	// return categoryManagedBean;
	// }
	//
	// public void setCategoryManagedBean(CategoryManagedBean
	// categoryManagedBean) {
	// this.categoryManagedBean = categoryManagedBean;
	// }
	//
	// public SubCategoryManagedBean getSubCategoryManagedBean() {
	// return subCategoryManagedBean;
	// }
	//
	// public void setSubCategoryManagedBean(SubCategoryManagedBean
	// subCategoryManagedBean) {
	// this.subCategoryManagedBean = subCategoryManagedBean;
	// }
	//
	// public AddItemManagedBean getItemInfoManagedBean() {
	// return itemInfoManagedBean;
	// }
	//
	// public void setItemInfoManagedBean(AddItemManagedBean
	// itemInfoManagedBean) {
	// this.itemInfoManagedBean = itemInfoManagedBean;
	// }

	// @PostConstruct
	// public void init() {
	// setCategoriesList(CommonUtil.getLookupDetailsListByType(Constants.Lookup.LOOKUPDETAILSBYTYPE,
	// "categories"));
	// setSelectedCategory(0);
	// setModel(new DefaultMenuModel());
	// if (getCategoriesList() != null && getCategoriesList().size() > 0) {
	// for (LookUpDetailJson json : getCategoriesList()) {
	// DefaultMenuItem dmi = new DefaultMenuItem(json.getDescription());
	// dmi.setCommand("#{HomeBean.groceryAction}");
	// dmi.setStyle("height:50px;");
	// dmi.setParam("key", json.getLookupDetailId());
	// getModel().addElement(dmi);
	// }
	// }
	// }

	// public String groceryAction() {
	// System.out.println("Hi this is suresh raina");
	// String key =
	// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("key");
	// System.out.println(key);
	// return "";
	//
	// }
	/**
	 * This is to view the add item page
	 * 
	 * @return
	 */

	public String addItemAction() {
		try {

			// itemInfoManagedBean.init();
		} catch (Exception e) {
			LOG.error("error at addItemAction() in HomeManagedBean" + e.getMessage());
		}
		return "/views/addItem";

	}

	/**
	 * This is to view the category page
	 * 
	 * @return
	 */

	public String addCategory() {
		try {

			// categoryManagedBean.init();
		} catch (Exception e) {
			LOG.error("error at addCategory() in HomeManagedBean" + e.getMessage());
		}
		return "/views/category";
	}

	/**
	 * This is to view the sub category page
	 * 
	 * @return
	 */

	public String addSubCategory() {
		try {

			// subCategoryManagedBean.init();
		} catch (Exception e) {
			LOG.error("error at addSubCategory() in HomeManagedBean" + e.getMessage());
		}
		return "/views/subCategory";

	}

	/**
	 * This is to view the registration page
	 * 
	 * @return
	 */
	public String addEmployeeAction() {
		try {
			// addEmployeeManagedBean.init();
		} catch (Exception e) {
			LOG.error("error at addEmployeeAction() in HomeManagedBean" + e.getMessage());
		}
		return "/views/registration";
	}

	public String generateCoupons() {
		// generateCouponManagedBean.init();
		return "/views/generateCoupons";
	}

	public String promotionalSms() {
		// promotionalSmsManagedBean.init();
		return "/views/promotionalSms";
	}

	public String displayOrders() {
		ordersManagedBean.init();
		return "/views/displayOrders";
	}

	public String customerList() {
		// customerManagedBean.init();
		return "/views/customerList";
	}

	public String invoiceAction() {
		// invoiceManagedBean.init();
		return "/views/invoice";
	}

	public String cancel() {
		return "/views/adminPage";
	}
}
