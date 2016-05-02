package com.intuiture.qm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.security.Key;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

import com.intuiture.qm.entity.Category;
import com.intuiture.qm.entity.Item;
import com.intuiture.qm.entity.Module;
import com.intuiture.qm.entity.SubModule;
import com.intuiture.qm.json.ItemJson;

public class MethodUtil {
	private static Logger LOG = Logger.getLogger(MethodUtil.class);
	// private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private final static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public synchronized static String randomString() {
		StringBuilder sb = new StringBuilder();
		try {
			Random rnd = new Random();
			for (int i = 0; i < Constants.GEN_ID_INDEX; i++)
				sb.append(Constants.NUMBERS.charAt(rnd.nextInt(Constants.NUMBERS.length())));

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at randomString() in CommonUtil" + e.getMessage(), e);
		}
		return sb.toString();
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
			LOG.error("Error at passwordEncryption() in CommonUtil:" + e.getMessage(), e);
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
			LOG.error("Error at passwordDecryption() in CommonUtil:" + e.getMessage(), e);
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
			e.printStackTrace();
			LOG.error("Error at getUserNameFromEmail() in CommonUtil:" + e.getMessage(), e);
		}
		return userName;
	}

	public static void makeDirectory(File myFolder) {
		if (!myFolder.exists()) {
			try {
				myFolder.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static Long getMonthlyAmount(Long amount) {
		if (amount != null) {
			amount = amount / 12;
		}
		return amount;
	}

	public static List<Date> getWeeklyDatesList(String startingWeekDate) {
		Date startingWeekDay = convertStringToDate(startingWeekDate);
		return calculateWeeklyDatesList(startingWeekDay);
	}

	public static List<Date> calculateWeeklyDatesList(Date startDate) {
		List<Date> datesList = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 7; i++) {
			cal.setTime(startDate);
			cal.add(Calendar.DATE, i);
			datesList.add(cal.getTime());
		}
		return datesList;
	}

	public static List<Date> getWeeklyDatesByAnyStartDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) - 1));
		return calculateWeeklyDatesList(cal.getTime());
	}

	public static List<Date> findDatesList(Date startingDate, Date endingDate) {
		List<Date> datesList = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startingDate);
		datesList.add(cal.getTime());
		if (endingDate != null) {
			int i = 1;
			while (cal.getTime().compareTo(endingDate) < 0) {
				cal.add(Calendar.DATE, i);
				datesList.add(cal.getTime());
			}
		}
		return datesList;
	}

	/*
	 * public static String uploadAnImage(String imageBase64) {
	 * BufferedOutputStream buffStream = null; Random ran = new Random(); String
	 * imageName = String.valueOf(100000 + ran.nextInt(900000)) + ".png"; try {
	 * byte[] bytes = new BASE64Decoder().decodeBuffer(imageBase64
	 * .split(",")[1]); File folder = new File(Constants.FILEUPLOADEDPATH);
	 * makeDirectory(folder); File newFile = new File(Constants.FILEUPLOADEDPATH
	 * + "\\" + imageName); buffStream = new BufferedOutputStream(new
	 * FileOutputStream(newFile)); buffStream.write(bytes); if (buffStream !=
	 * null) { buffStream.close(); } } catch (Exception e) {
	 * e.printStackTrace(); } return imageName; }
	 */

	public static synchronized String getStrBase64InputStream(String imageName) {
		String inputStreamToString = null;
		try {
			if (imageName != null) {
				String imageArray[] = imageName.split("\\.");
				File initialFile = new File(Constants.QUICKMED_UPLOADED_IMAGES_PATH + imageName);
				InputStream inputStream = new FileInputStream(initialFile);
				inputStreamToString = "data:image/" + imageArray[imageArray.length - 1] + ";base64," + new BASE64Encoder().encode(IOUtils.toByteArray(inputStream));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStreamToString;

	}

	public static List<Integer> splitStringInList(String idsInString) {
		Integer[] ids = splitString(idsInString);
		List<Integer> listOfIds = ids != null ? Arrays.asList(ids) : null;
		return listOfIds;
	}

	public static Integer convertStringToInteger(String str) {
		Integer convertedStr = null;
		if (str != null && str.length() > 0) {
			convertedStr = Integer.parseInt(str);
		}
		return convertedStr;
	}

	public static String convertIntegerToString(Integer value) {
		String str = null;
		if (value != null) {
			str = String.valueOf(value);
		}
		return str;
	}

	public static Integer[] splitString(String idsInString) {
		Integer[] ids = null;
		if (idsInString != null && idsInString.length() > 0) {
			String[] strIds = idsInString.split(",");
			ids = new Integer[strIds.length];
			for (int i = 0; i < strIds.length; i++) {
				ids[i] = Integer.parseInt(strIds[i]);
			}
		}
		return ids;
	}

	public static Date convertDiffferentFormatString(String str) {
		Date date = null;
		try {
			if (str != null && str.length() > 9) {
				// SimpleDateFormat dateformat = null;
				String s1 = null;
				if (str.length() == 11) {
					// dateformat = new SimpleDateFormat("dd-MMM-yyyy");
					s1 = str.subSequence(0, 11).toString();
				} else {
					// dateformat = new SimpleDateFormat("yyyy-MM-dd");
					s1 = str.subSequence(0, 10).toString();
				}

				date = sdf.get().parse(s1);
				date = convertStringToDate(convertDateToString(date));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return date;
	}

	public static String convertDoubleToMoney(Double dbl) {
		String str = null;
		if (dbl != null) {
			Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			str = format.format(new BigDecimal(dbl));
			if (str != null && str.length() > 0) {
				str = str.split("\\.")[1];
			}
		}
		return str;
	}

	public static Long convertDoubleToLong(Double dbl) {
		Long value = null;
		if (dbl != null) {
			value = dbl.longValue();
		}
		return value;
	}

	public static String convertLongToMoney(Long ln) {
		String str = null;
		if (ln != null) {
			Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			str = format.format(ln);
			if (str != null && str.length() > 0) {
				str = str.split("\\.")[1];
			}
		}
		return str;
	}

	public static String concateStringValues(String[] strArray) {
		if (strArray != null && strArray.length > 0) {
			String strValue = null;
			for (String str : strArray) {
				if (strValue == null) {
					strValue = str;
				} else {
					strValue += "," + str;
				}
			}
			return strValue;
		}
		return null;
	}

	public static List<Integer> getListByString(String strvalue) {
		List<Integer> list = null;
		if (strvalue != null) {
			String[] strArray = strvalue.split(",");
			if (strArray != null && strArray.length > 0) {
				list = new ArrayList<Integer>();
				for (String str : strArray) {
					list.add(Integer.parseInt(str));
				}
			}
		}
		return list;
	}

	public static String getInputStream(String fileName, String filePath) {
		String inputStreamToString = null;
		try {
			File initialFile = new File(filePath + "\\" + fileName);
			InputStream inputStream = new FileInputStream(initialFile);
			inputStreamToString = IOUtils.toString(inputStream, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStreamToString;

	}

	public static String[] getListOfStringsByIntArray(Integer[] listOfIds, Map<Integer, String> idWithDescriptionMap) {
		String[] strAmenities = null;
		if (listOfIds != null && listOfIds.length > 0) {
			strAmenities = new String[listOfIds.length];
			for (int i = 0; i < listOfIds.length; i++) {
				strAmenities[i] = idWithDescriptionMap.get(listOfIds[i]);
			}
		}
		return strAmenities;

	}

	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null && strDate.trim().length() > 0) {
				date = sdf.get().parse(strDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertStringToDate() in TransformDomainToJson:" + e.getMessage(), e);
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
				strDate = sdf.get().format(date);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return strDate;
	}

	public static String sumTimes(final String[] timestampList) {
		long milliseconds = 0;

		final DateFormat dt = new SimpleDateFormat("HH:mm");
		dt.setLenient(false);
		if (timestampList != null && timestampList.length > 0) {
			try {
				final long timezoneOffset = dt.parse("00:00").getTime();
				for (final String t : timestampList) {
					milliseconds += (dt.parse(t).getTime() - timezoneOffset);
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		((SimpleDateFormat) dt).applyPattern(":mm");
		return new StringBuilder(8).append(milliseconds / 3600000).append(dt.format(new Date(milliseconds))).toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<?> readDataFromExcelFile(Integer sheetNumber) throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List list = determineTypeofListInstance(sheetNumber);
		FileInputStream inputStream = new FileInputStream(new File(Constants.QUICKMED_DATA_FILE_PATH));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(sheetNumber);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Object obj = null;
			if (nextRow.getRowNum() != 0) {
				// Creating instance based on the record insertion
				if (sheetNumber.equals(EnumUtils.MODULE.getValue())) {
					obj = new Module();
				}
				if (sheetNumber.equals(EnumUtils.SUBMODULE.getValue())) {
					obj = new SubModule();
				}
				if (sheetNumber.equals(EnumUtils.CATEGORY.getValue())) {
					obj = new Category();
				}
				if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
					obj = new Item();
				}

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						if (sheetNumber.equals(EnumUtils.MODULE.getValue())) {
							PropertyUtils.setProperty(obj, "moduleName", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.SUBMODULE.getValue())) {
							PropertyUtils.setProperty(obj, "subModuleName", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.CATEGORY.getValue())) {
							PropertyUtils.setProperty(obj, "categoryName", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "itemName", getCellValue(nextCell));
						}

						break;
					case 1:
						if (sheetNumber.equals(EnumUtils.MODULE.getValue())) {
							PropertyUtils.setProperty(obj, "moduleCode", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.SUBMODULE.getValue())) {
							PropertyUtils.setProperty(obj, "subModuleCode", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.CATEGORY.getValue())) {
							PropertyUtils.setProperty(obj, "categoryCode", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "categoryCode", getCellValue(nextCell));
						}
						break;
					case 2:
						if (sheetNumber.equals(EnumUtils.SUBMODULE.getValue())) {
							PropertyUtils.setProperty(obj, "moduleCode", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.CATEGORY.getValue())) {
							PropertyUtils.setProperty(obj, "subModuleCode", getCellValue(nextCell));
						}
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "price", getCellValue(nextCell));
						}
						break;
					case 3:
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "offer", getCellValue(nextCell));
						}
						break;
					case 4:
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "itemImageName", getCellValue(nextCell));
						}
						break;
					case 5:
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "isAvailable", getCellValue(nextCell));
						}
						break;
					case 6:
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "manufacturerName", getCellValue(nextCell));
						}
						break;
					case 7:
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "chemicalIngredient", getCellValue(nextCell));
						}
						break;
					case 8:
						if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
							PropertyUtils.setProperty(obj, "isPrescription", getCellValue(nextCell));
						}
						break;
					}

				}
				list.add(obj);
			}
		}

		workbook.close();
		inputStream.close();

		return list;
	}

	@SuppressWarnings("rawtypes")
	private static List determineTypeofListInstance(Integer sheetNumber) {
		List list = null;
		if (sheetNumber.equals(EnumUtils.MODULE.getValue())) {
			list = new ArrayList<Module>();
		}
		if (sheetNumber.equals(EnumUtils.SUBMODULE.getValue())) {
			list = new ArrayList<SubModule>();
		}
		if (sheetNumber.equals(EnumUtils.CATEGORY.getValue())) {
			list = new ArrayList<Category>();
		}
		if (sheetNumber.equals(EnumUtils.ITEM.getValue())) {
			list = new ArrayList<Item>();
		}
		return list;
	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:

			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			}
			return cell.getNumericCellValue();
		}

		return null;
	}

	public synchronized static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static double findOfferPrice(Double price, Double offer) {
		Double priceAfterDiscount = 0d;
		if (price != null) {
			if (offer == null) {
				offer = 1d;
			}
			priceAfterDiscount = ((price) - (price * (offer / 100)));
		}
		return priceAfterDiscount;
	}

	public static Map<String, List<ItemJson>> getACategoryWithItemsMap(List<Item> itemList, Map<String, List<ItemJson>> itemWithCategoryMap) {
		if (itemList != null && itemList.size() > 0) {
			itemWithCategoryMap = new LinkedHashMap<String, List<ItemJson>>();
			for (Item item : itemList) {
				ItemJson itemJson = TransformDomainToJson.getItemJson(item);
				if (itemJson.getCategoryName() != null) {
					if (itemWithCategoryMap.get(itemJson.getCategoryName()) != null) {
						itemWithCategoryMap.get(itemJson.getCategoryName()).add(itemJson);
					} else {
						List<ItemJson> itemJsonList = new ArrayList<ItemJson>();
						itemJsonList.add(itemJson);
						itemWithCategoryMap.put(itemJson.getCategoryName(), itemJsonList);
					}
				}
			}
		}
		return itemWithCategoryMap;
	}
}
