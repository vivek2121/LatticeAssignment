package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	public Patient findBypatientEmailId(String emailId);
	
	public Patient findByPatientId(Long patientId);
	
}
