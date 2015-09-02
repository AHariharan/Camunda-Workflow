package com.kanopus.workflow.facadeservices.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.kanopus.workflow.facadeservices.restschemas.NewRoleRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleResponse;
import com.kanopus.workflow.facadeservices.restschemas.NewUserRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewUserResponse;
import com.kanopus.workflow.workflowfacade.entities.RoleMaster;
import com.kanopus.workflow.workflowfacade.entities.RolePrevilige;
import com.kanopus.workflow.workflowfacade.entities.UserAuth;
import com.kanopus.workflow.workflowfacade.entities.UserRole;

public class ManageFacadeDaoImpl implements ManageFacadeDao {

	private SessionFactory sessionFactory;
	
	public ManageFacadeDaoImpl() {
		super();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public NewRoleResponse createNewRole(NewRoleRequest roleReq) {
		
		NewRoleResponse roleResp = new NewRoleResponse();
		roleResp.setRoleCde(roleReq.getRoleCde());
		try {
			List<RoleMaster> roleList = sessionFactory.getCurrentSession()
					.createQuery("from RoleMaster where id.roleCde = :var_roleCde")
			    	.setString("var_roleCde", roleReq.getRoleCde())
			    	.list();
			if(roleList.size() > 0) {
				roleResp.setResponseMsg("Role Already Exists");
				return roleResp;
			}
			RoleMaster roleMaster = new RoleMaster(roleReq.getRoleCde(), roleReq.getRoleDesc());
			RolePrevilige rolePrev = new RolePrevilige(roleReq.getRoleCde(), roleReq.isCanStartCase(),
											roleReq.isCanSendMessage(), roleReq.isCanClaimTask(),
											roleReq.isCanViewonlyTask(), roleReq.isCanSearchTask(),
											roleReq.isCanPurgeCase(), roleReq.isCanSuspendCase(),
											roleReq.isCanParticipateCase(), roleReq.isCanSeeReports());
			
			sessionFactory.getCurrentSession().persist(roleMaster);
			sessionFactory.getCurrentSession().persist(rolePrev);
			roleResp.setResponseMsg("Success");
			
		} catch(Exception e) {
			e.printStackTrace();
			roleResp.setResponseMsg("Failure");
			return roleResp;
		}
		
		return roleResp;
	}
	
	
	@SuppressWarnings("unchecked")
	public NewUserResponse createNewUser(NewUserRequest userReq) {
		
		NewUserResponse userResp = new NewUserResponse();
		userResp.setId(userReq.getId());
		try {
			List<UserAuth> userAuthList = sessionFactory.getCurrentSession()
					.createQuery("from UserAuth where id.id = :var_id")
			    	.setString("var_id", userReq.getId())
			    	.list();
			if(userAuthList.size() > 0) {
				userResp.setResponseMsg("User Details Already Exists");
				return userResp;
			}
			List<UserRole> userRoleList = sessionFactory.getCurrentSession()
					.createQuery("from UserRole where id.id = :var_id")
			    	.setString("var_id", userReq.getId())
			    	.list();
			if(userRoleList.size() > 0) {
				userResp.setResponseMsg("User Role Details Already Exists");
				return userResp;
			}
			
			UserAuth userAuth = new UserAuth(userReq.getId(), userReq.getEmailAddress(), userReq.getPassword(),
								userReq.getWorkflowRefUserid(), userReq.getIsActive(), userReq.getIsExpired(), 
								userReq.getIsSuspended(), userReq.getIsAuthorizationOnly());
			java.sql.Timestamp currDate = new java.sql.Timestamp(new java.util.Date().getTime());
			userAuth.setCreatedDate(currDate);
			userAuth.setUpdatedDate(currDate);
			
			UserRole userRole = new UserRole(userReq.getId(), userReq.getRoleCde());
			
			sessionFactory.getCurrentSession().persist(userAuth);
			sessionFactory.getCurrentSession().persist(userRole);
			userResp.setResponseMsg("Success");
			
		} catch(Exception e) {
			e.printStackTrace();
			userResp.setResponseMsg("Failure");
			return userResp;
		}
		
		return userResp;
	}
	
}
