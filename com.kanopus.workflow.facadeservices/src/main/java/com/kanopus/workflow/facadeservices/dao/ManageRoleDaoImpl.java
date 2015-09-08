package com.kanopus.workflow.facadeservices.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.kanopus.workflow.facadeservices.restschemas.NewRoleRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleResponse;
import com.kanopus.workflow.workflowfacade.entities.RoleMaster;
import com.kanopus.workflow.workflowfacade.entities.RolePrevilige;

public class ManageRoleDaoImpl implements ManageRoleDao {
	
private SessionFactory sessionFactory;
	
	public ManageRoleDaoImpl() {
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
		
		String validity = validateRoleRequest(roleReq);	
		if( !(validity.equalsIgnoreCase("VALID")) ) {
			roleResp.setResponseMsg(validity);
			return roleResp;
		}
		
		try {
			List<RoleMaster> roleList = sessionFactory.getCurrentSession()
					.createQuery("from RoleMaster where id.roleCde = :var_roleCde")
			    	.setString("var_roleCde", roleReq.getRoleCde())
			    	.list();
			if(roleList.size() > 0) {
				roleResp.setResponseMsg("Failure: Role Already Exists");
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
	
	// Function to validate NewRoleRequest
	private String validateRoleRequest(NewRoleRequest roleReq) {
		String validMsg = "VALID";
		
		if(roleReq == null) {
			validMsg = "Failure: Empty Request";
			return validMsg;
		}
		
		if( (roleReq.getRoleCde() == null) || (roleReq.getRoleCde().equals("")) ) {
			validMsg = "Failure: Empty Role Code in request";
			return validMsg;
		}
		
		return validMsg;
	}
}