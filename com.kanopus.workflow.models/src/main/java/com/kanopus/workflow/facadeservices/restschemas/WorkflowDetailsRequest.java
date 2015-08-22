package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class WorkflowDetailsRequest implements Serializable {

	private static final long serialVersionUID = 5493507530333539487L;
	
	private String workflowProcessId;

	public WorkflowDetailsRequest() {
		super();
	}

	public WorkflowDetailsRequest(String workflowProcessId) {
		super();
		this.workflowProcessId = workflowProcessId;
	}

	public String getWorkflowProcessId() {
		return workflowProcessId;
	}

	public void setWorkflowProcessId(String workflowProcessId) {
		this.workflowProcessId = workflowProcessId;
	}
	
	

}
