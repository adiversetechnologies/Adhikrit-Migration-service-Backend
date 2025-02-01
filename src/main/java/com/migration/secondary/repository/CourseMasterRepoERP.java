package com.migration.secondary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.migration.secondary.model.CourseMasterERP;
import com.migration.secondary.model.CourseMasterPrimaryKeyERP;

@Repository
public interface CourseMasterRepoERP extends JpaRepository<CourseMasterERP, CourseMasterPrimaryKeyERP> {

	@Query(value = "select * from course_master where batch = ?1 and degree = ?2 and programe = ?3 and semester = ?4 ", nativeQuery = true)
	List<CourseMasterERP> getByBatchProgramAndSemester(String batch, String degree, String programe, String semester);

}
