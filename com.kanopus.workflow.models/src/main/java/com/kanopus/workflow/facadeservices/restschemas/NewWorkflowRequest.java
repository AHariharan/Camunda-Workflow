package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewWorkflowRequest implements Serializable {

	private static final long serialVersionUID = 4750075607881712471L;
	
	private String workflowProcessId;
	private String workflowName;
	private String businesskeyPrefix;
	private String businessKeySuffix;
	
	private List<WorkflowRolesList> rolesList = new ArrayList<WorkflowRolesList>();
	private List<WorkflowTasksList> tasksList = new ArrayList<WorkflowTasksList>();
	private List<WorkflowStartSendList> startSendList = new ArrayList<WorkflowStartSendList>();
	
	public NewWorkflowRequest() {
		super();
	}

	public NewWorkflowRequest(String workflowProcessId, String workflowName,
			String businesskeyPrefix, String businessKeySuffix,
			List<WorkflowRolesList> rolesList,
			List<WorkflowTasksList> tasksList,
			List<WorkflowStartSendList> startSendList) {
		super();
		this.workflowProcessId = workflowProcessId;
		this.workflowName = workflowName;
		this.businesskeyPrefix = businesskeyPrefix;
		this.businessKeySuffix = businessKeySuffix;
		this.rolesList = rolesList;
		this.tasksList = tasksList;
		this.startSendList = startSendList;
	}

	public String getWorkflowProcessId() {
		return workflowProcessId;
	}

	public void setWorkflowProcessId(String workflowProcessId) {
		this.workflowProcessId = workflowProcessId;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getBusinesskeyPrefix() {
		return businesskeyPrefix;
	}

	public void setBusinesskeyPrefix(String businesskeyPrefix) {
		this.businesskeyPrefix = businesskeyPrefix;
	}

	public String getBusinessKeySuffix() {
		return businessKeySuffix;
	}

	public void setBusinessKeySuffix(String businessKeySuffix) {
		this.businessKeySuffix = businessKeySuffix;
	}

	public List<WorkflowRolesList> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<WorkflowRolesList> rolesList) {
		this.rolesList = rolesList;
	}

	public List<WorkflowTasksList> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<WorkflowTasksList> tasksList) {
		this.tasksList = tasksList;
	}

	public List<WorkflowStartSendList> getStartSendList() {
		return startSendList;
	}

	public void setStartSendList(List<WorkflowStartSendList> startSendList) {
		this.startSendList = startSendList;
	}
	
	

}
