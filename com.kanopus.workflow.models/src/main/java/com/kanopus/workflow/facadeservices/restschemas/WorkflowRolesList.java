package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class WorkflowRolesList implements Serializable {
	
	private static final long serialVersionUID = 795962650035998221L;

	private String roleCde;
	private Boolean canStartInstance;
	private Boolean canSendMessage;
	
	public WorkflowRolesList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkflowRolesList(String roleCde, Boolean canStartInstance,
			Boolean canSendMessage) {
		super();
		this.roleCde = roleCde;
		this.canStartInstance = canStartInstance;
		this.canSendMessage = canSendMessage;
	}
	
	public String getRoleCde() {
		return roleCde;
	}
	public void setRoleCde(String roleCde) {
		this.roleCde = roleCde;
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
