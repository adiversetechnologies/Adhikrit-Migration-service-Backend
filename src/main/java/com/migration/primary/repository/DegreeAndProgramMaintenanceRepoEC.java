package com.migration.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.migration.primary.model.DegreeAndProgramMaintenanceEC;
import com.migration.primary.model.DegreeProgramPrimaryKeyEC;

@Repository
public interface DegreeAndProgramMaintenanceRepoEC
		extends JpaRepository<DegreeAndProgramMaintenanceEC, DegreeProgramPrimaryKeyEC> {

	@Query(value = "select * from degree_program_maintenance where regulation_name = ?1 and batch = ?2 ", nativeQuery = true)
	List<DegreeAndProgramMaintenanceEC> getByRegulationAndbatch(String regulation, String batch);

}
