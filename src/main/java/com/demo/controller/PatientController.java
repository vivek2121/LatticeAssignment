package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.PatientMapper;
import com.demo.entity.Patient;
import com.demo.service.PatientServiceImpl;

@RestController
@RequestMapping("/patients")
public class PatientController {

	//pushing to git
	@Autowired
	public PatientServiceImpl patientService;
	
	Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	
	@PostMapping("/savepatient")
	public ResponseEntity<Object> savePatient(@RequestBody PatientMapper patient) throws Exception
	{
		LOGGER.info("Inside save Patient method");
		return patientService.savePatient(patient);
	}
	@GetMapping("/getallpatient")
	public List<Patient> getAllPatient()
	{
		return patientService.getAllPatients();
	}
	@GetMapping("/getpatient/{patientId}")
	public ResponseEntity<Object> getPatientById(@PathVariable Long patientId)
	{
		return patientService.getPatientFromPatientId(patientId);
	}
	@DeleteMapping("/deletepatient/{patientId}")
	public void deletepatientById(@PathVariable Long patientId)
	{
		patientService.deletePatientFromPatientId(patientId);
	}
	@PutMapping("/updatepatient/{patientId}")
	public ResponseEntity<Object> updatePatientFromPatientId(@PathVariable Long patientId,@RequestBody PatientMapper patientMapper) {
		return patientService.updatePatientFromPatientId(patientId, patientMapper);
	}
}
