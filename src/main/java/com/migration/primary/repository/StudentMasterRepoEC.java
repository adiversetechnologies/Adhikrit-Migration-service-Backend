package com.migration.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.migration.primary.model.StudentMasterEC;

@Repository
public interface StudentMasterRepoEC extends JpaRepository<StudentMasterEC, String> {

	@Query(value = "select * from student_master where batch= ?1 and branch = ?2 ", nativeQuery = true)
	List<StudentMasterEC> getByBatchAndBranch(String string, String string2);

}
