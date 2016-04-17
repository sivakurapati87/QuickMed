package com.intuiture.qm.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.intuiture.qm.bean.AddEmployeeBean;
import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.util.CommonUtil;
import com.intuiture.qm.util.Constants;
import com.intuiture.qm.util.TransformBeanToJson;

/**
 * This bean is for user registration page.
 * 
 * @author kssrao87
 *
 */
@ManagedBean(name = "AddEmployeeBean")
@SessionScoped
public class AddEmployeeManagedBean extends AddEmployeeBean {
	private final Logger logger = Logger.getLogger(AddEmployeeManagedBean.class);

	/**
	 * To get the all states
	 */
	public void init() {
		try {
			// setStatesList(CommonUtil.getLookupDetailsListByType(Constants.LookUp.GETLOOKUPDETAILSBYTYPE,
			// Constants.STATESTYPE));
			clearAction();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error at RegistrationBean init()" + e.getMessage());
		}

	}

	/**
	 * This is used to clear the fields in the registration page
	 */

	public void clearAction() {
		try {
			setMessage(null);
			setPassword(null);
			setReEnteredPwd(null);
			setUserName(null);
			setAdminJson(null);
			setEmployeeList(CommonUtil.getAllEmployees(Constants.AdminLoginController.GETALLEMPLOYEES));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error at clearAction() in RegistrationManagedBean" + e.getMessage());
		}
	}

	public String editEmployee() {
		setUserName(getAdminJson().getUserName());
		return "";
	}

	public String deleteEmployee() {
		CommonUtil.deleteEmployee(getAdminJson().getAdminId());
		setEmployeeList(CommonUtil.getAllEmployees(Constants.AdminLoginController.GETALLEMPLOYEES));
		setAdminJson(null);
		return "";
	}

	/**
	 * This method is to create an account for a new user
	 * 
	 * @return
	 */
	public String saveEmployee() {
		try {
			AdminJson userJson = null;
			setMessage(null);
			if (getUserName() != null && getUserName().trim().length() == 0) {
				setMessage("Please enter User Name");
				logger.error("Please enter User Name");
				return "";
			} else {
				if (getAdminJson() != null) {
					if (!getAdminJson().getUserName().equalsIgnoreCase(getUserName())) {
						userJson = CommonUtil.emailRelatedAction(getUserName());
					}
				} else {
					userJson = CommonUtil.emailRelatedAction(getUserName());
				}

				if (userJson != null) {
					setMessage("User Name Already Exists");
					logger.error("User Name Already Exists");
					return "";
				}
			}
			if (getPassword() != null && getPassword().trim().length() == 0) {
				setMessage("Please enter Password");
				return "";
			}
			if (getReEnteredPwd() != null && getReEnteredPwd().trim().length() == 0) {
				setMessage("Please enter Confirm Password");
				return "";
			}
			if (!getPassword().trim().equals(getReEnteredPwd().trim())) {
				setMessage("Password and Confirm password mismatched");
				return "";
			}
			FacesContext context = FacesContext.getCurrentInstance();
			// Get all the registration bean instance
			AddEmployeeManagedBean addEmployeeManagedBean = context.getApplication().evaluateExpressionGet(context, "#{AddEmployeeBean}", AddEmployeeManagedBean.class);
			userJson = TransformBeanToJson.getUserJsonFromRegistrationBean(getAdminJson() != null ? getAdminJson() : new AdminJson(), addEmployeeManagedBean);
			CommonUtil.submitRegistrationPage(userJson);
			init();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error at RegistrationBean saveEmployee()" + e.getMessage());
		}

		return "";
	}
}
