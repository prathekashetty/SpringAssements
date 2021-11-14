package com.wolken.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class AccountEntity {
	@Id
	@GenericGenerator(name="Pratheeka", strategy ="increment")
	@GeneratedValue(generator="Pratheeka")
	
	private int id;
	private long accountNum;
	private String holderName;
	private long contactNumber;
	private String email;
	private String address;
	private String branchName;
	private String typeOfAccount;
	private double amount;
	private String status;
	private String nominee;
	private String gender;
	private String dob;

}
