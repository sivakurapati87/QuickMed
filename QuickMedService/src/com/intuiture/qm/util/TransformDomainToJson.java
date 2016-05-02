package com.intuiture.qm.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.intuiture.qm.entity.AddToCart;
import com.intuiture.qm.entity.Admin;
import com.intuiture.qm.entity.Customer;
import com.intuiture.qm.entity.Item;
import com.intuiture.qm.entity.LookUpDetails;
import com.intuiture.qm.entity.Module;
import com.intuiture.qm.entity.SubModule;
import com.intuiture.qm.entity.TotalOrders;
import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.json.ComboJson;
import com.intuiture.qm.json.CustomerDeliveryAddressJson;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.json.ItemJson;
import com.intuiture.qm.json.LookUpDetailJson;
import com.intuiture.qm.json.ModuleJson;
import com.intuiture.qm.json.SubModuleJson;
import com.intuiture.qm.json.TotalOrdersJson;

public class TransformDomainToJson {
	private static Logger LOG = Logger.getLogger(TransformDomainToJson.class);

	public static ModuleJson getModuleJson(Module module) {
		ModuleJson moduleJson = new ModuleJson();
		try {
			moduleJson.setModuleCode(module.getModuleCode());
			moduleJson.setModuleName(module.getModuleName());
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getModuleJson" + e.getMessage(), e);
		}
		return moduleJson;
	}

	public static SubModuleJson getSubModuleJson(SubModule subModule) {
		SubModuleJson subModuleJson = new SubModuleJson();
		try {
			subModuleJson.setModuleCode(subModule.getModuleCode());
			subModuleJson.setSubModuleCode(subModule.getSubModuleCode());
			subModuleJson.setSubModuleName(subModule.getSubModuleName());
			if (subModule.getModule() != null) {
				subModuleJson.setModuleName(subModule.getModule().getModuleName().trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getSubModuleJson" + e.getMessage(), e);
		}
		return subModuleJson;
	}

	public static ItemJson getItemJson(Item item) {
		ItemJson itemJson = new ItemJson();
		try {
			itemJson.setItemId(item.getItemId());
			itemJson.setCategoryCode(item.getCategoryCode());
			itemJson.setIsAvailable(item.getIsAvailable());
			itemJson.setItemImageName(item.getItemImageName());
			itemJson.setItemImageBase64(MethodUtil.getStrBase64InputStream(item.getItemImageName()));
			itemJson.setItemName(item.getItemName());
			itemJson.setManufacturerName(item.getManufacturerName());
			itemJson.setOffer(item.getOffer());
			itemJson.setPrice(item.getPrice());
			itemJson.setChemicalIngradient(item.getChemicalIngredient());
			itemJson.setComboJsonList(getComboJsonList(itemJson.getPrice(), itemJson.getOffer()));
			if (item.getCategory() != null) {
				itemJson.setCategoryName(item.getCategory().getCategoryName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getSubModuleJson" + e.getMessage(), e);
		}
		return itemJson;
	}

	public static List<ComboJson> getComboJsonList(Double price, Double offer) {
		List<ComboJson> comboJsonList = new ArrayList<ComboJson>();

		for (int i = 1; i <= 10; i++) {
			ComboJson json = new ComboJson();
			json.setValue(i);
			json.setDescription(i + " - " + MethodUtil.round(MethodUtil.findOfferPrice(i * price, offer), 2));
			json.setActualPrice(MethodUtil.round((i * price), 2));
			json.setOfferPrice(MethodUtil.round(MethodUtil.findOfferPrice(i * price, offer), 2));
			comboJsonList.add(json);
		}

		return comboJsonList;
	}

	public static CustomerJson getCustomerJson(Customer customer) {
		CustomerJson customerJson = new CustomerJson();
		try {
			customerJson.setCustomerId(customer.getCustomerId());
			customerJson.setEmailId(customer.getEmailId());
			customerJson.setFirstName(customer.getFirstName());
			customerJson.setLastName(customer.getLastName());
			customerJson.setPhoneNumber(customer.getPhoneNumber());
			customerJson.setUserName(customer.getUserName());
			customerJson.setGender(customer.getGender());
			customerJson.setStrCreatedOn(MethodUtil.convertDateToString(customer.getCreatedOn()));
			customerJson.setStrDateOfBirth(MethodUtil.convertDateToString(customer.getDateOfBirth()));
			CustomerDeliveryAddressJson deliveryAddressJson = new CustomerDeliveryAddressJson();
			deliveryAddressJson.setCity(customer.getCity());
			deliveryAddressJson.setAddress(customer.getAddress());
			deliveryAddressJson.setState(customer.getState());
			deliveryAddressJson.setPincode(customer.getPincode());
			customerJson.setCustomerDeliveryAddressJson(deliveryAddressJson);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return customerJson;
	}

	public static AdminJson getAdminJson(Admin admin) {
		AdminJson adminJson = new AdminJson();
		try {
			adminJson.setAdminId(admin.getAdminId());
//			adminJson.setPassword(admin.getPassword());
			adminJson.setUserName(admin.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return adminJson;
	}

	public static LookUpDetailJson getLookUpDetailJson(LookUpDetails lookUpDetails) {
		LookUpDetailJson json = new LookUpDetailJson();
		try {

			if (lookUpDetails != null) {
				json.setDescription(lookUpDetails.getDescription());
				json.setLookupDetailId(lookUpDetails.getLookupDetailId());
				json.setParent(lookUpDetails.getParent());
				json.setLookupMasterId(lookUpDetails.getLookupMasterId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getLookUpDetailJson() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return json;
	}

	public static TotalOrdersJson getTotalOrdersJson(TotalOrders totalOrders) {
		TotalOrdersJson totalOrdersJson = new TotalOrdersJson();
		try {
			totalOrdersJson.setComments(totalOrders.getComments());
			totalOrdersJson.setCouponCodeId(totalOrders.getCouponCodeId());
			totalOrdersJson.setCustomerId(totalOrders.getCustomerId());
			totalOrdersJson.setDeliveryCharges(totalOrders.getDeliveryCharges());
			// totalOrdersJson.setDiscountMoney(totalOrders.getDiscountAmount());
			// totalOrdersJson.setTxnId(totalOrders.getTransactionId());
			totalOrdersJson.setIsDeleted(totalOrders.getIsDeleted());
			// totalOrdersJson.setOrderDate(totalOrders.getOrderDate());
			totalOrdersJson.setTypeOfOrder(totalOrders.getTypeOfOrder());
			totalOrdersJson.setSubTotal(MethodUtil.round(totalOrders.getSubTotal(), 2));
			totalOrdersJson.setTotalOrderId(totalOrders.getTotalOrderId());
			totalOrdersJson.setTotalAmount(totalOrders.getTotalAmount());
			totalOrdersJson.setDiscountAmount(totalOrders.getDiscountAmount());
			totalOrdersJson.setTotalOrderGenId(totalOrders.getTotalOrderGenId());
			// totalOrdersJson.setTypeOfOrderId(totalOrders.getTypeOfOrderId());
			totalOrdersJson.setImageName(Constants.PLUS);
			totalOrdersJson.setIsDelivered(totalOrders.getIsDelivered());
			totalOrdersJson.setStrOrderDate(MethodUtil.convertDateToString(totalOrders.getOrderDate()));
			totalOrdersJson.setTotalPurchase(MethodUtil.round(totalOrders.getSubTotal()
					+ (totalOrders.getDeliveryCharges() != null ? totalOrders.getDeliveryCharges() : 0d), 2));
			// totalOrdersJson.setIsTotalOrderSelected(Boolean.FALSE);
			totalOrdersJson.setIsItemInvoiced(totalOrders.getIsItemInvoiced());
			// totalOrdersJson.setLocationId(totalOrders.getLocationId());
			// if (totalOrders.getLocationDetails() != null) {
			// totalOrdersJson.setLocation(totalOrders.getLocationDetails().getDescription());
			// }
			if (totalOrders.getCustomerDeliveryAddress() != null) {
				totalOrdersJson.setDeliveryAddress(totalOrders.getCustomerDeliveryAddress().getAddress());
			}
			if (totalOrders.getCustomer() != null) {
				totalOrdersJson.setPhoneNumber(totalOrders.getCustomer().getPhoneNumber());
			}
			// if (totalOrders.getLookUpDetails() != null) {
			// totalOrdersJson.setTypeOfOrder(totalOrders.getLookUpDetails().getDescription());
			// }
			if (totalOrders.getCustomer() != null) {
				totalOrdersJson.setCustomerJson(getCustomerJson(totalOrders.getCustomer()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getTotalOrdersJsonFromTotalOrders() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return totalOrdersJson;
	}

	public static AddToCartJson getAddToCartJson(AddToCart addToCart) {
		AddToCartJson addToCartJson = new AddToCartJson();
		try {
			addToCartJson.setAddToCartId(addToCart.getAddToCartId());
			addToCartJson.setCustomerId(addToCart.getCustomerId());
			addToCartJson.setIsItemRemovedFromCart(addToCart.getIsItemRemovedFromCart());
			addToCartJson.setItemId(addToCart.getItemId());
			addToCartJson.setOrderDate(addToCart.getOrderDate());
			addToCartJson.setPrice(addToCart.getPrice());
			addToCartJson.setQuantity(addToCart.getQuantity());
			// addToCartJson.setSavings(addToCart.getSavings());
			addToCartJson.setTotalOrderId(addToCart.getTotalOrderId());
			addToCartJson.setSubTotal(addToCart.getSubTotal());
			// addToCartJson.setMinSavings(addToCart.getMinSavings());
			addToCartJson.setIsItemDelivered(addToCart.getIsItemDelivered());
			// addToCartJson.setIsCartItemSelected(Boolean.FALSE);
			if (addToCart.getItem() != null) {
				addToCartJson.setItemJson(getItemJson(addToCart.getItem()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getAddToCartJsonFromAddToCart() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return addToCartJson;
	}
}
