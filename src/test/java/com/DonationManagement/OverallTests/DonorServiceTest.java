package com.DonationManagement.OverallTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Exceptions.NGONotFoundException;
import com.DonationManagement.Repository.DonationsRepository;
import com.DonationManagement.Repository.DonorRepository;
import com.DonationManagement.Repository.NGORepository;
import com.DonationManagement.Service.DonorServiceImpl;
import com.DonationManagement.Service.NGOServiceImpl;
import com.DonationManagement.Utils.MasterData;

@WebMvcTest(DonorServiceImpl.class)
@AutoConfigureMockMvc
public class DonorServiceTest {

	@Autowired
	DonorServiceImpl donorService;
	
	@MockBean
	NGORepository ngoRepository;
	@MockBean
	DonorRepository donorRepository;
	@MockBean
	DonationsRepository donationRepository;
	
	@Test
	public void testRegisterDonorService() {
		
		Donor donor = MasterData.getDonor();
		int id = donor.getDonated_ngo_id();
		Optional<NGO> ngo = MasterData.getOptionalNGO();
		
		when(this.ngoRepository.findById(id)).thenReturn(ngo);
		when(this.donorRepository.save(donor)).thenReturn(donor);
		
		Donor donorActual = donorService.registerDonor(donor);
		
		assertEquals(donor, donorActual);
		
	}
	
	@Test
	public void testGetDonorsPerNGO() {
		
		List<Donor> donors = MasterData.getDonorList();
		int id = 1;
		
		Optional<NGO> ngo = MasterData.getOptionalNGO();
		
		when(this.ngoRepository.findById(id)).thenReturn(ngo);
		when(this.donorRepository.getDonorPerNGO(id)).thenReturn(donors);
		
		List<Donor> donorActual = donorService.getDonorPerNGO(id);
		
		assertEquals(donors, donorActual);
		
	}
	
	@Test
	public void testUpdateDonorDetailsService() {
		
		Donor d1 = MasterData.getDonor();
		Optional<Donor> donor = MasterData.getDonorOptional();
		
		int id = 1;
		Optional<NGO> ngo = MasterData.getOptionalNGO();
		 int ngo_id = 1;
		
		when(this.donorRepository.findById(id)).thenReturn(donor);
		when(this.ngoRepository.findById(ngo_id)).thenReturn(ngo);
		when(this.donorRepository.save(d1)).thenReturn(d1);
		
		Donor updateDonorActual = donorService.updateDonor(d1);
		
		assertEquals(d1, updateDonorActual);
		
	}
	
	@Test
	public void testRegisterDonor_NGONotFound() {
		
		Donor d = MasterData.getDonor();
		int ngo_id = d.getDonated_ngo_id();
		Optional<NGO> ngo = Optional.empty();
		
		when(this.ngoRepository.findById(ngo_id)).thenReturn(ngo);
		
		Throwable exception = assertThrows(NGONotFoundException.class, () -> donorService.registerDonor(d));
		assertEquals("NGO Not Found With NGO Id: 1", exception.getMessage());
		
	}
	
	@Test
	public void testGetDonorPerNGO_NGONotFound() {
		
		int ngo_id = 10;
		Optional<NGO> ngo = Optional.empty();
		
		when(this.ngoRepository.findById(ngo_id)).thenReturn(ngo);
		
		Throwable exception = assertThrows(NGONotFoundException.class, () -> donorService.getDonorPerNGO(ngo_id));
		assertEquals("NGO Not Found With NGO Id: 10", exception.getMessage());
		
	}
	
	@Test
	public void testUpdateDonorDetails_NGONotFound() {
		
		Donor d = MasterData.getDonor();
		Optional<Donor> dOptional =  MasterData.getDonorOptional();
		int id = d.getId();
		int ngo_id = d.getDonated_ngo_id();
		Optional<NGO> ngo = Optional.empty();
		
		when(this.donorRepository.findById(id)).thenReturn(dOptional);
		when(this.ngoRepository.findById(ngo_id)).thenReturn(ngo);
		
		Throwable exception = assertThrows(NGONotFoundException.class, () -> donorService.updateDonor(d));
		assertEquals("NGO Not Found With NGO Id: 1", exception.getMessage());
		
	}
	
}
