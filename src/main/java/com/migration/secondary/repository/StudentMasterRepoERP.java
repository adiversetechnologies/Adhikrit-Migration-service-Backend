package com.migration.secondary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.migration.secondary.model.StudentMasterERP;

@Repository
public interface StudentMasterRepoERP extends JpaRepository<StudentMasterERP, String> {

	@Query(value = "select * from student_master where batch= ?1 and branch = ?2 ",nativeQuery = true)
	List<StudentMasterERP> getByBatchAndBranch(String batch, String branch);

}
