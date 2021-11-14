package com.wolken.bank.service;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.bank.dto.AccountDTO;
import com.wolken.bank.entity.AccountEntity;
import com.wolken.bank.repositry.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepo repo;

	private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public String validateAndCreate(AccountDTO dto) {
		try {
			if (dto != null) {
				logger.info("" + dto);
				AccountEntity entity = new AccountEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info("" + entity);
				repo.save(entity);
				logger.info("Account Created Successfully");
				return "Account Created Successfully";
			}

		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;

	}

	@Override
	public AccountDTO validateAndFindByBranchName(String branchName) {
		try {
			if (branchName != null) {
				logger.info(branchName);
				AccountEntity entity = repo.findByBranchName(branchName);
				logger.info("" + entity);
				if (entity != null) {
					AccountDTO dto = new AccountDTO();
					BeanUtils.copyProperties(entity, dto);
					return dto;
				}
			} else {
				logger.info("invalid branchName");
				return null;
			}
		} catch (Exception e) {
			logger.error("========you have an exception in ===");
			logger.error(e.getMessage(), e.getClass());

		}
		return null;
	}

	@Override
	public String validateAndDeposit(AccountDTO dto) {

		logger.info("" + repo.getAccountNum((long) 2));
		logger.info("" + dto);
		AccountEntity entity = new AccountEntity();
		if (dto != null) {
			entity = repo.getAccountNum(dto.getAccountNum());
			logger.info("" + entity);
			double total = repo.getAccountNum(dto.getAccountNum()).getAmount() + dto.getAmount();
			if (total > 0) {
				entity.setAmount(total);
				logger.info("" + entity.getAmount());
				repo.save(entity);
				return "amount saved";
			} else {
				logger.error("Enter valid amount");
			}
		} else {
			return null;
		}
		return null;

	}

	@Override
	public String validateAndWithdraw(AccountDTO dto) {
		logger.info("" + repo.getAccountNum((long) 2));
		logger.info("" + dto);
		AccountEntity entity = new AccountEntity();
		if (dto != null) {
			entity = repo.getAccountNum(dto.getAccountNum());
			logger.info("" + entity);
			double total = repo.getAccountNum(dto.getAccountNum()).getAmount() - dto.getAmount();
			if (total > 0) {
				entity.setAmount(total);
				logger.info("" + entity.getAmount());
				repo.save(entity);
				return "amount saved";
			} else {
				logger.error("Enter valid amount");
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public String validateAccountStatus(AccountDTO dto) {
		logger.info("" + repo.getAccountNum((long) 2));
		logger.info("" + dto);
		AccountEntity entity = new AccountEntity();
		if (dto != null) {
			entity = repo.getByAccountNo(dto.getAccountNum());
			logger.info("" + entity);
			// boolean total=dto.isStatus();
			// entity.setStatus(total);
			logger.info("" + entity.getAmount());
			repo.save(entity);
			return "Account Closed";
		} else {
			logger.error("Enter valid amount");
		}

		return null;
	}

}
