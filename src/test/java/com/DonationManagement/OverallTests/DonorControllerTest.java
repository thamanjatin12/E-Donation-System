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

import com.DonationManagement.Controller.DonorController;
import com.DonationManagement.Dto.Donor;
import com.DonationManagement.Service.DonorServiceImpl;
import com.DonationManagement.Utils.MasterData;

@WebMvcTest(DonorController.class)
@AutoConfigureMockMvc
public class DonorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	DonorServiceImpl donorService;

	@Test
	public void testRegisterDonorToNGO() throws Exception {

		Donor donor = MasterData.getDonor();
		Donor savedDonor = MasterData.getDonor();

		when(this.donorService.registerDonor(donor)).thenReturn(savedDonor);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/donors/register-donor")
				.content(MasterData.asJsonString(donor)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedDonor)));
	}
	
	@Test
	public void testGetDonorsPerNGO() throws Exception {
		
		List<Donor> donorList = MasterData.getDonorList();
		int ngo_id = 1;

		when(this.donorService.getDonorPerNGO(ngo_id)).thenReturn(donorList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/donors/by-ngo-id/1")
				.content(MasterData.asJsonString(ngo_id)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(donorList)));
		
		
	}
	
	@Test
	public void testUpdateDonorDetails() throws Exception {

		Donor donor = MasterData.getDonor();
		Donor updatedDonor = MasterData.getDonor();

		when(this.donorService.updateDonor(donor)).thenReturn(updatedDonor);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/donors/update-donor")
				.content(MasterData.asJsonString(updatedDonor)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(updatedDonor)));
	}
	
	
}
