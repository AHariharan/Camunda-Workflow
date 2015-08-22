package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import java.util.Set;
//
//import com.kanopus.workflow.workflowfacade.entities.RolePrevilige;
//import com.kanopus.workflow.workflowfacade.entities.UserAuth;
//import com.kanopus.workflow.workflowfacade.entities.UserRole;

public class AuthUserResponse implements Serializable {

	private static final long serialVersionUID = -139944668012509L;
	
//	private UserAuth userAuth;
//	private UserRole userRole;
//	private RolePrevilige rolePrevilige;
	
	private String userId;
	private String emailAddress;
	private String password;
	private String workflowRefUserId;
	private Boolean isActive;
	private Boolean isExpired;
	private Boolean isSuspended;
	private Boolean isAuthorizationOnly;
	
	private String roleCde;
	
	private Boolean canStartCase;
	private Boolean canSendMessage;
	private Boolean canClaimTask;
	private Boolean canViewOnlyTask;
	private Boolean canSearchTask;
	private Boolean canPurgeCase;
	private Boolean canSuspendCase;
	private Boolean canParticipateCase;
	private Boolean canSeeReports;
	
	private List<RoleWorkflowMap> roleWorkflowMap = new ArrayList<RoleWorkflowMap>();
	
	public AuthUserResponse() {
		super();
		
	}


	public String getUserId() {
		return userId;
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


	public String getWorkflowRefUserId() {
		return workflowRefUserId;
	}


	public void setWorkflowRefUserId(String workflowRefUserId) {
		this.workflowRefUserId = workflowRefUserId;
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


	public String getRoleCde() {
		return roleCde;
	}


	public void setRoleCde(String roleCde) {
		this.roleCde = roleCde;
	}


	public Boolean getCanStartCase() {
		return canStartCase;
	}


	public void setCanStartCase(Boolean canStartCase) {
		this.canStartCase = canStartCase;
	}


	public Boolean getCanSendMessage() {
		return canSendMessage;
	}


	public void setCanSendMessage(Boolean canSendMessage) {
		this.canSendMessage = canSendMessage;
	}


	public Boolean getCanClaimTask() {
		return canClaimTask;
	}


	public void setCanClaimTask(Boolean canClaimTask) {
		this.canClaimTask = canClaimTask;
	}


	public Boolean getCanViewOnlyTask() {
		return canViewOnlyTask;
	}


	public void setCanViewOnlyTask(Boolean canViewOnlyTask) {
		this.canViewOnlyTask = canViewOnlyTask;
	}


	public Boolean getCanSearchTask() {
		return canSearchTask;
	}


	public void setCanSearchTask(Boolean canSearchTask) {
		this.canSearchTask = canSearchTask;
	}


	public Boolean getCanPurgeCase() {
		return canPurgeCase;
	}


	public void setCanPurgeCase(Boolean canPurgeCase) {
		this.canPurgeCase = canPurgeCase;
	}


	public Boolean getCanSuspendCase() {
		return canSuspendCase;
	}


	public void setCanSuspendCase(Boolean canSuspendCase) {
		this.canSuspendCase = canSuspendCase;
	}


	public Boolean getCanParticipateCase() {
		return canParticipateCase;
	}


	public void setCanParticipateCase(Boolean canParticipateCase) {
		this.canParticipateCase = canParticipateCase;
	}


	public Boolean getCanSeeReports() {
		return canSeeReports;
	}


	public void setCanSeeReports(Boolean canSeeReports) {
		this.canSeeReports = canSeeReports;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<RoleWorkflowMap> getRoleWorkflowMap() {
		return roleWorkflowMap;
	}


	public void setRoleWorkflowMap(List<RoleWorkflowMap> roleWorkflowMap) {
		this.roleWorkflowMap = roleWorkflowMap;
	}
	
	

}
