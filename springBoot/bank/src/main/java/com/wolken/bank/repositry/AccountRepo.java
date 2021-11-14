package com.wolken.bank.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.bank.dto.AccountDTO;
import com.wolken.bank.entity.AccountEntity;
import com.wolken.bank.entity.EmployeeEntity;

public interface AccountRepo extends JpaRepository<AccountEntity, Integer>{

	AccountEntity findByBranchName(String branchName);
	AccountEntity getAccountNum(long l);
	AccountEntity getByAccountNo(long accountNum);



	

	

	

}
