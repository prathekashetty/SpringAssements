package com.wolken.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccountDTO {
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
