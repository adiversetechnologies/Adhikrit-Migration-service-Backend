package com.migration.secondary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.migration.secondary.model.DegreeAndProgramMaintenanceERP;
import com.migration.secondary.model.DegreeProgramPrimaryKeyERP;

@Repository	
public interface DegreeAndProgramMaintenanceRepoERP
		extends JpaRepository<DegreeAndProgramMaintenanceERP, DegreeProgramPrimaryKeyERP> {

	@Query(value = "select * from degree_program_maintenance where regulation_name = ?1 and batch = ?2 ",nativeQuery = true)
	List<DegreeAndProgramMaintenanceERP> getByRegulationAndbatch(String regulation, String batch);

}
