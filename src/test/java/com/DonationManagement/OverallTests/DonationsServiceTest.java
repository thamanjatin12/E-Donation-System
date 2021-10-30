package com.DonationManagement.OverallTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.DonationManagement.Dto.Donations;
import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.Donor_Donations;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Exceptions.DonorNotFoundException;
import com.DonationManagement.Exceptions.NGONotFoundException;
import com.DonationManagement.Repository.DonationsRepository;
import com.DonationManagement.Repository.DonorRepository;
import com.DonationManagement.Repository.NGORepository;
import com.DonationManagement.Service.DonationServiceImpl;
import com.DonationManagement.Service.NGOServiceImpl;
import com.DonationManagement.Utils.MasterData;

@WebMvcTest(DonationServiceImpl.class)
@AutoConfigureMockMvc
public class DonationsServiceTest {

	@Autowired
	DonationServiceImpl donationService;
	
	@MockBean
	NGORepository ngoRepository;
	@MockBean
	DonorRepository donorRepository;
	@MockBean
	DonationsRepository donationRepository;
	
	@Test
	public void testAddDonationService() {
	
		Donations d =MasterData.getDonation();
		int donor_id = d.getDonor_id();
		int ngo_id = d.getNgo_id();
		
		Optional<Donor> donor = MasterData.getDonorOptional();
		Optional<NGO> ngo = MasterData.getOptionalNGO();
		
		when(this.donorRepository.findById(donor_id)).thenReturn(donor);
		when(this.ngoRepository.findById(ngo_id)).thenReturn(ngo);
		when(this.donationRepository.save(d)).thenReturn(d);
		
		Donations donationActual = donationService.addDonation(d);
		
		assertEquals(d, donationActual);	
		
	}
	
	@Test
	public void testGetDonationsPerDonorService() {
		
		int donor_id = 1;
		Optional<Donor> donor = MasterData.getDonorOptional();
		List<Donations> donations = MasterData.getDonationsList();
		List<Donor_Donations> donationsExpected = MasterData.getDonationPerDonor();
		
		
		when(this.donorRepository.findById(donor_id)).thenReturn(donor);
		when(this.donationRepository.getDonationsPerDoner(donor_id)).thenReturn(donations);
		
		List<Donor_Donations> donationsActual = donationService.getDonationsPerDoner(donor_id);
		
		assertEquals(donationsExpected, donationsActual);
		
	}
	
	@Test
	public void testGetDonationsPerDonorServiceException_DonorNotFoundException() {
		
		int donor_id = 1;
		Optional<Donor> donor = Optional.empty();
		
		when(this.donorRepository.findById(donor_id)).thenReturn(donor);
		
		Throwable exception = assertThrows(DonorNotFoundException.class, () -> donationService.getDonationsPerDoner(donor_id));
	    assertEquals("Donor Not Found With Donor Id: 1", exception.getMessage());
		
	}
	
	@Test
	public void testAddDonation_DonorNotFound() {
		
		Donations d =MasterData.getDonation();
		int donor_id = d.getDonor_id();
		Optional<Donor> donor = Optional.empty();
		
		when(this.donorRepository.findById(donor_id)).thenReturn(donor);
		
		Throwable exception = assertThrows(DonorNotFoundException.class, () -> donationService.addDonation(d));
	    assertEquals("Donor Not Found With Donor Id: 1", exception.getMessage());
		
	}
	
	@Test
	public void testAddDonation_NGONotFound() {

		Donations d = MasterData.getDonation();
		int donor_id = d.getDonor_id();
		int ngo_id = d.getNgo_id();

		Optional<Donor> donor = MasterData.getDonorOptional();
		Optional<NGO> ngo = Optional.empty();

		when(this.donorRepository.findById(donor_id)).thenReturn(donor);
		when(this.ngoRepository.findById(ngo_id)).thenReturn(ngo);

		Throwable exception = assertThrows(NGONotFoundException.class, () -> donationService.addDonation(d));
		assertEquals("NGO Not Found With NGO Id: 1", exception.getMessage());

	}
	 
	
}
