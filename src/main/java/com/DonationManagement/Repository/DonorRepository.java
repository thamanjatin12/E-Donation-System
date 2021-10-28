package com.DonationManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DonationManagement.Dto.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

	@Query("select d from DONORDETAILS d where d.donated_ngo_id = ?1")
	List<Donor> getDonorPerNGO(int ngoId);

}
