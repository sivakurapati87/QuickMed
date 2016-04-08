package com.intuiture.qm.util;

import java.math.BigDecimal;
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

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.intuiture.qm.json.LookUpDetailJson;

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
	 * This method is to convert different format string to date
	 * 
	 * @param str
	 * @return
	 */
	public static Date convertDiffferentFormatString(String str) {
		Date date = null;
		try {
			if (str != null && str.length() > 9) {
				SimpleDateFormat dateformat = null;
				String s1 = null;
				if (str.length() == 11) {
					dateformat = new SimpleDateFormat("dd-MMM-yyyy");
					s1 = str.subSequence(0, 11).toString();
				} else {
					dateformat = new SimpleDateFormat("yyyy-MM-dd");
					s1 = str.subSequence(0, 10).toString();
				}

				date = dateformat.parse(s1);
				date = convertStringToDate(convertDateToString(date));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return date;
	}

	/**
	 * This method is to compareTwoDate
	 * 
	 * @param strDate
	 * @return
	 */
	public static Integer compareTwoDates(Date date1, Date date2) {
		Integer comparisionValue = null;
		try {
			if (date1 != null && date2 != null) {
				comparisionValue = date1.compareTo(date2);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertStringToDate():" + e.getMessage());
		}
		return comparisionValue;
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

	// /**
	// * This method is to get the operators for the search field names
	// *
	// * @param fieldType
	// * @return
	// */
	// public static List<SearchComboJson> getSearchOperators(String fieldType)
	// {
	// List<SearchComboJson> list = new ArrayList<SearchComboJson>();
	// try {
	// String[] strDescr = { "Equals", "Starts With", "Ends With", "Contains" };
	// String[] strOperators = { "eq", "sw", "ew", "con" };
	// String[] numDescr = { "==", ">", ">=", "<", "<=", "!=" };
	// String[] numOperators = { "equal", "gt", "ge", "lt", "le", "ne" };
	// int length = fieldType.equalsIgnoreCase("str") ? strDescr.length :
	// numDescr.length;
	// for (int i = 0; i < length; i++) {
	// SearchComboJson json = new SearchComboJson();
	// if (fieldType.equalsIgnoreCase("str")) {
	// json.setLabel(strDescr[i]);
	// json.setValue(strOperators[i]);
	// } else {
	// json.setLabel(numDescr[i]);
	// json.setValue(numOperators[i]);
	// }
	// list.add(json);
	// }
	// } catch (Exception e) {
	// LOG.error("Error at getSearchOperators():" + e.getMessage());
	// e.printStackTrace();
	// }
	// return list;
	// }

	// private SimpleDateFormat sdf = new
	// SimpleDateFormat(Constants.DATEFORMAT);
	/**
	 * Splitting the email and get the userName
	 * 
	 * @param email
	 * @return
	 */
	public static String getUserNameFromEmail(String email) {
		String userName = null;
		if (email != null && email.trim().length() > 0) {
			String[] splittedEmail = email.split("@");
			userName = splittedEmail[0];
		}
		return userName;
	}

	/**
	 * Convert String to Long Value
	 * 
	 * @param str
	 * @return
	 */
	public static Long convertStringToLong(String str) {
		Long convertedStr = null;
		if (str != null && str.length() > 0) {
			convertedStr = Long.parseLong(str);
		}
		return convertedStr;
	}

	public static Double convertStringToDouble(String str) {
		Double convertedStr = null;
		if (str != null && str.length() > 0) {
			convertedStr = Double.parseDouble(str);
		}
		return convertedStr;
	}

	public static Integer convertStringToInteger(String str) {
		Integer convertedStr = null;
		if (str != null && str.length() > 0) {
			convertedStr = Integer.parseInt(str);
		}
		return convertedStr;
	}

	public static String convertLongToString(Long value) {
		String str = null;
		if (value != null) {
			str = String.valueOf(value);
		}
		return str;
	}

	public static String convertDoubleToString(Double value) {
		String str = null;
		if (value != null) {
			str = String.format("%.1f", value);
		}
		return str;
	}

	public static String convertIntegerToString(Integer value) {
		String str = null;
		if (value != null) {
			str = String.valueOf(value);
		}
		return str;
	}

	public static String convertDoubleToMoney(Double value) {
		String strMoney = null;
		if (value != null) {
			Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			strMoney = format.format(new BigDecimal(value));
		}
		return strMoney;
	}

	/**
	 * Concatenate the ids and get the string representation of ids
	 * 
	 * @param ids
	 * @return
	 */
	public static String concatinateIds(Integer[] ids) {
		String concatinatedIds = null;
		if (ids != null && ids.length > 0) {
			for (Integer id : ids) {
				if (concatinatedIds == null) {
					concatinatedIds = String.valueOf(id);
				} else {
					concatinatedIds += "," + id;
				}
			}
		}
		return concatinatedIds;
	}

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
			LOG.error("error at cryptWithMD5:" + e.getMessage());
			e.printStackTrace();
		}
		return encryptedString;
	}

	/**
	 * This is the method to encrypt the given String
	 * 
	 * @param string
	 * @return encrypted String
	 */
	// public static String passwordEncryption(String string) {
	// String encryptedString = null;
	// try {
	// Key key = generateKey();
	// Cipher c = Cipher.getInstance(Constants.ALGO);
	// c.init(Cipher.ENCRYPT_MODE, key);
	// byte[] encVal = c.doFinal(string.getBytes());
	// encryptedString = new BASE64Encoder().encode(encVal);
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error(e.getMessage());
	// }
	// return encryptedString;
	// }

	/**
	 * This method is to decrypt the encrypted String
	 * 
	 * @param encryptedString
	 * @return actual value of encrypted String
	 */
	// public static String passwordDecryption(String encryptedString) {
	// String decryptedString = null;
	// try {
	// Key key = generateKey();
	// Cipher c = Cipher.getInstance(Constants.ALGO);
	// c.init(Cipher.DECRYPT_MODE, key);
	// byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedString);
	// byte[] decValue = c.doFinal(decordedValue);
	// decryptedString = new String(decValue);
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error(e.getMessage());
	// }
	// return decryptedString;
	// }

	/**
	 * This method is to generate the key based on the selected Algorithm
	 * 
	 * @return
	 * @throws Exception
	 */
	// private static Key generateKey() throws Exception {
	// Key key = new SecretKeySpec(Constants.KEYVALUE, Constants.ALGO);
	// return key;
	// }

	/**
	 * Get the Lookup details values based on lookup value
	 * 
	 * @param lookUp
	 * @return
	 */
	public static List<LookUpDetailJson> getLookupDetailsListByType(String url, String type) {
		List<LookUpDetailJson> jsonList = new ArrayList<LookUpDetailJson>();
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<List<LookUpDetailJson>> typeRef = new ParameterizedTypeReference<List<LookUpDetailJson>>() {
			};// return type
			ResponseEntity<List<LookUpDetailJson>> result = restTemplate.exchange(url + "/" + type, HttpMethod.GET, null, typeRef);
			jsonList = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}

		return jsonList;
	}

	/**
	 * This method is to get the LookupdetailJson List by lookupDetailId
	 * 
	 * @param url
	 * @param type
	 * @param detailId
	 * @return
	 */
	public static List<LookUpDetailJson> lookupDetailsByPrevDetailId(String url, String type, Integer detailId) {
		List<LookUpDetailJson> jsonList = new ArrayList<LookUpDetailJson>();
		try {
			RestTemplate restTemplate = new RestTemplate();
			ParameterizedTypeReference<List<LookUpDetailJson>> typeRef = new ParameterizedTypeReference<List<LookUpDetailJson>>() {
			};// return type
			ResponseEntity<List<LookUpDetailJson>> result = restTemplate.exchange(url + "?type=" + type + "&detailId=" + detailId, HttpMethod.GET, null, typeRef);
			jsonList = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
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
			LOG.error(e.getMessage());
		}

		return lookUpMap;
	}

}
