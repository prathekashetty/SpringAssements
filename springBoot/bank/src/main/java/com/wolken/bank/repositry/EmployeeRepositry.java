package com.wolken.bank.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.bank.entity.EmployeeEntity;

public interface  EmployeeRepositry extends JpaRepository<EmployeeEntity, Integer> {

	EmployeeEntity findByName(String name);
	List<EmployeeEntity> findAll();
	EmployeeEntity findByDesignation(String designation);
	EmployeeEntity findBySalary(float salary);
}
