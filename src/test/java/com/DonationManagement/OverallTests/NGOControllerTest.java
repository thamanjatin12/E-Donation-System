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

import com.DonationManagement.Controller.NGOController;
import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Service.NGOServiceImpl;
import com.DonationManagement.Utils.MasterData;



@WebMvcTest(NGOController.class)
@AutoConfigureMockMvc
public class NGOControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	NGOServiceImpl ngoService;
	
	@Test
	public void testGetAllNGOs() throws Exception {
		List<NGO> ngoList = MasterData.getNGOList();

		when(this.ngoService.getAllNGOs()).thenReturn(ngoList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/NGO/NGO-list").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(ngoList)));

	}
	
	@Test
	public void testAddNGO() throws Exception {
		
		NGO ngo = MasterData.getNGO();
		NGO savedNgo = MasterData.getNGO();

		when(this.ngoService.addNGO(ngo)).thenReturn(savedNgo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/NGO/add-NGO")
				.content(MasterData.asJsonString(ngo)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedNgo)));
		

	}
	
}
