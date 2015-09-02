package com.kanopus.workflow.facadeservices.dao;

import com.kanopus.workflow.facadeservices.restschemas.NewRoleRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleResponse;

public interface ManageFacadeDao {
	
	public NewRoleResponse createNewRole(NewRoleRequest roleReq);

}
