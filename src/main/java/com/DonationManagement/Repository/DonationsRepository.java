package com.DonationManagement.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.DonationManagement.Dto.Donations;
import com.DonationManagement.Dto.Donor;

public interface DonationsRepository extends JpaRepository<Donations, Integer>{

	@Query("select d from DONATIONS d where d.donor_id = ?1")
	List<Donations> getDonationsPerDoner(int donorId);

}