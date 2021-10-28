package com.DonationManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Repository.DonorRepository;
import com.DonationManagement.Repository.NGORepository;
import com.DonationManagement.Service.DonorServiceImpl;
import com.DonationManagement.Service.NGOServiceImpl;


@RestController
@RequestMapping("/NGO")
public class NGOController {
	
	@Autowired
	private NGOServiceImpl ngoServiceImpl; 
	
	
	@PostMapping("/add-NGO")
	public String addNGO(@RequestBody NGO ngo) {
		ngoServiceImpl.addNGO(ngo);
		return "NGO Information Added!";
	}
	
	@RequestMapping("/NGO-list")
	public List<NGO> getAllNGOs() {
		return ngoServiceImpl.getAllNGOs();
				}
}
