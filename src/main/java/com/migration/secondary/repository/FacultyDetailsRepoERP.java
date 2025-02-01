package com.migration.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migration.secondary.model.FacultyDetailsERP;

@Repository
public interface FacultyDetailsRepoERP extends JpaRepository<FacultyDetailsERP, String> {

}
