package com.intuiture.qm.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Constants {
	public static final Properties prop = new Properties();
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String DATEFORMAT = "dd-MMM-yyyy";
	public static final ResourceBundle RB = ResourceBundle.getBundle("config");
	public static final String SERVICEURL = RB.getString("RESTWebServiceUrl");
	public static final String CAPTCHASTRING = "012345abcdefghijklmnopqurstuvwxyz6789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALGO = "AES";
	public static final byte[] KEYVALUE = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
	public static final String CATEGORIES = "categories";
	public static final String PLUS = "plus.png";
	public static final String MINUS = "minus.png";
	public static final String UNITS = "units";
	public static final Integer REQUIREDHEIGHT = 320;
	public static final Integer REQUIREDWIDTH = 320;
	public static final String UPLOADEDIMAGESPATH = "\\STDGUploads\\images";
	public static final String SINGLEQUNATITY = "Single Quantity";
	public static final Integer RECORDSPERPAGE = 10;
	public static final Integer ITEMS_RECORDSPERPAGE = 30;
	public static final Integer ADMINID = 4;
	public static final Integer CASHIERID = 6;
	public static final Integer BILLINGID = 5;
	public static final String EMPTYPE = "employeeType";
	private static String URL = "http://182.18.174.18/quicksms/api.php?username=userName&password=pwd&to=receivers&from=ADARSH&message=";
	public static final String SMSURL = resource(URL);
	public static final String QUANTITIES = "Quantities";
	public static final String ADMIN = "Admin";
	public static final String BILLING_AGENT = "Billing Agent";
	public static final String CASHIER = "Cashier";
	public static final int AMOUNTEXCEEDSLIMIT = 1000;
	public static final double DELIVERYCHARGES = 50;
	public static final String LOCATIONS = "Locations";

	public static String resource(String url) {
		try {
			InputStream in = new FileInputStream("\\config.properties");
			prop.load(in);
			in.close();
			url = url.replace("userName", prop.getProperty("userName")).replace("pwd", prop.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return url;
	}

	public static class AdminLoginController {
		public static final String LOGINACTION = SERVICEURL + "/AdminLoginController/loginAction";
		public static final String GETPWDACTION = SERVICEURL + "/AdminLoginController/getPasswordAction";
	}

	public static class Employee {
		public static final String SUBMITREGISTRATIONPAGEACTION = SERVICEURL + "/EmployeeController/submitRegistrationPageAction";
		public static final String GETALLEMPLOYEES = SERVICEURL + "/EmployeeController/getAllEmployees";
		public static final String DELETEEMPLOYEE = SERVICEURL + "/EmployeeController/deleteEmployee";
	}

	public static class Lookup {
		public static final String LOOKUPDETAILSBYTYPE = SERVICEURL + "/LookUpController/getAllLookupDetailsByType";
		public static final String GETLOOKUPDETAILSBYTYPELIST = SERVICEURL + "/LookUpController/getAllLookupDetailsByTypeList";
	}

	public static class Category {
		public static final String GETALLCATEGORIES = SERVICEURL + "/CategoryController/getAllCategories";
		public static final String SUBMITORUPDATECATEGORY = SERVICEURL + "/CategoryController/submitCategory";
		public static final String DELETECATEGORY = SERVICEURL + "/CategoryController/deleteCategory";
		public static final String GETCATEGORY = SERVICEURL + "/CategoryController/getCategory";
	}

	public static class SubCategory {
		public static final String SUBMITORUPDATESUBCATEGORY = SERVICEURL + "/SubCategoryController/submitSubCategory";
		public static final String DELETESUBCATEGORY = SERVICEURL + "/SubCategoryController/deleteCategory";
	}

	public static class AddItem {
		public static final String SUBMITORUPDATEITEMINFO = SERVICEURL + "/AddItemController/submitItemInfo";
		public static final String GETALLADDITEMS = SERVICEURL + "/AddItemController/getAllAddItems";
		public static final String GETNOOFADDITEMS = SERVICEURL + "/AddItemController/getNoOfItems";
		public static final String DELETEADDITEM = SERVICEURL + "/AddItemController/deleteAddItem";
	}

	public static class Coupon {
		public static final String GETALLCOUPONS = SERVICEURL + "/CouponController/getAllCouponList";
		public static final String SAVEORUPDATECOUPON = SERVICEURL + "/CouponController/saveOrUpdateCoupon";
		public static final String DELETECOUPON = SERVICEURL + "/CouponController/deleteCoupon";
	}

	public static class PromotionalSms {
		public static final String GETALL_PRSMS = SERVICEURL + "/PromotionalSmsController/getAllPromotionalSms";
		public static final String SAVE_PRSMS = SERVICEURL + "/PromotionalSmsController/savePromotionalSms";
	}

	public static class Customer {
		public static final String CUSTOMER_ON_PURCHASE = SERVICEURL + "/CustomerController/getCustomerByTheirPurchase";
		public static final String GET_ALL_CUSTOMERS = SERVICEURL + "/CustomerController/getAllCustomer";
		public static final String GET_NO_CUSTOMERS = SERVICEURL + "/CustomerController/getNoOfCustomers";
	}

	public static class AddToCartController {
		public static final String SAVECART = SERVICEURL + "/AddToCartController/saveAddToCart";
		public static final String REMOVECART = SERVICEURL + "/AddToCartController/removeCartItem";
		public static final String REMOVECARTANDORDERITEM = SERVICEURL + "/AddToCartController/removeCartAndOrderItem";
		public static final String GETALLORDEREDITEMSBYCUSTOMERIDANDTOTALID = SERVICEURL + "/AddToCartController/getAllOrderedItemsCustomerIdAndTotalId";
		public static final String MAKEANITEMTODELIVERED = SERVICEURL + "/AddToCartController/makeAnItemToDelivered";
		public static final String GETALLDELIVERABLEORDERITEMS = SERVICEURL + "/AddToCartController/getAllDeliverableOrderItems";
	}

	public static class TotalOrdersController {
		public static final String GETTOTALORDERS = SERVICEURL + "/TotalOrdersController/getTotalOrders";
		public static final String SAVETOTALORDERS = SERVICEURL + "/TotalOrdersController/saveTotalOrders";
		public static final String REMOVETOTALORDER = SERVICEURL + "/TotalOrdersController/removeTotalOrder";
		public static final String GETDELIVERED_TOTALORDERS = SERVICEURL + "/TotalOrdersController/getDeliveredTotalOrders";
		public static final String REMOVEITEMFROMINVOICE = SERVICEURL + "/TotalOrdersController/removeItemFromInvoice";
	}
}
