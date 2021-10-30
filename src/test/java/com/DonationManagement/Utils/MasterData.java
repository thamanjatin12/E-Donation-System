package com.DonationManagement.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.DonationManagement.Dto.Donations;
import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.Donor_Donations;
import com.DonationManagement.Dto.NGO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterData {

	//NGO Data---------------------------------------
	
	public static List<NGO> getNGOList(){
		List<NGO> ngos = new ArrayList<NGO>();
		NGO ngo1 = new NGO(1, "Vidya Depression NGO", "Vidya@123", "VidyaPassword", "vidyango@gmail.com", 9988232323L, "Bangalore");
		NGO ngo2 = new NGO(2, "Ekta Depression NGO", "Ekta@123", "EktaPassword", "ektaango@gmail.com", 9988232323L, "Bangalore");
		ngos.add(ngo1);
		ngos.add(ngo2);
		
		return ngos;
		
	}
	
	public static NGO getNGO(){
		
		NGO ngo = new NGO(1, "Vidya Depression NGO", "Vidya@123", "VidyaPassword", "vidyango@gmail.com", 9988232323L, "Bangalore");
		return ngo;
		
	}
	
	public static Optional<NGO> getOptionalNGO() {
		
		NGO ngo = new NGO(1, "Vidya Depression NGO", "Vidya@123", "VidyaPassword", "vidyango@gmail.com", 9988232323L, "Bangalore");
		Optional<NGO> userOptional = Optional.of(ngo);
		return userOptional;
		
	}
	
	
	//Donor Data------------------------------------
	
	public static Donor getDonor(){
		
		Donor d = new Donor(1, 1, "Jatin Thaman", "Jatin@123", "JatinPassword", "thamanjatin12@gmail.com", 9988232323L, "Bangalore");
		return d;
		
	}
	
	public static List<Donor> getDonorList() {
		
		Donor d1 = new Donor(1, 1, "Jatin Thaman", "Jatin@123", "JatinPassword", "thamanjatin12@gmail.com", 9988232323L, "Bangalore");
		Donor d2= new Donor(2, 1, "Harshita Thaman", "Harshita@123", "HarshitaPassword", "thamanharshita12@gmail.com", 9988232311L, "Bangalore");
		
		List<Donor> donors = new ArrayList<Donor>();
		donors.add(d1);
		donors.add(d2);
		
		return donors;
	}
	
	
	// Donations Data---------------------------------
	
	
	
	public static Donations getDonation() {
		
		Donations d = new Donations(1, 1, 1, "Annual", 50000L);
		return d;
	}
	
	
	public static List<Donor_Donations> getDonationPerDonor() {
		
		Donor_Donations d1 = new Donor_Donations(1, 1, 1, "Annual", 50000L,"Jatin Thaman", "Jatin@123", "JatinPassword", "thamanjatin12@gmail.com", 9988232323L, "Bangalore");
		Donor_Donations d2 = new Donor_Donations(1, 1, 1, "Half Yearly", 80000L,"Jatin Thaman", "Jatin@123", "JatinPassword", "thamanjatin12@gmail.com", 9988232323L, "Bangalore");
		
		List<Donor_Donations> donations = new ArrayList<Donor_Donations>();
		donations.add(d1);
		donations.add(d2);
		
		return donations;
		
	}
	
	public static Optional<Donor> getDonorOptional() {
		
		Donor d = new Donor(1, 1, "Jatin Thaman", "Jatin@123", "JatinPassword", "thamanjatin12@gmail.com", 9988232323L, "Bangalore");
		Optional<Donor> userOptional = Optional.of(d);
		return userOptional;
		
	}
	
	public static List<Donations> getDonationsList() {
		
		Donations d1 = new Donations(1, 1, 1, "Annual", 50000L);
		Donations d2 = new Donations(1, 1, 1, "Half Yearly", 80000L);
		List<Donations> donations = new ArrayList<Donations>();
		donations.add(d1);
		donations.add(d2);
		return donations;
		
	}
	
	//---------------------------------------------------
	
	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

}

	







	
}