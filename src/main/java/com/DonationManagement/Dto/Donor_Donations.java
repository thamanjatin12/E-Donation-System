package com.DonationManagement.Dto;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor_Donations {

	private int donation_id;
	private int donor_id;
	private int ngo_id;
	private String donation_type;
	private long amount;
	
	private String donor_name;
	private String donor_username;
	private String donor_password;
	private String donor_email;
	private Long donor_number;
	private String donor_address;
	

}
