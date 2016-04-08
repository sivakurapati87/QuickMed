package com.intuiture.qm.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.intuiture.qm.bean.LoginBean;
import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.util.CommonUtil;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginManagedBean extends LoginBean {
	private final static Logger LOG = Logger.getLogger(LoginManagedBean.class);

	/**
	 * This is to view the forget password page
	 * 
	 * @return
	 */

	public String forgotPasswordAction() {
		try {

		} catch (Exception e) {
			LOG.error("error at forgotPasswordAction() in LoginManagedBean" + e.getMessage());
		}
		return "/views/forgetPassword";
	}

	/**
	 * This method is the starting method to invoke to display login page
	 */
	@PostConstruct
	public void init() {
		try {
			// getAllLookUps();
			// setSelectedLocation(0);
			// setSelectedEmpType(0);
			setLogOutString(null);
			setMessage("");
			setUserName("");
			setPassword("");
			setIsUserLoggedIn(Boolean.FALSE);
			setIsLocationComboBoxDisplayed(Boolean.FALSE);
			setUserJson(null);
		} catch (Exception e) {
			LOG.error("error at init() in LoginManagedBean" + e.getMessage());
		}
	}

	/**
	 * This is to logout from the existing page and view the login page
	 * 
	 * @return
	 */

	public String logOutAction() {
		try {

			init();
		} catch (Exception e) {
			LOG.error("error at logOutAction() in  LoginManagedBean" + e.getMessage());
		}
		return "/views/login";
	}

	// /**
	// * This method is to get the password for an email
	// *
	// * @return
	// */
	// public String forgotPwdSubmitAction() {
	// try {
	// AdminJson userJson = CommonUtil.getPasswordFromDB(getUserName());
	// if (userJson != null) {
	// SendEmail.sentEmail(userJson.getEmail(),
	// CommonUtil.passwordDecryption(userJson.getPassword()));
	// }
	// init();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error("Error at forgotPwdSubmitAction()--> in LoginManagedBean" +
	// e.getMessage());
	// }
	// return "/views/login";
	// }

	/**
	 * This method is to perform login action
	 * 
	 * @return
	 */
	public String loginAction() {
		try {
			setMessage("");
			if (getUserName() != null && getUserName().trim().length() == 0) {
				setMessage("Please Enter User Name/Email ID");
				return "";
			}
			if (getPassword() != null && getPassword().trim().length() == 0) {
				setMessage("Please Enter Password");
				return "";
			}
			AdminJson userJson = new AdminJson();
			userJson.setUserName(getUserName());
			userJson.setPassword(CommonUtil.passwordEncryption(getPassword()));
			AdminJson adminJson = (AdminJson) CommonUtil.loginAction(userJson);
			if (adminJson != null) {
				setIsUserLoggedIn(Boolean.TRUE);
				setUserJson(adminJson);
				return "/views/adminPage";
			} else {
				setMessage("Invalide UserName/Email ID or Password");
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at loginAction()--> in LoginManagedBean" + e.getMessage());
		}

		return "";
	}

}
