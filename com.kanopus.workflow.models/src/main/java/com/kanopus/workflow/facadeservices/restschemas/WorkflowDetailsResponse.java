package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkflowDetailsResponse implements Serializable {

	private static final long serialVersionUID = 3409880919336052929L;
	
	private String workflowProcessId;
	private String workflowName;
	private String businesskeyPrefix;
	private String businessKeySuffix;
	
	private List<WorkflowTaskBusinessFieldMap> workflowTaskBusinessFieldMap = new ArrayList<WorkflowTaskBusinessFieldMap>();
	
	private List<WorkflowStartSendMap> workflowStartSendMap = new ArrayList<WorkflowStartSendMap>();

	public WorkflowDetailsResponse() {
		super();
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

	public List<WorkflowTaskBusinessFieldMap> getWorkflowTaskBusinessFieldMap() {
		return workflowTaskBusinessFieldMap;
	}

	public void setWorkflowTaskBusinessFieldMap(
			List<WorkflowTaskBusinessFieldMap> workflowTaskBusinessFieldMap) {
		this.workflowTaskBusinessFieldMap = workflowTaskBusinessFieldMap;
	}

	public List<WorkflowStartSendMap> getWorkflowStartSendMap() {
		return workflowStartSendMap;
	}

	public void setWorkflowStartSendMap(
			List<WorkflowStartSendMap> workflowStartSendMap) {
		this.workflowStartSendMap = workflowStartSendMap;
	}
	
}
