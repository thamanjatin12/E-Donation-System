package com.DonationManagement;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.DonationManagement.Repository.DonationsRepository;
import com.DonationManagement.Repository.DonorRepository;
import com.DonationManagement.Repository.NGORepository;
import com.DonationManagement.Service.DonationServiceImpl;
import com.DonationManagement.Service.DonorServiceImpl;
import com.DonationManagement.Service.NGOServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class DonationManagementApplicationTests {

	@Autowired
	private DonationServiceImpl donationService;
	@Autowired
	private DonorServiceImpl donorService;
	@Autowired
	private NGOServiceImpl ngoService;
	
	
	@MockBean
	private DonationsRepository donationsRepo;
	@MockBean
	private DonorRepository donorRepo;
	@MockBean 
	private NGORepository ngoRepo;
	
	@Test
	public void checkSizeofGetNGOs() {
		
	}
	

}
