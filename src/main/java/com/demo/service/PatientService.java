package com.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.dto.PatientMapper;
import com.demo.entity.Patient;

public interface PatientService {

	public ResponseEntity<Object> savePatient(PatientMapper patientMapper)throws Exception;
	
	public List<Patient> getAllPatients();
	
	public ResponseEntity<Object> getPatientFromPatientId(Long patientId);
	
	public void deletePatientFromPatientId(Long patientId);

	public ResponseEntity<Object> updatePatientFromPatientId(Long patientId,PatientMapper patientMapper);
	
	public String generateToken(PatientMapper patient)throws Exception; 
}
