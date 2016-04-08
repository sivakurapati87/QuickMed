package com.intuiture.qm.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

import com.intuiture.qm.managedbean.LoginManagedBean;

public class MyPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -5393954672455673892L;

	@Override
	public void afterPhase(PhaseEvent event) {
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println(origRequest.getRequestURI());
		FacesContext context = FacesContext.getCurrentInstance();
		LoginManagedBean loginManagedBean = context.getApplication().evaluateExpressionGet(context, "#{LoginBean}", LoginManagedBean.class);
		try {
//			if (loginManagedBean.getUserJson() != null) {
//				if (origRequest.getRequestURI().toLowerCase().contains("login")) {
//					if (loginManagedBean.getUserJson().getEmpType() != null && loginManagedBean.getUserJson().getEmpType().trim().length() > 0) {
//						if (loginManagedBean.getUserJson().getEmpType().equalsIgnoreCase(Constants.ADMIN)) {
//							FacesContext.getCurrentInstance().getExternalContext().redirect("adminPage.faces");
//							return;
//						}
//						if (loginManagedBean.getUserJson().getEmpType().equalsIgnoreCase(Constants.BILLING_AGENT)) {
//							FacesContext.getCurrentInstance().getExternalContext().redirect("billingAgentHomePage.faces");
//							return;
//						}
//						if (loginManagedBean.getUserJson().getEmpType().equalsIgnoreCase(Constants.CASHIER)) {
//							FacesContext.getCurrentInstance().getExternalContext().redirect("cashierHomePage.faces");
//							return;
//						}
//					}
//				}
//			}
			if (!origRequest.getRequestURI().endsWith("/QuickMedAdminWeb/") && !origRequest.getRequestURI().toLowerCase().contains("login")) {
				{

					if (loginManagedBean.getUserJson() == null) {
						FacesContext.getCurrentInstance().getExternalContext().redirect("login.faces");
						return;

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
