package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class NewWorkflowResponse implements Serializable {

	private static final long serialVersionUID = 6788645558182174094L;
	
	private String workflowProcessId;
	private String responseMsg;
	
	public NewWorkflowResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewWorkflowResponse(String workflowProcessId, String responseMsg) {
		super();
		this.workflowProcessId = workflowProcessId;
		this.responseMsg = responseMsg;
	}

	public String getWorkflowProcessId() {
		return workflowProcessId;
	}

	public void setWorkflowProcessId(String workflowProcessId) {
		this.workflowProcessId = workflowProcessId;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	

}
