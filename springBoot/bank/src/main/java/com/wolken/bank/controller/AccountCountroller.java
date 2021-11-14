package com.wolken.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.AccountDTO;
import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.service.AccountService;

@RestController
public class AccountCountroller {

	private Logger logger=LoggerFactory.getLogger(BalanceController.class);
	@Autowired
	AccountService service;
	
	@PostMapping("createAccount")
	String create(@RequestBody AccountDTO dto)
	{
		String msg=null;
		try {
			logger.info(""+dto);
			msg=service.validateAndCreate(dto);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	     return msg;
	}
	
	@GetMapping("getAccountByBranchName")
	AccountDTO getByBranchName(@Param(value="branchName")String branchName)
		{
			AccountDTO dto = null;

			try {
				logger.info(branchName);
				dto = service.validateAndFindByBranchName(branchName);
			} catch (Exception e) {
				logger.error("========you have an exception  ===");
				logger.error(e.getMessage(), e.getClass());

			}
			return dto;
		}
	@PostMapping("depositAmount")
	String updateAmount(@RequestBody AccountDTO dto) {
		String msg = null;
		try {
			logger.info("inside Deposit amount"+dto);
			
			msg=service.validateAndDeposit(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	@PostMapping("withdrawAmount")
	String withdrawAmount(@RequestBody AccountDTO dto) {
		String msg = null;
		try {
			logger.info("inside Update"+dto);
			
			msg=service.validateAndWithdraw(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	@PostMapping("closeAccount")
	String closeAccount(@RequestBody AccountDTO dto) {
		String msg = null;
		try {
			logger.info("dto"+dto);
			
			msg=service.validateAccountStatus(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
}
