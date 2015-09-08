package com.kanopus.workflow.facadeservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.kanopus.workflow.facadeservices.restschemas.NewWorkflowRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewWorkflowResponse;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowDetailsResponse;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowStartSendList;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowStartSendMap;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowTaskBusinessFieldMap;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowRolesList;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowTasksList;
import com.kanopus.workflow.workflowfacade.entities.ManagedWorkflows;
import com.kanopus.workflow.workflowfacade.entities.RoleMaster;
import com.kanopus.workflow.workflowfacade.entities.WorkflowRoleConfig;
import com.kanopus.workflow.workflowfacade.entities.WorkflowRoleConfigId;
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

	public NewWorkflowResponse createWorkflow(NewWorkflowRequest wfReq) {
		
		NewWorkflowResponse wfResp = new NewWorkflowResponse();
		wfResp.setWorkflowProcessId(wfReq.getWorkflowProcessId());
		
		String validity = validateNewWorkflowRequest(wfReq);
		if( !(validity.equalsIgnoreCase("VALID")) ) {
			wfResp.setResponseMsg(validity);
			return wfResp;
		}
		
		try {
			
			java.sql.Timestamp currDate = new java.sql.Timestamp(new java.util.Date().getTime());
			ManagedWorkflows mngWorkflow = new ManagedWorkflows(wfReq.getWorkflowProcessId(), wfReq.getWorkflowName(),
										wfReq.getBusinesskeyPrefix(), wfReq.getBusinessKeySuffix(), currDate, currDate);
			sessionFactory.getCurrentSession().persist(mngWorkflow);
			
			if( (wfReq.getRolesList() != null) && (wfReq.getRolesList().size() > 0) ) {
				for(WorkflowRolesList wfRole: wfReq.getRolesList()) {
					
					WorkflowRoleConfigId  wfRoleCfgId = new WorkflowRoleConfigId(wfRole.getRoleCde(), wfReq.getWorkflowProcessId());
					WorkflowRoleConfig wfRoleConfig = new WorkflowRoleConfig(wfRoleCfgId, wfRole.getCanStartInstance(), wfRole.getCanSendMessage());
					sessionFactory.getCurrentSession().persist(wfRoleConfig);
				}
			}
			
			if( (wfReq.getTasksList() != null) && (wfReq.getTasksList().size() > 0) ) {
				for(WorkflowTasksList wfTask: wfReq.getTasksList()) {
					
					WorkflowTaskBusinessFieldConfig  wfTaskCfg = new WorkflowTaskBusinessFieldConfig(wfReq.getWorkflowProcessId(), wfTask.getTaskName(),
														wfTask.getFieldName(), wfTask.getFieldDatatype(), wfTask.getFieldDefaultValue());
					sessionFactory.getCurrentSession().persist(wfTaskCfg);
				}
			}
			
			if( (wfReq.getStartSendList() != null) && (wfReq.getStartSendList().size() > 0) ) {
				for(WorkflowStartSendList wfStartSend: wfReq.getStartSendList()) {
					
					WorkflowStartSendConfig  wfStartSendCfg = new WorkflowStartSendConfig(wfStartSend.getVariableId(), wfReq.getWorkflowProcessId(), 
															wfStartSend.getVariableName(), wfStartSend.getVariableDatatype(), 
															wfStartSend.getVarAdditionalObjtypename(), wfStartSend.getVarSerializationDataformat(), 
															wfStartSend.getParentVarId(), wfStartSend.isMandatory(), wfStartSend.isStart(), 
															wfStartSend.isSendMessage());
					sessionFactory.getCurrentSession().persist(wfStartSendCfg);
				}
			}
			
			wfResp.setResponseMsg("Success");
			
		} catch(Exception e) {
			e.printStackTrace();
			wfResp.setResponseMsg("Failure");
			return wfResp;
		}
		
		
		return wfResp;
	}
	
	
	// Function to validate New workflow request
	@SuppressWarnings("unchecked")
	private String validateNewWorkflowRequest(NewWorkflowRequest wfReq) {
		String validMsg = "VALID";
		
		if(wfReq == null) {
			validMsg = "Failure: Empty Request";
			return validMsg;
		}
		
		if( (wfReq.getWorkflowProcessId() == null) || (wfReq.getWorkflowProcessId().equals("")) ) {
			validMsg = "Failure: Empty Workflow Process Id in request";
			return validMsg;
		}
		
		try {
			// Validating Role codes.
			if( (wfReq.getRolesList() != null) && (wfReq.getRolesList().size() > 0) ) {
				for(WorkflowRolesList wfRole: wfReq.getRolesList()) {
					
					List<RoleMaster> rolesList = sessionFactory.getCurrentSession()
												.createQuery("from RoleMaster where id.roleCde = :var_roleCde")
												.setString("var_roleCde", wfRole.getRoleCde())
												.list();
					if( !(rolesList.size() > 0) ) {
						validMsg = "Failure: Role Code " + wfRole.getRoleCde() + " does not exist.";
						return validMsg;
					} 
					
					List<WorkflowRoleConfig> wfRoleCfgList = sessionFactory.getCurrentSession()
							.createQuery("from WorkflowRoleConfig where id.roleCde = :var_roleCde and id.workflowProcessId = :var_wfProcessId")
							.setString("var_roleCde", wfRole.getRoleCde())
							.setString("var_wfProcessId", wfReq.getWorkflowProcessId())
							.list();
					if(wfRoleCfgList.size() > 0) {
						validMsg = "Failure: Role Code " + wfRole.getRoleCde() + 
								" and WF Process ID " + wfReq.getWorkflowProcessId() + " already exists.";
						return validMsg;
					} 
				}
			}
			
			// Validating Workflow Process Id
			List<ManagedWorkflows> mngWfList = sessionFactory.getCurrentSession()
								.createQuery("from ManagedWorkflows where id.workflowProcessId = :var_workflowProcessId")
								.setString("var_workflowProcessId", wfReq.getWorkflowProcessId())
								.list();
			if(mngWfList.size() > 0) {
				validMsg = "Failure: Workflow process already exists.";
				return validMsg;
			}
			
			List<WorkflowTaskBusinessFieldConfig> wfTaskCfgList = sessionFactory.getCurrentSession()
								.createQuery("from WorkflowTaskBusinessFieldConfig where workflowProcessId = :var_workflowProcessId")
								.setString("var_workflowProcessId", wfReq.getWorkflowProcessId())
								.list();
			if(wfTaskCfgList.size() > 0) {
				validMsg = "Failure: Task-Field Config already contains this Workflow process.";
				return validMsg;
			}
			
			List<WorkflowStartSendConfig> wfStartSendCfgList = sessionFactory.getCurrentSession()
								.createQuery("from WorkflowStartSendConfig where workflowProcessId = :var_workflowProcessId")
								.setString("var_workflowProcessId", wfReq.getWorkflowProcessId())
								.list();
			if(wfStartSendCfgList.size() > 0) {
				validMsg = "Failure: Start Send Config already contains this Workflow process.";
				return validMsg;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			validMsg = "Failure: Generic Failure";
			return validMsg;
		}
		
		return validMsg;
	}

}
