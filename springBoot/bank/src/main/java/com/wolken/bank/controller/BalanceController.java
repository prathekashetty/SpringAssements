package com.wolken.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.service.EmployeeService;

@RestController
public class BalanceController {

	private Logger logger=LoggerFactory.getLogger(BalanceController.class);
	@Autowired
	EmployeeService service;
	@GetMapping("getBalance")
	List<EmployeeDTO> getBalance()
	{
		logger.info("inside get balnce");
		List<EmployeeDTO> list=service.validateAndGetAll();
		logger.info(""+list);
		return list;
	}
	
	@GetMapping("getUserAccount")
	String getUserAccount()
	{
		logger.info("get user Account");
		return "User Account";
	}
	
	@GetMapping("getAccountNumber")
	String getAccountNumber()
	{
		logger.info("get user Account Number");
		return "User Account Number";
	}
	@GetMapping("getUserDetails")
	String getUserDetails()
	{
		logger.info("get UserDetails");
		return "User Details";
	}
	@GetMapping("getbyAddress")
	String getbyAddress()
	{
		logger.info("get user Address");
		return "user Address";
	}
}
