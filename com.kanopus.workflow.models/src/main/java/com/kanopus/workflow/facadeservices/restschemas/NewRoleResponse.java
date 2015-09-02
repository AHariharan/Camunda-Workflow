package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class NewRoleResponse implements Serializable {

	private static final long serialVersionUID = 3216446814442695421L;
	
	private String roleCde;
	private String responseMsg;
	
	
	public NewRoleResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewRoleResponse(String roleCde, String responseMsg) {
		super();
		this.roleCde = roleCde;
		this.responseMsg = responseMsg;
	}

	
	public String getRoleCde() {
		return roleCde;
	}

	public void setRoleCde(String roleCde) {
		this.roleCde = roleCde;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

}

