package com.DonationManagement.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Entity(name = "DONATIONS")
public class Donations {
	
	@Id
	private int id;
	@NotNull
	private int donor_id;
	@NotNull
	private int ngo_id;
	@NotNull
	@Length(min = 5, max = 100)
	private String donation_type;
	@NotNull
	private long amount;
	//yyyy-mm-dd
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	
}
