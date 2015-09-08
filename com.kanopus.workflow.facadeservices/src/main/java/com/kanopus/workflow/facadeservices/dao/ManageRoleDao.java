package com.kanopus.workflow.facadeservices.dao;

import com.kanopus.workflow.facadeservices.restschemas.NewRoleRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleResponse;

public interface ManageRoleDao {
	
	public NewRoleResponse createNewRole(NewRoleRequest roleReq);
}
