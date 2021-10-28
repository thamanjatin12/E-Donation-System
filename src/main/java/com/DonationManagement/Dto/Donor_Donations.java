package com.DonationManagement.Dto;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


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
	
	public Donor_Donations(){
		
	}
	
	public Donor_Donations(int donation_id, int donor_id, int ngo_id, String donation_type, long amount,
			String donor_name, String donor_username, String donor_password, String donor_email, Long donor_number,
			String donor_address) {
		super();
		this.donation_id = donation_id;
		this.donor_id = donor_id;
		this.ngo_id = ngo_id;
		this.donation_type = donation_type;
		this.amount = amount;
		this.donor_name = donor_name;
		this.donor_username = donor_username;
		this.donor_password = donor_password;
		this.donor_email = donor_email;
		this.donor_number = donor_number;
		this.donor_address = donor_address;
	}
	
	public int getDonation_id() {
		return donation_id;
	}
	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}
	public int getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	public int getNgo_id() {
		return ngo_id;
	}
	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}
	public String getDonation_type() {
		return donation_type;
	}
	public void setDonation_type(String donation_type) {
		this.donation_type = donation_type;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public String getDonor_username() {
		return donor_username;
	}
	public void setDonor_username(String donor_username) {
		this.donor_username = donor_username;
	}
	public String getDonor_password() {
		return donor_password;
	}
	public void setDonor_password(String donor_password) {
		this.donor_password = donor_password;
	}
	public String getDonor_email() {
		return donor_email;
	}
	public void setDonor_email(String donor_email) {
		this.donor_email = donor_email;
	}
	public Long getDonor_number() {
		return donor_number;
	}
	public void setDonor_number(Long donor_number) {
		this.donor_number = donor_number;
	}
	public String getDonor_address() {
		return donor_address;
	}
	public void setDonor_address(String donor_address) {
		this.donor_address = donor_address;
	}
	
	
	
}
