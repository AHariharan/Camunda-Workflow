package com.kanopus.workflow.facadeservices.dao;

import com.kanopus.workflow.facadeservices.restschemas.NewUserRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewUserResponse;

public interface ManageUserDao {
	
	public NewUserResponse createNewUser(NewUserRequest userReq);

}
