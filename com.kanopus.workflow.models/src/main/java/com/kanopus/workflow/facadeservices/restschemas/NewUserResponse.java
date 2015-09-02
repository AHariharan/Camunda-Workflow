package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class NewUserResponse implements Serializable {

	private static final long serialVersionUID = -4169151038254551325L;
	
	private String id;
	private String responseMsg;
	
	public NewUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewUserResponse(String id, String responseMsg) {
		super();
		this.id = id;
		this.responseMsg = responseMsg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	
	
	

}
