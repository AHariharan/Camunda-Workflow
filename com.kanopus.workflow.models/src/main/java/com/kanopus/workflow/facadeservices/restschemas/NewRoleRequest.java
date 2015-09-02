package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class NewRoleRequest implements Serializable {

	private static final long serialVersionUID = 7482188412419961517L;
	
	private String roleCde;
	private String roleDesc;
	private boolean canStartCase;
	private boolean canSendMessage;
	private boolean canClaimTask;
	private boolean canViewonlyTask;
	private boolean canSearchTask;
	private boolean canPurgeCase;
	private boolean canSuspendCase;
	private boolean canParticipateCase;
	private boolean canSeeReports;
	
	public NewRoleRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewRoleRequest(String roleCde, String roleDesc,
			boolean canStartCase, boolean canSendMessage, boolean canClaimTask,
			boolean canViewonlyTask, boolean canSearchTask,
			boolean canPurgeCase, boolean canSuspendCase,
			boolean canParticipateCase, boolean canSeeReports) {
		super();
		this.roleCde = roleCde;
		this.roleDesc = roleDesc;
		this.canStartCase = canStartCase;
		this.canSendMessage = canSendMessage;
		this.canClaimTask = canClaimTask;
		this.canViewonlyTask = canViewonlyTask;
		this.canSearchTask = canSearchTask;
		this.canPurgeCase = canPurgeCase;
		this.canSuspendCase = canSuspendCase;
		this.canParticipateCase = canParticipateCase;
		this.canSeeReports = canSeeReports;
	}

	public String getRoleCde() {
		return roleCde;
	}

	public void setRoleCde(String roleCde) {
		this.roleCde = roleCde;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public boolean isCanStartCase() {
		return canStartCase;
	}

	public void setCanStartCase(boolean canStartCase) {
		this.canStartCase = canStartCase;
	}

	public boolean isCanSendMessage() {
		return canSendMessage;
	}

	public void setCanSendMessage(boolean canSendMessage) {
		this.canSendMessage = canSendMessage;
	}

	public boolean isCanClaimTask() {
		return canClaimTask;
	}

	public void setCanClaimTask(boolean canClaimTask) {
		this.canClaimTask = canClaimTask;
	}

	public boolean isCanViewonlyTask() {
		return canViewonlyTask;
	}

	public void setCanViewonlyTask(boolean canViewonlyTask) {
		this.canViewonlyTask = canViewonlyTask;
	}

	public boolean isCanSearchTask() {
		return canSearchTask;
	}

	public void setCanSearchTask(boolean canSearchTask) {
		this.canSearchTask = canSearchTask;
	}

	public boolean isCanPurgeCase() {
		return canPurgeCase;
	}

	public void setCanPurgeCase(boolean canPurgeCase) {
		this.canPurgeCase = canPurgeCase;
	}

	public boolean isCanSuspendCase() {
		return canSuspendCase;
	}

	public void setCanSuspendCase(boolean canSuspendCase) {
		this.canSuspendCase = canSuspendCase;
	}

	public boolean isCanParticipateCase() {
		return canParticipateCase;
	}

	public void setCanParticipateCase(boolean canParticipateCase) {
		this.canParticipateCase = canParticipateCase;
	}

	public boolean isCanSeeReports() {
		return canSeeReports;
	}

	public void setCanSeeReports(boolean canSeeReports) {
		this.canSeeReports = canSeeReports;
	}

}
