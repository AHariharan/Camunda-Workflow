package com.kanopus.workflow.facadeservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.kanopus.workflow.facadeservices.restschemas.WorkflowDetailsResponse;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowStartSendMap;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowTaskBusinessFieldMap;
import com.kanopus.workflow.workflowfacade.entities.ManagedWorkflows;
import com.kanopus.workflow.workflowfacade.entities.WorkflowStartSendConfig;
import com.kanopus.workflow.workflowfacade.entities.WorkflowTaskBusinessFieldConfig;

public class ManageWorkflowDaoImpl implements ManageWorkflowDao {
	
	private SessionFactory sessionFactory;
	
	public ManageWorkflowDaoImpl() {
		super();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public ManagedWorkflows findManagedWorkflows(String workflowProcessId) {
		List<ManagedWorkflows> mngWfList = sessionFactory.getCurrentSession()
							.createQuery("from ManagedWorkflows where id.workflowProcessId = :var_id")
							.setString("var_id", workflowProcessId)
							.list();
		
		if(mngWfList.size() > 0) 
			return mngWfList.get(0);			
		else
			return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<WorkflowTaskBusinessFieldConfig> findTaskFieldConfigByWfProcess(String workflowProcessId) {
		List<WorkflowTaskBusinessFieldConfig> wfTaskList = new ArrayList<WorkflowTaskBusinessFieldConfig>();	
		wfTaskList = sessionFactory.getCurrentSession()
				.createQuery("from WorkflowTaskBusinessFieldConfig where workflowProcessId = :var_wfId")
				.setString("var_wfId", workflowProcessId)
				.list();
		
		return wfTaskList;
	}
	
	@SuppressWarnings("unchecked")
	public List<WorkflowStartSendConfig> findStartSendConfigByWfProcess(String workflowProcessId) {
		List<WorkflowStartSendConfig> wfStartSendList = new ArrayList<WorkflowStartSendConfig>();	
		wfStartSendList = sessionFactory.getCurrentSession()
				.createQuery("from WorkflowStartSendConfig where workflowProcessId = :var_wfId")
				.setString("var_wfId", workflowProcessId)
				.list();
		
		return wfStartSendList;
	}
	
	public WorkflowDetailsResponse getWorkflowDetails(String workflowProcessId) {
		 WorkflowDetailsResponse wfDetailsResp = new WorkflowDetailsResponse();
		 wfDetailsResp.setWorkflowProcessId(workflowProcessId);
		 
		 ManagedWorkflows mngWf = findManagedWorkflows(workflowProcessId);
		 if(mngWf != null) {
			 wfDetailsResp.setWorkflowName(mngWf.getWorkflowName());
			 wfDetailsResp.setBusinesskeyPrefix(mngWf.getBusinesskeyPrefix());
			 wfDetailsResp.setBusinessKeySuffix(mngWf.getBusinesskeySuffix());
			 
			 List<WorkflowTaskBusinessFieldConfig> wfTaskCfgList = findTaskFieldConfigByWfProcess(workflowProcessId);
			 if(wfTaskCfgList.size() > 0) {
				 List<WorkflowTaskBusinessFieldMap> wfTaskMapList = new ArrayList<WorkflowTaskBusinessFieldMap>();		 
				 for(WorkflowTaskBusinessFieldConfig wftaskCfgItem: wfTaskCfgList) {
					 WorkflowTaskBusinessFieldMap wfTaskMap = new WorkflowTaskBusinessFieldMap(wftaskCfgItem.getId(), 
							 								wftaskCfgItem.getTaskName(), wftaskCfgItem.getFieldName(), 
							 								wftaskCfgItem.getFieldDatatype(), wftaskCfgItem.getFieldDefaultValue());
					 wfTaskMapList.add(wfTaskMap);
				 }
				 wfDetailsResp.setWorkflowTaskBusinessFieldMap(wfTaskMapList);
				 
			 }
			 
			 List<WorkflowStartSendConfig> wfStartSendCfgList = findStartSendConfigByWfProcess(workflowProcessId);
			 if(wfStartSendCfgList.size() > 0) {
				 List<WorkflowStartSendMap> wfStartSendMapList = new ArrayList<WorkflowStartSendMap>();
				 
				 for(WorkflowStartSendConfig wfStartSendItem: wfStartSendCfgList) {
					 WorkflowStartSendMap wfStartSendMap = new WorkflowStartSendMap(wfStartSendItem.getVariableId(), 
							 				wfStartSendItem.getVariableName(), wfStartSendItem.getVariableDatatype(), 
							 				wfStartSendItem.getVarAdditonalObjtypename(), wfStartSendItem.getVarSerializationDataformat(),
							 				wfStartSendItem.getParentVarId(), wfStartSendItem.isIsMandatory(), wfStartSendItem.isIsStart(),
							 				wfStartSendItem.isIsSendmessage());
					 wfStartSendMapList.add(wfStartSendMap);
				 }
				 wfDetailsResp.setWorkflowStartSendMap(wfStartSendMapList);
			 }
		 }
		 
		 return wfDetailsResp;
		
	}

}
