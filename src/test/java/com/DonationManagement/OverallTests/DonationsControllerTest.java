package com.DonationManagement.OverallTests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.DonationManagement.Controller.DonationsController;
import com.DonationManagement.Dto.Donations;
import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Dto.Donor_Donations;
import com.DonationManagement.Service.DonationServiceImpl;
import com.DonationManagement.Service.NGOServiceImpl;
import com.DonationManagement.Utils.MasterData;



@WebMvcTest(DonationsController.class)
@AutoConfigureMockMvc
public class DonationsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DonationServiceImpl donationService;
	
	@Test
	public void testAddDonation() throws Exception{
		
		Donations donation = MasterData.getDonation();
		Donations savedDonation = MasterData.getDonation();

		when(this.donationService.addDonation(donation)).thenReturn(savedDonation);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/donations/add-donation")
				.content(MasterData.asJsonString(donation)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedDonation)));
	}
	
	@Test
	public void testGetDonationsPerDonor() throws Exception {
		
		List<Donor_Donations> donationsList = MasterData.getDonationPerDonor();
		int donor_id = 1;
		
		
		when(this.donationService.getDonationsPerDoner(donor_id)).thenReturn(donationsList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/donations/by-id/1")
				.content(MasterData.asJsonString(donor_id)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(donationsList)));
		
		
	}
}
