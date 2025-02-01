package com.migration.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.migration.primary.model.CourseMasterEC;
import com.migration.primary.model.CourseMasterPrimaryKeyEC;

@Repository
public interface CourseMasterRepoEC extends JpaRepository<CourseMasterEC, CourseMasterPrimaryKeyEC> {

	@Query(value = "select * from course_master where batch = ?1 and degree = ?2 and programe = ?3 and semester = ?4 ", nativeQuery = true)
	List<CourseMasterEC> getByBatchProgramAndSemester(String batch, String degree, String branch, String semester);

}
