package com.kanopus.workflow.facadeservices.dao;

import java.util.List;

import com.kanopus.workflow.facadeservices.restschemas.AuthUserResponse;
import com.kanopus.workflow.workflowfacade.entities.RolePrevilige;
import com.kanopus.workflow.workflowfacade.entities.UserAuth;
import com.kanopus.workflow.workflowfacade.entities.UserRole;
import com.kanopus.workflow.workflowfacade.entities.WorkflowRoleConfig;

public interface AuthenticateUserDao {
	
	public UserAuth findUserById(String userId);
	
	public UserAuth findUserByEmail(String emailId);
	
	public UserRole findRoleById(String userId);
	
	public RolePrevilige findRolePreviligeByRole(String roleCde);
	
	public List<WorkflowRoleConfig> findWorkflowRoleConfigByRole(String roleCde);
	
	public AuthUserResponse getAuthUserById(String userId);
	

}
