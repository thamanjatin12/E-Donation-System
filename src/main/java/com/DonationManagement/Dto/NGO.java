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

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
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
	

}
