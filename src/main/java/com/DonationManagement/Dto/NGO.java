package com.DonationManagement.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class NGO {
	
	@Id
	private int id;
	@NotNull
	@Length(min = 5, max = 30)
	private String ngo_name;
	@NotNull
	@Length(min = 5, max = 30)
	private String ngo_username;
	@NotNull
	@Length(min = 5, max = 30)
	private String ngo_password;
	@Email
	private String ngo_email;
	@NotNull
	@Digits(integer=10, fraction=0)
	private Long ngo_number;
	@NotNull
	@Length(min = 5, max = 100)
	private String ngo_address;
	//private LocalDate estab_date;
	
	/*
	 * @ManyToMany(cascade = {CascadeType.ALL})
	 * 
	 * @JoinTable( name = "registered_donors", joinColumns = @JoinColumn(name =
	 * "ngo_id"), inverseJoinColumns = @JoinColumn(name = "donor_id") ) private
	 * List<Donor> registeredDonors = new ArrayList<>();
	 */
	
	
	
	/*
	 * public LocalDate getEstab_date() { return estab_date; } public void
	 * setEstab_date(LocalDate estab_date) { this.estab_date = estab_date; }
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNgo_name() {
		return ngo_name;
	}

	public void setNgo_name(String ngo_name) {
		this.ngo_name = ngo_name;
	}

	public String getNgo_username() {
		return ngo_username;
	}

	public void setNgo_username(String ngo_username) {
		this.ngo_username = ngo_username;
	}

	public String getNgo_password() {
		return ngo_password;
	}

	public void setNgo_password(String ngo_password) {
		this.ngo_password = ngo_password;
	}

	public String getNgo_email() {
		return ngo_email;
	}

	public void setNgo_email(String ngo_email) {
		this.ngo_email = ngo_email;
	}

	public Long getNgo_number() {
		return ngo_number;
	}

	public void setNgo_number(Long ngo_number) {
		this.ngo_number = ngo_number;
	}

	public String getNgo_address() {
		return ngo_address;
	}

	public void setNgo_address(String ngo_address) {
		this.ngo_address = ngo_address;
	}

	
	 
	

}
