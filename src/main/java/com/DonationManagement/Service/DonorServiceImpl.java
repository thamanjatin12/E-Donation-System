package com.DonationManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Exceptions.DonorNotFoundException;
import com.DonationManagement.Exceptions.NGONotFoundException;
import com.DonationManagement.Repository.DonorRepository;
import com.DonationManagement.Repository.NGORepository;


@Service
public class DonorServiceImpl {

	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	private NGORepository ngoRepository;
	
	public Donor registerDonor(Donor donor) {
		
		int ngo_id = donor.getDonated_ngo_id();
		Optional<NGO> ngo = ngoRepository.findById(ngo_id);

				
		if(ngo.isEmpty()) {
			throw new NGONotFoundException("NGO Not Found With NGO Id: " + ngo_id);
		}else {
			return donorRepository.save(donor);
		}
		
		 
	}

	public List<Donor> getDonorPerNGO(int ngoId) {
		
		Optional<NGO> ngo = ngoRepository.findById(ngoId);
		if(ngo.isEmpty()) {
			throw new NGONotFoundException("NGO Not Found With NGO Id: " + ngoId);
		}else{
			return donorRepository.getDonorPerNGO(ngoId);
		}
		
		
	}

	public Donor updateDonor(Donor donor) {
		
		int id = donor.getId();
		int ngo_id = donor.getDonated_ngo_id();
		
		Optional<Donor> d = donorRepository.findById(id);
		Optional<NGO> ngo = ngoRepository.findById(ngo_id);
		
		if(ngo.isEmpty()) {
			throw new NGONotFoundException("NGO Not Found With NGO Id: " + ngo_id);
		}else {

			return donorRepository.save(donor);
		}
		
	}

}

