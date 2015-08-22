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

import com.kanopus.workflow.facadeservices.dao.AuthenticateUserDaoImpl;
import com.kanopus.workflow.facadeservices.dao.ManageWorkflowDaoImpl;
import com.kanopus.workflow.facadeservices.restschemas.AuthUserRequest;
import com.kanopus.workflow.facadeservices.restschemas.AuthUserResponse;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowDetailsRequest;
import com.kanopus.workflow.facadeservices.restschemas.WorkflowDetailsResponse;


@RestController
@RequestMapping(FacadeServiceURLs.FACADESERVICE_BASEURL)
public class FacadeAuthController {
	
	@Autowired
	private AuthenticateUserDaoImpl authUserDao;
	
	@Autowired
	private ManageWorkflowDaoImpl mngWorkflowDao;
	
	@Transactional
	@RequestMapping( value = FacadeServiceURLs.AUTH_USER, method = RequestMethod.POST)
	public @ResponseBody AuthUserResponse getAuthUser(@RequestBody AuthUserRequest authRequest)
	{
		System.out.println("Facade Service request received for id :- " + authRequest.getUserId());
		AuthUserResponse authUserResp = authUserDao.getAuthUserById(authRequest.getUserId());
	
		return authUserResp;
	}
	
	@Transactional
	@RequestMapping( value = FacadeServiceURLs.WORKFLOW_DETAILS, method = RequestMethod.POST)
	public @ResponseBody WorkflowDetailsResponse getWorkflowDetails(@RequestBody WorkflowDetailsRequest wfDetailsReq)
	{
		System.out.println("Facade Service request received for id :- " + wfDetailsReq.getWorkflowProcessId());
		WorkflowDetailsResponse wfDetailsResp = mngWorkflowDao.getWorkflowDetails(wfDetailsReq.getWorkflowProcessId());
	
		return wfDetailsResp;
	}
	
	
	
	@ExceptionHandler
	public String handleBadRequest(Exception ex,HttpServletRequest request)
	{
		System.out.println("*********** Incoming request : " + request);
		ex.printStackTrace();
		return ex.getMessage();
	}
		
	
	

}