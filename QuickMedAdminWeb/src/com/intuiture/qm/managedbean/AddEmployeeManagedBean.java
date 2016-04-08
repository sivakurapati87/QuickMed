//package com.intuiture.qm.managedbean;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//
//import org.apache.log4j.Logger;
//
//import com.intuiture.storetodoorgrocer.bean.AddEmployeeBean;
//import com.intuiture.storetodoorgrocer.json.UserJson;
//import com.intuiture.storetodoorgrocer.util.CommonUtil;
//import com.intuiture.storetodoorgrocer.util.Constants;
//import com.intuiture.storetodoorgrocer.util.SendEmail;
//import com.intuiture.storetodoorgrocer.util.TransformBeanToJson;
//
///**
// * This bean is for user registration page.
// * 
// * @author kssrao87
// *
// */
//@ManagedBean(name = "AddEmployeeBean")
//@SessionScoped
//public class AddEmployeeManagedBean extends AddEmployeeBean {
//	private final Logger logger = Logger.getLogger(AddEmployeeManagedBean.class);
//
//	/**
//	 * To get the all states
//	 */
//	public void init() {
//		try {
//			// setStatesList(CommonUtil.getLookupDetailsListByType(Constants.LookUp.GETLOOKUPDETAILSBYTYPE,
//			// Constants.STATESTYPE));
//			clearAction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Error at RegistrationBean init()" + e.getMessage());
//		}
//
//	}
//
//	/**
//	 * This is used to clear the fields in the registration page
//	 */
//
//	public void clearAction() {
//		try {
//			setMessage(null);
//			setPassword(null);
//			setReEnteredPwd(null);
//			setFullName(null);
//			setMobileNo(null);
//			setEmail(null);
//			setUserName(null);
//			setUserJson(null);
//			setEmpTypeComboList(CommonUtil.getLookupDetailsListByType(Constants.Lookup.LOOKUPDETAILSBYTYPE, Constants.EMPTYPE));
//			setEmployeeList(CommonUtil.getAllEmployees(Constants.Employee.GETALLEMPLOYEES));
//			setSelectedEmpType(0);
//		} catch (Exception e) {
//			// TODO: handle exception
//			logger.error("error at clearAction() in RegistrationManagedBean" + e.getMessage());
//		}
//	}
//
//	public String editEmployee() {
//		setFullName(getUserJson().getFullName());
//		setMobileNo(CommonUtil.convertLongToString(getUserJson().getMobileNumber()));
//		setUserName(getUserJson().getUserName());
//		setEmail(getUserJson().getEmail());
//		setSelectedEmpType(getUserJson().getEmpTypeId());
//		return "";
//	}
//
//	public String deleteEmployee() {
//		CommonUtil.deleteEmployee(getUserJson().getUserId());
//		setEmployeeList(CommonUtil.getAllEmployees(Constants.Employee.GETALLEMPLOYEES));
//		setUserJson(null);
//		return "";
//	}
//
//	/**
//	 * This method is to create an account for a new user
//	 * 
//	 * @return
//	 */
//	public String saveEmployee() {
//		try {
//			UserJson userJson = null;
//			setMessage(null);
//			Pattern emailPattern = Pattern.compile(Constants.EMAIL_PATTERN);
//			if (getSelectedEmpType() == 0) {
//				setMessage("Select Employee Type");
//				return "";
//			}
//			if (getEmail() != null && getEmail().trim().length() == 0) {
//				setMessage("Please enter Email");
//				logger.error("Please enter Email");
//				return "";
//			} else {
//				Matcher emailMatcher = emailPattern.matcher(getEmail());
//				if (!emailMatcher.matches()) {
//					setMessage("Invalid Email");
//					return "";
//				} else {
//					if (getUserJson() != null) {
//						if (!getUserJson().getEmail().equalsIgnoreCase(getEmail())) {
//							userJson = CommonUtil.emailRelatedAction(getEmail());
//						}
//					} else {
//						userJson = CommonUtil.emailRelatedAction(getEmail());
//					}
//
//					if (userJson != null) {
//						setMessage("Email Already Exists");
//						logger.error("Email Already Exists");
//						return "";
//					}
//				}
//			}
//			if (getPassword() != null && getPassword().trim().length() == 0) {
//				setMessage("Please enter Password");
//				return "";
//			}
//			if (getReEnteredPwd() != null && getReEnteredPwd().trim().length() == 0) {
//				setMessage("Please enter Confirm Password");
//				return "";
//			}
//			if (!getPassword().trim().equals(getReEnteredPwd().trim())) {
//				setMessage("Password and Confirm password mismatched");
//				return "";
//			}
//			if (getFullName() != null && getFullName().trim().length() == 0) {
//				setMessage("Please enter Full Name");
//				return "";
//			}
//			if (getMobileNo() != null && getMobileNo().trim().length() == 0) {
//				setMessage("Please enter Mobile No");
//				return "";
//			} else if (getMobileNo().trim().length() < 10) {
//				setMessage("Mobile No should be 10 digits");
//				return "";
//			}
//			FacesContext context = FacesContext.getCurrentInstance();
//			// Get all the registration bean instance
//			AddEmployeeManagedBean addEmployeeManagedBean = context.getApplication().evaluateExpressionGet(context, "#{AddEmployeeBean}", AddEmployeeManagedBean.class);
//			userJson = TransformBeanToJson.getUserJsonFromRegistrationBean(getUserJson() != null ? getUserJson() : new UserJson(), addEmployeeManagedBean);
//			Boolean isSubmitted = CommonUtil.submitRegistrationPage(userJson);
//			if (isSubmitted && getUserJson() == null) {
//				SendEmail.sentEmail(userJson.getEmail(), null);
//			}
//			init();
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Error at RegistrationBean saveEmployee()" + e.getMessage());
//		}
//
//		return "";
//	}
//}
