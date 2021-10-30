package com.DonationManagement.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DONATIONS")
public class Donations {
	
	@Id
	@GeneratedValue
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
	
}
