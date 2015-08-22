package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class AuthUserRequest implements Serializable {

	private static final long serialVersionUID = 8905295314672800562L;
	
	private String userId;
	private String emailAddress;
	private String workflowRefUserId;
	
	
	public AuthUserRequest() {
		super();
	}


	public AuthUserRequest(String userId, String emailAddress,
			String workflowRefUserId) {
		super();
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.workflowRefUserId = workflowRefUserId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getWorkflowRefUserId() {
		return workflowRefUserId;
	}


	public void setWorkflowRefUserId(String workflowRefUserId) {
		this.workflowRefUserId = workflowRefUserId;
	}
	
	
	
	

}
