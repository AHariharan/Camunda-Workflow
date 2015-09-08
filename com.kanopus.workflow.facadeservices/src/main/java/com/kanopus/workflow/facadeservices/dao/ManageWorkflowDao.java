package com.kanopus.workflow.facadeservices.dao;

import java.util.List;

import com.kanopus.workflow.facadeservices.restschemas.NewWorkflowRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewWorkflowResponse;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowDetailsResponse;
import com.kanopus.workflow.workflowfacade.entities.ManagedWorkflows;
import com.kanopus.workflow.workflowfacade.entities.WorkflowStartSendConfig;
import com.kanopus.workflow.workflowfacade.entities.WorkflowTaskBusinessFieldConfig;

public interface ManageWorkflowDao {
	
	public ManagedWorkflows findManagedWorkflows(String workflowProcessId);
	
	public List<WorkflowTaskBusinessFieldConfig> findTaskFieldConfigByWfProcess(String workflowProcessId);
	
	public List<WorkflowStartSendConfig> findStartSendConfigByWfProcess(String workflowProcessId);
	
	public WorkflowDetailsResponse getWorkflowDetails(String workflowProcessId);
	
	public NewWorkflowResponse createWorkflow(NewWorkflowRequest wfReq);

}
