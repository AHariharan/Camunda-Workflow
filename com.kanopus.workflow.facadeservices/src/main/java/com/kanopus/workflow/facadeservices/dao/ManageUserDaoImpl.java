package com.kanopus.workflow.facadeservices.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.kanopus.workflow.facadeservices.restschemas.NewUserRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewUserResponse;
import com.kanopus.workflow.workflowfacade.entities.UserAuth;
import com.kanopus.workflow.workflowfacade.entities.UserRole;

public class ManageUserDaoImpl implements ManageUserDao {

	private SessionFactory sessionFactory;
	
	public ManageUserDaoImpl() {
		super();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
		
	@SuppressWarnings("unchecked")
	public NewUserResponse createNewUser(NewUserRequest userReq) {
		
		NewUserResponse userResp = new NewUserResponse();
		userResp.setId(userReq.getId());
		
		String validity = validateNewUserRequest(userReq);	
		if( !(validity.equalsIgnoreCase("VALID")) ) {
			userResp.setResponseMsg(validity);
			return userResp;
		}
		
		
		try {
			List<UserAuth> userAuthList = sessionFactory.getCurrentSession()
					.createQuery("from UserAuth where id.id = :var_id")
			    	.setString("var_id", userReq.getId())
			    	.list();
			if(userAuthList.size() > 0) {
				userResp.setResponseMsg("Failure: User Details Already Exists");
				return userResp;
			}
			List<UserRole> userRoleList = sessionFactory.getCurrentSession()
					.createQuery("from UserRole where id.id = :var_id")
			    	.setString("var_id", userReq.getId())
			    	.list();
			if(userRoleList.size() > 0) {
				userResp.setResponseMsg("Failure: User Role Details Already Exists");
				return userResp;
			}
			
			UserRole userRole = new UserRole(userReq.getId(), userReq.getRoleCde());
			UserAuth userAuth = new UserAuth(userReq.getId(), userReq.getEmailAddress(), userReq.getPassword(),
								userReq.getWorkflowRefUserid(), userReq.getIsActive(), userReq.getIsExpired(), 
								userReq.getIsSuspended(), userReq.getIsAuthorizationOnly());
			java.sql.Timestamp currDate = new java.sql.Timestamp(new java.util.Date().getTime());
			userAuth.setCreatedDate(currDate);
			userAuth.setUpdatedDate(currDate);
			
			sessionFactory.getCurrentSession().persist(userRole);
			sessionFactory.getCurrentSession().persist(userAuth);
			userResp.setResponseMsg("Success");
			
		} catch(Exception e) {
			e.printStackTrace();
			userResp.setResponseMsg("Failure");
			return userResp;
		}
		
		return userResp;
	}
	
	// Function to validate New User Request
	private String validateNewUserRequest(NewUserRequest userReq) {
		String validMsg = "VALID";
		
		if(userReq == null) {
			validMsg = "Failure: Empty Request";
			return validMsg;
		}
		
		if( (userReq.getId() == null) || (userReq.getId().equals("")) ) {
			validMsg = "Failure: Empty User Id in request";
			return validMsg;
		}
		
		if( (userReq.getRoleCde() == null) || (userReq.getRoleCde().equals("")) ) {
			validMsg = "Failure: Empty Role Code in request";
			return validMsg;
		}
		
		if( (userReq.getPassword() == null) || (userReq.getPassword().equals("")) ) {
			validMsg = "Failure: Password cannot be empty in request";
			return validMsg;
		}
		
		if(userReq.getIsActive() && userReq.getIsExpired() && userReq.getIsSuspended()) {
			validMsg = "Failure: User cannot be Active, Expired and Suspended at the same time.";
			return validMsg;
		}
		
		if( !(userReq.getIsActive() || userReq.getIsExpired() || userReq.getIsSuspended()) ) {
			validMsg = "Failure: User has to be either Active, Expired or Suspended.";
			return validMsg;
		}
			
		if( !(userReq.getIsActive() ^ userReq.getIsExpired() ^ userReq.getIsSuspended()) ) {
			validMsg = "Failure: User can be only Active / Expired / Suspended at a time.";
			return validMsg;
		}
		
		return validMsg;
	}
}
