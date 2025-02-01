package com.migration.primary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migration.primary.model.FacultyDetailsEC;

@Repository
public interface FacultyDetailsRepoEC extends JpaRepository<FacultyDetailsEC, String>{

}
