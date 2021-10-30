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

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	
	
}
