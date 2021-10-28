package com.DonationManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DonationManagement.Dto.Donations;
import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.Donor_Donations;
import com.DonationManagement.Service.DonationServiceImpl;
import com.DonationManagement.Service.DonorServiceImpl;

@RestController()
@RequestMapping("/donations")
public class DonationsController {

	@Autowired
	private DonationServiceImpl donationServiceImpl;
	
	@PostMapping("/add-donation")
	public Donations addDonation(@RequestBody Donations donation ) {
		return donationServiceImpl.addDonation(donation);
	}
	
	@GetMapping("/by-id/{donorId}")
	public List<Donor_Donations> getDonationsPerDoner(@PathVariable int donorId){
		return donationServiceImpl.getDonationsPerDoner(donorId);
	}
	
}
