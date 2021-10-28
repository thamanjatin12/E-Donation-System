//New Commit!
package com.DonationManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationManagement.Dto.Donations;
import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.Donor_Donations;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Exceptions.DonorNotFoundException;
import com.DonationManagement.Exceptions.NGONotFoundException;
import com.DonationManagement.Repository.DonationsRepository;
import com.DonationManagement.Repository.DonorRepository;
import com.DonationManagement.Repository.NGORepository;

@Service
public class DonationServiceImpl {

	@Autowired
	DonationsRepository donationRepository;
	@Autowired
	DonorRepository donorRepository;
	@Autowired
	NGORepository ngoRepository;
	
	
	public Donations addDonation(Donations donation) {
		
		int donor_id = donation.getDonor_id();
		int ngo_id = donation.getNgo_id();
		Optional<Donor> d = donorRepository.findById(donor_id);
		Optional<NGO> ngo = ngoRepository.findById(ngo_id);
		
		if (d.isEmpty()) {
			throw new DonorNotFoundException("Donor Not Found With Donor Id: " + donor_id);
		}else if (ngo.isEmpty()) {
			throw new NGONotFoundException("NGO Not Found With NGO Id: " + ngo_id);
		}else {
			return donationRepository.save(donation);
		}	

	}


	public List<Donor_Donations> getDonationsPerDoner(int donorId) {
		
		List<Donor_Donations> info_list = new ArrayList<Donor_Donations>();
		
		Optional<Donor> d = donorRepository.findById(donorId);
		Donor d1 = d.get();
		
		 int donation_id;
		 int donor_id;
		 int ngo_id;
		 String donation_type;
		 long amount;
		
		 String donor_name;
		 String donor_username;
		 String donor_password;
		 String donor_email;
		 Long donor_number;
		 String donor_address;
		
		 
		 
		if(d.isEmpty()) {
			throw new DonorNotFoundException("Donor Not Found With Donor Id: " + donorId);
		}else {
			List<Donations> donations = donationRepository.getDonationsPerDoner(donorId);
			
			int length = donations.size();
			for(int i = 0; i<length; i++) {
				Donations current_donation = donations.get(i);
				
				donation_id = current_donation.getId();
				donor_id = current_donation.getDonor_id();
				ngo_id = current_donation.getNgo_id();
				donation_type = current_donation.getDonation_type();
				amount = current_donation.getAmount();
				
				donor_name = d1.getName();
				donor_username = d1.getUsername();
				donor_password = d1.getPassword();
				donor_email = d1.getEmail();
				donor_number = d1.getNumber();
				donor_address = d1.getAddress();
				
				Donor_Donations info = new Donor_Donations(donation_id,donor_id,ngo_id,donation_type,amount,donor_name,
						donor_username,donor_password,donor_email,donor_number,donor_address);
				
				info_list.add(info);
				
			}
			return info_list;
		}
		
		
	}

}
