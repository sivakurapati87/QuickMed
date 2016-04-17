package com.intuiture.qm.util;

import java.io.File;
import java.math.BigDecimal;
import java.security.Key;
import java.security.MessageDigest;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.json.CategoryJson;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.json.LookUpDetailJson;
import com.intuiture.qm.json.SearchComboJson;
import com.intuiture.qm.json.TotalOrdersJson;
import com.intuiture.qm.json.AdminJson;

@SuppressWarnings("restriction")
public class CommonUtil {
	private static final Logger LOG = Logger.getLogger(CommonUtil.class);
	private static MessageDigest md;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

	/**
	 * This method is to convert String to Date
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null && strDate.trim().length() > 0) {
				date = sdf.parse(strDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertStringToDate():" + e.getMessage());
		}
		return date;
	}

	/**
	 * This method is to convert Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString(Date date) {
		String strDate = null;
		try {
			if (date != null) {
				strDate = sdf.format(date);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString():" + e.getMessage());
		}
		return strDate;
	}

	/**
	 * This method is to get the operators for the search field names
	 * 
	 * @param fieldType
	 * @return
	 */
	public static List<SearchComboJson> getSearchOperators(String fieldType) {
		List<SearchComboJson> list = new ArrayList<SearchComboJson>();
		try {
			String[] strDescr = { "Equals", "Starts With", "Ends With", "Contains" };
			String[] strOperators = { "eq", "sw", "ew", "con" };
			String[] numDescr = { "==", ">", ">=", "<", "<=", "!=" };
			String[] numOperators = { "equal", "gt", "ge", "lt", "le", "ne" };
			int length = fieldType.equalsIgnoreCase("str") ? strDescr.length : numDescr.length;
			for (int i = 0; i < length; i++) {
				SearchComboJson json = new SearchComboJson();
				if (fieldType.equalsIgnoreCase("str")) {
					json.setLabel(strDescr[i]);
					json.setValue(strOperators[i]);
				} else {
					json.setLabel(numDescr[i]);
					json.setValue(numOperators[i]);
				}
				list.add(json);
			}
		} catch (Exception e) {
			LOG.error("Error at getSearchOperators():" + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * This is to get the user name from email
	 * 
	 * @param email
	 * @return
	 */

	public static String getUserNameFromEmail(String email) {
		String userName = null;
		try {

			String[] splittedEmail = email.split("@");
			userName = splittedEmail[0];
		} catch (Exception e) {
			LOG.error("error at getUserNameFromEmail() in CommonUtil" + e.getMessage());
		}
		return userName;
	}

	/**
	 * This is to convert string to long
	 * 
	 * @param str
	 * @return
	 */

	public static Long convertStringToLong(String str) {
		Long convertedStr = null;
		try {

			if (str != null && str.length() > 0) {
				convertedStr = Long.parseLong(str);
			}
		} catch (Exception e) {
			LOG.error("error at convertStringToLong() in CommonUtil" + e.getMessage());
		}
		return convertedStr;
	}

	/**
	 * This is to convert string to double
	 * 
	 * @param str
	 * @return
	 */

	public static Double convertStringToDouble(String str) {
		Double convertedStr = null;
		try {

			if (str != null && str.length() > 0) {
				convertedStr = Double.parseDouble(str);
			}
		} catch (Exception e) {
			LOG.error("error at convertStringToDouble() in CommonUtil" + e.getMessage());
		}
		return convertedStr;
	}

	/**
	 * This is to convert string to float
	 * 
	 * @param str
	 * @return
	 */

	public static Float convertStringToFloat(String str) {
		Float convertedStr = null;
		try {

			if (str != null && str.length() > 0) {
				convertedStr = Float.parseFloat(str);
			}
		} catch (Exception e) {
			LOG.error("error at convertStringToFloat() in CommonUtil" + e.getMessage());
		}
		return convertedStr;
	}

	/**
	 * This to convert string to integer
	 * 
	 * @param str
	 * @return
	 */

	public static Integer convertStringToInteger(String str) {
		Integer convertedStr = null;
		try {

			if (str != null && str.length() > 0) {
				convertedStr = Integer.parseInt(str);
			}
		} catch (Exception e) {
			LOG.error("error at convertStringToInteger() in CommonUtil" + e.getMessage());
		}
		return convertedStr;
	}

	/**
	 * This is to convert long to string
	 * 
	 * @param value
	 * @return
	 */

	public static String convertLongToString(Long value) {
		String str = null;
		try {

			if (value != null) {
				str = String.valueOf(value);
			}
		} catch (Exception e) {
			LOG.error("error at convertLongToString() in CommonUtil" + e.getMessage());
		}
		return str;
	}

	/**
	 * This is to convert float to string
	 * 
	 * @param value
	 * @return
	 */

	public static String convertFloatToString(Float value) {
		String str = null;
		try {

			if (value != null) {
				str = String.valueOf(value);
			}
		} catch (Exception e) {
			LOG.error("error at convertFloatToString() in CommonUtil" + e.getMessage());
		}
		return str;
	}

	/**
	 * This is to convert double to string
	 * 
	 * @param value
	 * @return
	 */

	public static String convertDoubleToString(Double value) {
		String str = null;
		try {

			if (value != null) {
				str = String.valueOf(value);
			}
		} catch (Exception e) {
			LOG.error("error at convertDoubleToString() in CommonUtil" + e.getMessage());
		}
		return str;
	}

	/**
	 * This is to convert integer to string
	 * 
	 * @param value
	 * @return
	 */

	public static String convertIntegerToString(Integer value) {
		String str = null;
		try {

			if (value != null) {
				str = String.valueOf(value);
			}
		} catch (Exception e) {
			LOG.error("error at convertIntegerToString() in CommonUtil" + e.getMessage());
		}
		return str;
	}

	/**
	 * This is to convert double to money
	 * 
	 * @param value
	 * @return
	 */

	public static String convertDoubleToMoney(Double value) {
		String strMoney = null;
		try {

			if (value != null) {
				Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
				strMoney = format.format(new BigDecimal(value));
			}
		} catch (Exception e) {
			LOG.error("error at convertDoubleToMoney() in CommonUtil" + e.getMessage());
		}
		return strMoney;
	}

	public static String concatinateIds(Integer[] ids) {
		String concatinatedIds = null;
		try {

			if (ids != null && ids.length > 0) {
				for (Integer id : ids) {
					if (concatinatedIds == null) {
						concatinatedIds = String.valueOf(id);
					} else {
						concatinatedIds += "," + id;
					}
				}
			}
		} catch (Exception e) {
			LOG.error("error at concatinateIds() in CommonUtil" + e.getMessage());
		}
		return concatinatedIds;
	}

	// // Find if email already exist or not
	// public static AdminJson getPasswordFromDB(String email) {
	// AdminJson userJson = null;
	// try {
	// RestTemplate restTemplate = new RestTemplate();
	// ParameterizedTypeReference<AdminJson> typeRef = new
	// ParameterizedTypeReference<AdminJson>() {
	// };
	// ResponseEntity<AdminJson> result =
	// restTemplate.exchange(Constants.Login.GETPWDACTION + "?email=" + email,
	// HttpMethod.GET, null, typeRef);
	// userJson = result.getBody();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error("error at emailRelatedAction() in CommonUtil" +
	// e.getMessage());
	// }
	//
	// return userJson;
	// }

	/**
	 * Encrypting the string with MD5
	 * 
	 * @param str
	 * @return
	 */
	public static String cryptWithMD5(String str) {
		String encryptedString = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = str.getBytes();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (byte b : digested) {
				sb.append(Integer.toHexString(0xff & b));
			}
			encryptedString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at cryptWithMD5() in CommonUtil" + e.getMessage());
		}
		return encryptedString;
	}

	/**
	 * This is the method to encrypt the given String
	 * 
	 * @param string
	 * @return encrypted String
	 */
	public static String passwordEncryption(String string) {
		String encryptedString = null;
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(Constants.ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(string.getBytes());
			encryptedString = new BASE64Encoder().encode(encVal);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at passwordEncryption() in CommonUtil" + e.getMessage());
		}
		return encryptedString;
	}

	/**
	 * This method is to decrypt the encrypted String
	 * 
	 * @param encryptedString
	 * @return actual value of encrypted String
	 */
	public static String passwordDecryption(String encryptedString) {
		String decryptedString = null;
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(Constants.ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedString);
			byte[] decValue = c.doFinal(decordedValue);
			decryptedString = new String(decValue);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at passwordDecryption() in CommonUtil" + e.getMessage());
		}
		return decryptedString;
	}

	/**
	 * This method is to generate the key based on the selected Algorithm
	 * 
	 * @return
	 * @throws Exception
	 */
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(Constants.KEYVALUE, Constants.ALGO);
		return key;
	}

	public static Boolean submitRegistrationPage(AdminJson userJson) {

		Boolean isSubmitted = Boolean.FALSE;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<AdminJson> httpEntity = new HttpEntity<AdminJson>(userJson, encodedHeader());
			ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
			};
			ResponseEntity<Boolean> result = restTemplate.exchange(Constants.AdminLoginController.REGISTRACTION, HttpMethod.POST, httpEntity, typeRef);
			isSubmitted = result.getBody();
		} catch (Exception e) {
			LOG.error("error at submitRegistrationPage() in CommonUtil" + e.getMessage());
		}
		return isSubmitted;

	}

	public static AdminJson loginAction(AdminJson json) {
		AdminJson userJson = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<AdminJson> httpEntity = new HttpEntity<AdminJson>(json, encodedHeader());
			ParameterizedTypeReference<AdminJson> typeRef = new ParameterizedTypeReference<AdminJson>() {
			};
			ResponseEntity<AdminJson> result = restTemplate.exchange(Constants.AdminLoginController.LOGINACTION, HttpMethod.POST, httpEntity, typeRef);
			userJson = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in loginAction()--> in CommonUtil" + e.getMessage());
		}
		return userJson;
	}

	public static MultiValueMap<String, String> encodedHeader() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		String plainCreds = "siva:kurapati";
		byte[] plainCredsBytes = plainCreds.getBytes();
		headers.add("Authorization", "Basic " + new BASE64Encoder().encode(plainCredsBytes));
		headers.add("Content-Type", "application/json");
		return headers;
	}

	/**
	 * Get the Lookup details values based on lookup value
	 * 
	 * @param <LookUpDetailJson>
	 * 
	 * @param lookUp
	 * @return
	 */
	public static List<LookUpDetailJson> getLookupDetailsListByType(String url, String lookuptype) {
		List<LookUpDetailJson> jsonList = new ArrayList<LookUpDetailJson>();
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<List<LookUpDetailJson>> typeRef = new ParameterizedTypeReference<List<LookUpDetailJson>>() {
			};
			ResponseEntity<List<LookUpDetailJson>> result = restTemplate.exchange(url + "/" + lookuptype, HttpMethod.GET, null, typeRef);
			jsonList = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at getLookupDetailsListByType() in CommonUtil" + e.getMessage());
		}

		return jsonList;
	}

	/**
	 * Get the Lookup details values based on lookup value
	 * 
	 * @param lookUp
	 * @return
	 */
	public static Map<String, List<LookUpDetailJson>> getLookupDetailsListByTypeList(String url, List<String> typeList) {
		Map<String, List<LookUpDetailJson>> lookUpMap = new HashMap<String, List<LookUpDetailJson>>();
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<Map<String, List<LookUpDetailJson>>> typeRef = new ParameterizedTypeReference<Map<String, List<LookUpDetailJson>>>() {
			};// return type
			HttpEntity<List<String>> httpEntity = new HttpEntity<List<String>>(typeList);//
			// request
			// // body
			ResponseEntity<Map<String, List<LookUpDetailJson>>> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, typeRef);
			lookUpMap = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getLookupDetailsListByTypeList() in DataServiceUtil:" + e.getMessage(), e);
		}

		return lookUpMap;
	}

	public static List<CategoryJson> getAllCategoryList() {
		List<CategoryJson> categoryJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<List<CategoryJson>> typeRef = new ParameterizedTypeReference<List<CategoryJson>>() {
			};
			ResponseEntity<List<CategoryJson>> result = restTemplate.exchange(Constants.Category.GETALLCATEGORIES, HttpMethod.GET, null, typeRef);
			categoryJsonList = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in loginAction()--> in CommonUtil" + e.getMessage());
		}
		return categoryJsonList;
	}

	public static Boolean submitOrUpdateCategory(CategoryJson json) {
		Boolean isRecordSubmitOrUpdated = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<CategoryJson> httpEntity = new HttpEntity<CategoryJson>(json);
			ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
			};
			ResponseEntity<Boolean> result = restTemplate.exchange(Constants.Category.SUBMITORUPDATECATEGORY, HttpMethod.POST, httpEntity, typeRef);
			isRecordSubmitOrUpdated = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in loginAction()--> in CommonUtil" + e.getMessage());
		}
		return isRecordSubmitOrUpdated;
	}

	public static Boolean deleteCategory(Integer categoryId) {
		Boolean isRecordDeleted = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
			};
			ResponseEntity<Boolean> result = restTemplate.exchange(Constants.Category.DELETECATEGORY + "/" + categoryId, HttpMethod.GET, null, typeRef);
			isRecordDeleted = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in loginAction()--> in CommonUtil" + e.getMessage());
		}
		return isRecordDeleted;
	}

	public static Boolean deleteAddItem(Integer addItemId) {
		Boolean isRecordDeleted = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
			};
			ResponseEntity<Boolean> result = restTemplate.exchange(Constants.AddItem.DELETEADDITEM + "/" + addItemId, HttpMethod.GET, null, typeRef);
			isRecordDeleted = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in loginAction()--> in CommonUtil" + e.getMessage());
		}
		return isRecordDeleted;
	}

	public static void makeDirectory(File myFolder) {
		if (!myFolder.exists()) {
			try {
				myFolder.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("error at makeDirectory() in CommonUtil" + e.getMessage());
			}

		}
	}

	public static CategoryJson getCategory(Integer categoryId) {
		CategoryJson json = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<CategoryJson> typeRef = new ParameterizedTypeReference<CategoryJson>() {
			};
			ResponseEntity<CategoryJson> result = restTemplate.exchange(Constants.Category.GETCATEGORY + "/" + categoryId, HttpMethod.GET, null, typeRef);
			json = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in loginAction()--> in CommonUtil" + e.getMessage());
		}
		return json;
	}

	public static Boolean sendPromotionalSms(String message, String phoneNumbers) {
		Boolean messageSent = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getForObject(Constants.SMSURL.replace("receivers", phoneNumbers) + message, String.class);
			messageSent = true;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at CommonUtil sendPromotionalSms():" + e.getMessage());
		}
		return messageSent;
	}

	public static List<AdminJson> getAllEmployees(String url) {
		List<AdminJson> empList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
			ParameterizedTypeReference<List<AdminJson>> typeRef = new ParameterizedTypeReference<List<AdminJson>>() {
			};
			ResponseEntity<List<AdminJson>> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, typeRef);
			empList = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at CommonUtil getAllEmployees():" + e.getMessage());
		}
		return empList;
	}

	// public static List<PromotionalSMSJson> getAllPromotionalSms() {
	// List<PromotionalSMSJson> promotionalSMSJsonList = null;
	// try {
	// RestTemplate restTemplate = new RestTemplate();
	// ParameterizedTypeReference<List<PromotionalSMSJson>> typeRef = new
	// ParameterizedTypeReference<List<PromotionalSMSJson>>() {
	// };
	// ResponseEntity<List<PromotionalSMSJson>> result =
	// restTemplate.exchange(Constants.PromotionalSms.GETALL_PRSMS,
	// HttpMethod.GET, null, typeRef);
	// promotionalSMSJsonList = result.getBody();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error("Error at CommonUtil getAllEmployees():" + e.getMessage());
	// }
	// return promotionalSMSJsonList;
	// }

	public static Boolean deleteEmployee(Integer empId) {
		Boolean isRecordDeleted = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
			ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
			};
			ResponseEntity<Boolean> result = restTemplate.exchange(Constants.Employee.DELETEEMPLOYEE + "/" + empId, HttpMethod.GET, httpEntity, typeRef);
			isRecordDeleted = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in deleteEmployee()--> in CommonUtil" + e.getMessage());
		}
		return isRecordDeleted;
	}

	// public static Boolean saveOrUpdateCoupon(CouponJson couponJson) {
	//
	// Boolean isSubmitted = Boolean.FALSE;
	// try {
	// RestTemplate restTemplate = new RestTemplate();
	// HttpEntity<CouponJson> httpEntity = new
	// HttpEntity<CouponJson>(couponJson);
	// ParameterizedTypeReference<Boolean> typeRef = new
	// ParameterizedTypeReference<Boolean>() {
	// };
	// ResponseEntity<Boolean> result =
	// restTemplate.exchange(Constants.Coupon.SAVEORUPDATECOUPON,
	// HttpMethod.POST, httpEntity, typeRef);
	// isSubmitted = result.getBody();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error("error at saveOrUpdateCoupon() in CommonUtil" +
	// e.getMessage());
	// }
	// return isSubmitted;
	//
	// }

	public static Boolean deleteCoupon(Integer couponId) {
		Boolean isRecordDeleted = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
			};
			ResponseEntity<Boolean> result = restTemplate.exchange(Constants.Coupon.DELETECOUPON + "/" + couponId, HttpMethod.GET, null, typeRef);
			isRecordDeleted = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in deleteEmployee()--> in CommonUtil" + e.getMessage());
		}
		return isRecordDeleted;
	}

	// public static List<CouponJson> getAllCouponList(String expiryDate) {
	// List<CouponJson> couponJsonList = null;
	// try {
	// RestTemplate restTemplate = new RestTemplate();
	// ParameterizedTypeReference<List<CouponJson>> typeRef = new
	// ParameterizedTypeReference<List<CouponJson>>() {
	// };
	// ResponseEntity<List<CouponJson>> result =
	// restTemplate.exchange(Constants.Coupon.GETALLCOUPONS + "?expiryDate=" +
	// expiryDate, HttpMethod.GET, null, typeRef);
	// couponJsonList = result.getBody();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error("Error occured in getAllCouponList()--> in CommonUtil" +
	// e.getMessage());
	// }
	// return couponJsonList;
	// }

	public static List<CustomerJson> getCustomerByTheirPurchase(String purchasedAmount) {
		List<CustomerJson> customerJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<List<CustomerJson>> typeRef = new ParameterizedTypeReference<List<CustomerJson>>() {
			};
			ResponseEntity<List<CustomerJson>> result = restTemplate.exchange(Constants.Customer.CUSTOMER_ON_PURCHASE + "?purchasedAmount=" + purchasedAmount,
					HttpMethod.GET, null, typeRef);
			customerJsonList = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in getCustomerByTheirPurchase()--> in CommonUtil" + e.getMessage());
		}
		return customerJsonList;
	}

	// public static Boolean submitPromotionalSMS(PromotionalSMSJson json) {
	// Boolean isRecordSubmitOrUpdated = false;
	// try {
	// RestTemplate restTemplate = new RestTemplate();
	// HttpEntity<PromotionalSMSJson> httpEntity = new
	// HttpEntity<PromotionalSMSJson>(json);
	// ParameterizedTypeReference<Boolean> typeRef = new
	// ParameterizedTypeReference<Boolean>() {
	// };
	// ResponseEntity<Boolean> result =
	// restTemplate.exchange(Constants.PromotionalSms.SAVE_PRSMS,
	// HttpMethod.POST, httpEntity, typeRef);
	// isRecordSubmitOrUpdated = result.getBody();
	//
	// } catch (Exception e) {
	// LOG.error("Error occured in loginAction()--> in CommonUtil" +
	// e.getMessage());
	// }
	// return isRecordSubmitOrUpdated;
	// }

	public static List<CustomerJson> getAllCustomerList(GridInfoJson gridInfoJson) {
		List<CustomerJson> customerJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<List<CustomerJson>> typeRef = new ParameterizedTypeReference<List<CustomerJson>>() {
			};
			HttpEntity<GridInfoJson> httpEntity = new HttpEntity<GridInfoJson>(gridInfoJson, encodedHeader());//
			ResponseEntity<List<CustomerJson>> result = restTemplate.exchange(Constants.Customer.GET_ALL_CUSTOMERS, HttpMethod.POST, httpEntity, typeRef);
			customerJsonList = result.getBody();

		} catch (Exception e) {
			LOG.error("Error occured in getAllCustomerList()--> in CommonUtil" + e.getMessage());
		}
		return customerJsonList;
	}

	public static List<TotalOrdersJson> getAllTotalOrdersJsonList(String url, GridInfoJson gridInfoJson) {
		List<TotalOrdersJson> totalOrdersJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<GridInfoJson> httpEntity = new HttpEntity<GridInfoJson>(gridInfoJson, encodedHeader());
			ParameterizedTypeReference<List<TotalOrdersJson>> typeRef = new ParameterizedTypeReference<List<TotalOrdersJson>>() {
			};
			// HttpEntity<GridInfoJson> httpEntity = new
			// HttpEntity<GridInfoJson>(gridInfoJson);
			ResponseEntity<List<TotalOrdersJson>> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, typeRef);
			totalOrdersJsonList = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in getAllTotalOrdersJsonList()--> in CommonUtil" + e.getMessage(), e);
		}
		return totalOrdersJsonList;
	}

	public static List<TotalOrdersJson> getAllTotalOrdersJsonList(String url) {
		List<TotalOrdersJson> totalOrdersJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
			ParameterizedTypeReference<List<TotalOrdersJson>> typeRef = new ParameterizedTypeReference<List<TotalOrdersJson>>() {
			};
			ResponseEntity<List<TotalOrdersJson>> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, typeRef);
			totalOrdersJsonList = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in getAllTotalOrdersJsonList()--> in CommonUtil" + e.getMessage(), e);
		}
		return totalOrdersJsonList;
	}

	public static List<AddToCartJson> getAllOrderedItemsCustomerId(Integer customerId, Integer totalOrderId) {
		List<AddToCartJson> addToCartJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
			ParameterizedTypeReference<List<AddToCartJson>> typeRef = new ParameterizedTypeReference<List<AddToCartJson>>() {
			};
			ResponseEntity<List<AddToCartJson>> result = restTemplate.exchange(Constants.AddToCartController.GETALLORDEREDITEMSBYCUSTOMERIDANDTOTALID + "?customerId="
					+ customerId + "&totalOrderId=" + totalOrderId, HttpMethod.GET, httpEntity, typeRef);
			addToCartJsonList = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in getAllOrderedItemsCustomerId()--> in CommonUtil" + e.getMessage(), e);
		}
		return addToCartJsonList;
	}

	public static void removeItemFromCart(String url, Integer cartId) {
		try {
			try {
				RestTemplate restTemplate = new RestTemplate();
				HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
				ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
				};
				ResponseEntity<Boolean> result = restTemplate.exchange(url + "/" + cartId, HttpMethod.GET, httpEntity, typeRef);
				System.out.println(result.getBody());
			} catch (Exception e) {
				LOG.error("Error occured in removeItemFromCart()--> in CommonUtil" + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	public static Integer sendTheOrderForDelivery(TotalOrdersJson totalOrdersJson) {
		Integer totalOrderId = null;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<TotalOrdersJson> httpEntity = new HttpEntity<TotalOrdersJson>(totalOrdersJson, encodedHeader());
		ParameterizedTypeReference<Integer> typeRef = new ParameterizedTypeReference<Integer>() {
		};
		ResponseEntity<Integer> result = restTemplate.exchange(Constants.TotalOrdersController.SENDTHEORDERFORDELIVERY, HttpMethod.POST, httpEntity, typeRef);
		totalOrderId = result.getBody();
		return totalOrderId;
	}

	public static void makeAnItemToDelivered(AddToCartJson addToCartJson) {
		try {
			try {
				RestTemplate restTemplate = new RestTemplate();
				ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
				};
				HttpEntity<AddToCartJson> httpEntity = new HttpEntity<AddToCartJson>(addToCartJson, encodedHeader());
				ResponseEntity<Boolean> result = restTemplate.exchange(Constants.AddToCartController.MAKEANITEMTODELIVERED, HttpMethod.POST, httpEntity, typeRef);
				System.out.println(result.getBody());
			} catch (Exception e) {
				LOG.error("Error occured in removeItemFromCart()--> in CommonUtil" + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	public static void removeTotalOrder(String url, Integer totalOrderId) {
		try {
			try {
				RestTemplate restTemplate = new RestTemplate();
				HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
				ParameterizedTypeReference<Boolean> typeRef = new ParameterizedTypeReference<Boolean>() {
				};
				ResponseEntity<Boolean> result = restTemplate.exchange(url + "/" + totalOrderId, HttpMethod.GET, httpEntity, typeRef);
				System.out.println(result.getBody());
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("Error occured in removeTotalOrder()--> in CommonUtil" + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	public static List<AddToCartJson> getAllDeliverableOrderItems(Integer totalOrderId) {
		List<AddToCartJson> addToCartJsonList = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> httpEntity = new HttpEntity<String>(encodedHeader());
			ParameterizedTypeReference<List<AddToCartJson>> typeRef = new ParameterizedTypeReference<List<AddToCartJson>>() {
			};
			ResponseEntity<List<AddToCartJson>> result = restTemplate.exchange(Constants.AddToCartController.GETALLDELIVERABLEORDERITEMS + "/" + totalOrderId,
					HttpMethod.GET, httpEntity, typeRef);
			addToCartJsonList = result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error occured in getAllDeliverableOrderItems()--> in CommonUtil" + e.getMessage(), e);
		}
		return addToCartJsonList;
	}

	public static Integer getNoOfItemsList(String url, GridInfoJson gridInfoJson) {
		Integer noOfRecords = null;
		try {

			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<Long> typeRef = new ParameterizedTypeReference<Long>() {
			};// return type
			HttpEntity<GridInfoJson> httpEntity = new HttpEntity<GridInfoJson>(gridInfoJson, encodedHeader());//
			ResponseEntity<Long> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, typeRef);
			Long noOfRecordsValue = result.getBody();
			noOfRecords = noOfRecordsValue.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}

		return noOfRecords;
	}

	// Find if email already exist or not
	public static AdminJson emailRelatedAction(String userName) {
		AdminJson userJson = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> entity = new HttpEntity<String>(encodedHeader());
			ParameterizedTypeReference<AdminJson> typeRef = new ParameterizedTypeReference<AdminJson>() {
			};
			ResponseEntity<AdminJson> result = restTemplate.exchange(Constants.AdminLoginController.CHECKUSERNAMEEXISTS + "?userName=" + userName, HttpMethod.GET,
					entity, typeRef);
			userJson = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at emailRelatedAction() in CommonUtil" + e.getMessage());
		}

		return userJson;
	}

}