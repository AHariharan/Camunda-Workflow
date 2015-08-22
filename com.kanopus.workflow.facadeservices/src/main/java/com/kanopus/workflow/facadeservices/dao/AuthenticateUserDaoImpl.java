package com.kanopus.workflow.facadeservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.kanopus.workflow.facadeservices.restschemas.AuthUserResponse;
import com.kanopus.workflow.facadeservices.restschemas.RoleWorkflowMap;
import com.kanopus.workflow.workflowfacade.entities.RolePrevilige;
import com.kanopus.workflow.workflowfacade.entities.UserAuth;
import com.kanopus.workflow.workflowfacade.entities.UserRole;
import com.kanopus.workflow.workflowfacade.entities.WorkflowRoleConfig;


public class AuthenticateUserDaoImpl implements AuthenticateUserDao {
	
	private SessionFactory sessionFactory;
	
	public AuthenticateUserDaoImpl() {
		super();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public UserAuth findUserById(String userId) {
		List<UserAuth> userList = sessionFactory.getCurrentSession()
				.createQuery("from UserAuth where id.id = :var_id")
				.setString("var_id", userId)
				.list();
		
		if(userList.size() > 0) {
			UserAuth user = userList.get(0);			
			return user;
		} else
		   return null;
	}
	
	@SuppressWarnings("unchecked")
	public UserAuth findUserByEmail(String emailId) {
		List<UserAuth> list = sessionFactory.getCurrentSession()
				.createQuery("from UserAuth where emailAddress = :var_email")
				.setString("var_email", emailId)
				.list();
		
		if(list.size() > 0)
		   return list.get(0);
		else
		   return null;
	}
	
	@SuppressWarnings("unchecked")
	public UserRole findRoleById(String userId) {
		List<UserRole> roleList = sessionFactory.getCurrentSession()
				.createQuery("from UserRole where id.id = :var_id")
				.setString("var_id", userId)
				.list();
		
		if(roleList.size() > 0)
		   return roleList.get(0);
		else
		   return null;
	}
	
	@SuppressWarnings("unchecked")
	public RolePrevilige findRolePreviligeByRole(String roleCde) {
		List<RolePrevilige> rolePrevList = sessionFactory.getCurrentSession()
				.createQuery("from RolePrevilige where id.roleCde = :var_roleCde")
				.setString("var_roleCde", roleCde)
				.list();
		
		if(rolePrevList.size() > 0)
		   return rolePrevList.get(0);
		else
		   return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<WorkflowRoleConfig> findWorkflowRoleConfigByRole(String roleCde) {	
		List<WorkflowRoleConfig> workflowRoleList = new ArrayList<WorkflowRoleConfig>();	
		workflowRoleList = sessionFactory.getCurrentSession()
				.createQuery("from WorkflowRoleConfig where id.roleCde = :var_roleCde")
				.setString("var_roleCde", roleCde)
				.list();
		
		return workflowRoleList;
//		if(workflowRoleList.size() > 0)
//		   return workflowRoleList;
//		else
//		   return null;
	}
	
	
	public AuthUserResponse getAuthUserById(String userId) {
		AuthUserResponse authUserResp = new AuthUserResponse();
		
		UserAuth user = findUserById(userId);
		if(user != null) {
			authUserResp.setUserId(user.getId());
			authUserResp.setEmailAddress(user.getEmailAddress());
			authUserResp.setPassword(user.getPassword());
			authUserResp.setWorkflowRefUserId(user.getWorkflowRefUserid());
			authUserResp.setIsActive(user.getIsActive());
			authUserResp.setIsExpired(user.getIsExpired());
			authUserResp.setIsSuspended(user.getIsSuspended());
			authUserResp.setIsAuthorizationOnly(user.getIsAuthorizationOnly());
			
			UserRole userRole = findRoleById(user.getId());
			if(userRole != null) {
				authUserResp.setRoleCde(userRole.getRoleCde());
				
				RolePrevilige rolePrev = findRolePreviligeByRole(userRole.getRoleCde());
				if(rolePrev != null) {
					authUserResp.setCanStartCase(rolePrev.isCanStartCase());
					authUserResp.setCanSendMessage(rolePrev.isCanSendMessage());
					authUserResp.setCanClaimTask(rolePrev.isCanClaimTask());
					authUserResp.setCanViewOnlyTask(rolePrev.isCanViewonlyTask());
					authUserResp.setCanSearchTask(rolePrev.isCanSearchTask());
					authUserResp.setCanPurgeCase(rolePrev.isCanPurgeCase());
					authUserResp.setCanSuspendCase(rolePrev.isCanSuspendCase());
					authUserResp.setCanParticipateCase(rolePrev.isCanParticipateCase());
					authUserResp.setCanSeeReports(rolePrev.isCanSeeReports());
				}
				
				List<WorkflowRoleConfig> wfRolecfgList = findWorkflowRoleConfigByRole(userRole.getRoleCde());
				if(wfRolecfgList.size() > 0) {
					List<RoleWorkflowMap> roleWfList = new ArrayList<RoleWorkflowMap>();
					
					for(WorkflowRoleConfig wfRoleCfg: wfRolecfgList) {
						RoleWorkflowMap roleWf = new RoleWorkflowMap(wfRoleCfg.getId().getWorkflowProcessId(), 
								wfRoleCfg.getCanstartinstance(), 
								wfRoleCfg.getCansendmessage());
						roleWfList.add(roleWf);
					}
					authUserResp.setRoleWorkflowMap(roleWfList);
				}
				
				
			}
			
		}
		
		return authUserResp;
	}


}