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

import com.kanopus.workflow.facadeservices.dao.ManageFacadeDaoImpl;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleRequest;
import com.kanopus.workflow.facadeservices.restschemas.NewRoleResponse;

@RestController
@RequestMapping(FacadeServiceURLs.FACADESERVICE_BASEURL)
public class ManageFacadeController {
	
	@Autowired
	private ManageFacadeDaoImpl mngFacadeDao;
	
	@Transactional
	@RequestMapping( value = FacadeServiceURLs.CREATE_ROLE, method = RequestMethod.POST)
	public @ResponseBody NewRoleResponse createNewRole(@RequestBody NewRoleRequest roleRequest)
	{
		System.out.println("Facade Service request for New Role :- " + roleRequest.getRoleCde());
		NewRoleResponse roleResp = mngFacadeDao.createNewRole(roleRequest);
	
		return roleResp;
	}
	
	
	@ExceptionHandler
	public String handleBadRequest(Exception ex,HttpServletRequest request)
	{
		System.out.println("*********** Incoming request : " + request);
		ex.printStackTrace();
		return ex.getMessage();
	}
	
}
