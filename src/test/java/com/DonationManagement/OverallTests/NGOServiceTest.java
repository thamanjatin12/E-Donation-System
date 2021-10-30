package com.DonationManagement.OverallTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.DonationManagement.Dto.NGO;
import com.DonationManagement.Repository.NGORepository;
import com.DonationManagement.Service.NGOServiceImpl;
import com.DonationManagement.Utils.MasterData;



@WebMvcTest(NGOServiceImpl.class)
@AutoConfigureMockMvc
public class NGOServiceTest {

	@Autowired
	NGOServiceImpl ngoService;
	
	@MockBean
	NGORepository ngoRepository;
	
	@Test
	public void testAddNGOService() {
		
		NGO ngo = MasterData.getNGO();
		NGO savedNgo = MasterData.getNGO();
		
		when(this.ngoRepository.save(ngo)).thenReturn(savedNgo);
		
		NGO ngoActual = ngoService.addNGO(ngo);
		assertEquals(ngo, ngoActual);
		
	}
	
	@Test
	public void testListAllNGOService() {
		
		List<NGO> ngoList = MasterData.getNGOList();
		when(this.ngoRepository.findAll()).thenReturn(ngoList);
		
		List<NGO> ngoActual = ngoService.getAllNGOs();
		assertEquals(ngoList, ngoActual);
		
	}
	
}
