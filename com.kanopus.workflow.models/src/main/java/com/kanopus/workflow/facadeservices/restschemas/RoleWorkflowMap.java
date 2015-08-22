package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class RoleWorkflowMap implements Serializable {

	private static final long serialVersionUID = 2916888839552834415L;
	
	private String workflowProcessId;
	private Boolean canStartInstance;
	private Boolean canSendMessage;
	
	public RoleWorkflowMap() {
		super();
		
	}

	public RoleWorkflowMap(String workflowProcessId, Boolean canStartInstance,
			Boolean canSendMessage) {
		super();
		this.workflowProcessId = workflowProcessId;
		this.canStartInstance = canStartInstance;
		this.canSendMessage = canSendMessage;
	}

	public String getWorkflowProcessId() {
		return workflowProcessId;
	}

	public void setWorkflowProcessId(String workflowProcessId) {
		this.workflowProcessId = workflowProcessId;
	}

	public Boolean getCanStartInstance() {
		return canStartInstance;
	}

	public void setCanStartInstance(Boolean canStartInstance) {
		this.canStartInstance = canStartInstance;
	}

	public Boolean getCanSendMessage() {
		return canSendMessage;
	}

	public void setCanSendMessage(Boolean canSendMessage) {
		this.canSendMessage = canSendMessage;
	}
	
	
	
	
	
	

}
