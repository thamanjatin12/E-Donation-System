package com.DonationManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Service.DonorServiceImpl;


@RestController()
@RequestMapping("/donors")
public class DonorController {

	@Autowired
	private DonorServiceImpl donorServiceImpl; 
	
	
	@PostMapping("/register-donor")
	public Donor registerDonor(@RequestBody Donor donor) {
		 return donorServiceImpl.registerDonor(donor);
		 
	}
	
	@GetMapping("/by-ngo-id/{ngoId}")
	public List<Donor> getDonorPerNGO(@PathVariable int ngoId){
		return donorServiceImpl.getDonorPerNGO(ngoId);
	}
	
	@PutMapping("/update-donor")
	public Donor updateDonor(@RequestBody Donor donor) {
		return donorServiceImpl.updateDonor(donor);
	}
}
