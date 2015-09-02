package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class NewUserRequest implements Serializable {

	private static final long serialVersionUID = 7381457477649209160L;
	
	private String id;
	private String roleCde;
	private String emailAddress;
	private String password;
	private String workflowRefUserid;
	private Boolean isActive;
	private Boolean isExpired;
	private Boolean isSuspended;
	private Boolean isAuthorizationOnly;
	
	public NewUserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewUserRequest(String id, String roleCde, String emailAddress,
			String password, String workflowRefUserid, Boolean isActive,
			Boolean isExpired, Boolean isSuspended, Boolean isAuthorizationOnly) {
		super();
		this.id = id;
		this.roleCde = roleCde;
		this.emailAddress = emailAddress;
		this.password = password;
		this.workflowRefUserid = workflowRefUserid;
		this.isActive = isActive;
		this.isExpired = isExpired;
		this.isSuspended = isSuspended;
		this.isAuthorizationOnly = isAuthorizationOnly;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleCde() {
		return roleCde;
	}

	public void setRoleCde(String roleCde) {
		this.roleCde = roleCde;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkflowRefUserid() {
		return workflowRefUserid;
	}

	public void setWorkflowRefUserid(String workflowRefUserid) {
		this.workflowRefUserid = workflowRefUserid;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}

	public Boolean getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(Boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public Boolean getIsAuthorizationOnly() {
		return isAuthorizationOnly;
	}

	public void setIsAuthorizationOnly(Boolean isAuthorizationOnly) {
		this.isAuthorizationOnly = isAuthorizationOnly;
	}
	
	

}
