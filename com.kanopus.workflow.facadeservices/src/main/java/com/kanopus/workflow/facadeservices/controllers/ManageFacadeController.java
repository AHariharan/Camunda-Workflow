package com.kanopus.workflow.facadeservices.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanopus.workflow.facadeservices.dao.ManageRoleDaoImpl;
import com.kanopus.workflow.facadeservices.dao.ManageUserDaoImpl;
import com.kanopus.workflow.facadeservices.dao.ManageWorkflowDaoImpl;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleResponse;
import com.kanopus.workflow.facadeservices.restschemas.NewUserRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewUserResponse;
import com.kanopus.workflow.facadeservices.restschemas.NewWorkflowRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewWorkflowResponse;

@RestController
@RequestMapping(FacadeServiceURLs.FACADESERVICE_BASEURL)
public class ManageFacadeController {
	
	@Autowired
	private ManageRoleDaoImpl mngRoleDao;
	
	@Autowired
	private ManageUserDaoImpl mngUserDao;
	
	@Autowired
	private ManageWorkflowDaoImpl mngWorkflowDao;
	
	@Transactional
	@RequestMapping( value = FacadeServiceURLs.CREATE_ROLE, method = RequestMethod.POST)
	public @ResponseBody NewRoleResponse createNewRole(@RequestBody NewRoleRequest roleRequest)
	{
		System.out.println("Facade Service request for New Role :- " + roleRequest.getRoleCde());
		NewRoleResponse roleResp = mngRoleDao.createNewRole(roleRequest);
	
		return roleResp;
	}
	
	@Transactional
	@RequestMapping( value = FacadeServiceURLs.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody NewUserResponse createNewUser(@RequestBody NewUserRequest userReq)
	{
		System.out.println("Facade Service request for New User :- " + userReq.getId());
		NewUserResponse userResp = mngUserDao.createNewUser(userReq);
	
		return userResp;
	}
	
	@Transactional
	@RequestMapping( value = FacadeServiceURLs.CREATE_WORKFLOW, method = RequestMethod.POST)
	public @ResponseBody NewWorkflowResponse createNewWorkflow(@RequestBody NewWorkflowRequest wfReq)
	{
		System.out.println("Facade Service request for New Workflow :- " + wfReq.getWorkflowProcessId());
		NewWorkflowResponse wfResp = mngWorkflowDao.createWorkflow(wfReq);
	
		return wfResp;
	}
	
	@ExceptionHandler
	public String handleBadRequest(Exception ex,HttpServletRequest request)
	{
		System.out.println("*********** Incoming request : " + request);
		ex.printStackTrace();
		return ex.getMessage();
	}
	
}
