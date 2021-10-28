package com.DonationManagement.Dto;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity(name = "DONORDETAILS")
public class Donor {
	
	@Id
	private int id;
	@NotNull
	private int donated_ngo_id;
	@NotNull
	@Length(min = 5, max = 30)
	private String name;
	@NotNull
	@Length(min = 5, max = 30)
	private String username;
	@NotNull
	@Length(min = 3, max = 25)
	private String password;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Digits(integer=10, fraction=0)
	private Long number;
	@NotNull
	@Length(min = 5, max = 100)
	private String address;
	
	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany (mappedBy = "registeredDonors") private List<NGO> registered_ngos
	 * = new ArrayList<>();
	 */
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public int getDonated_ngo_id() {
		return donated_ngo_id;
	}

	public void setDonated_ngo_id(int donated_ngo_id) {
		this.donated_ngo_id = donated_ngo_id;
	}
	
	/*
	 * public List<NGO> getNgos_registered_list() { return ngos_registered_list; }
	 * 
	 * public void setNgos_registered_list(List<NGO> ngos_registered_list) {
	 * this.ngos_registered_list = ngos_registered_list; }
	 * 
	 * public void addNGO(NGO ngo) { ngos_registered_list.add(ngo);
	 * 
	 * }
	 */
	
	
	
	
	
}
