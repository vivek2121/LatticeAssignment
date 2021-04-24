package com.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.demo.dto.PatientMapper;
import com.demo.entity.Patient;
import com.demo.exception.UserNotFoundException;
import com.demo.jwt.service.CustomUserDetailsService;
import com.demo.jwt.util.JwtUtil;
import com.demo.repository.PatientRepository;
import com.demo.response.PatientResponse;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	public PatientRepository patientRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	CustomUserDetailsService service;
	
	@Override
	public ResponseEntity<Object> savePatient(PatientMapper patientMapper) throws Exception {
		Patient patient=new Patient();
		patient.setPatientName(patientMapper.getPatientName());
		patient.setPatientEmailId(patientMapper.getPatientEmailId());
		patient.setPatientAddress(patientMapper.getPatientAddress());
		patient.setPatientPassword(patientMapper.getPatientPassword());
		patient.setPatientMobileNumber(patientMapper.getPatientMobileNumber());
		patientRepo.save(patient);
		patientMapper.setJwt(generateToken(patientMapper));
		return new ResponseEntity<>(new PatientResponse(new Date(), "200", "Patient saved", patientMapper),
				HttpStatus.OK);
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> allPatients = patientRepo.findAll();
		return allPatients;
	}

	@Override
	public ResponseEntity<Object> getPatientFromPatientId(Long patientId) {
		Optional<Patient> patientDetails = patientRepo.findById(patientId);
//		Patient patientData = patientRepo.findByPatientId(patientId);
//		patientData.setJwt(generateToken(patientData));
		if(patientDetails.isPresent()) {
			Patient patientDetail = patientDetails.get();
			
			return new ResponseEntity<>(new PatientResponse(new Date(), "200", "Successfull", patientDetail),
					HttpStatus.OK);
		}
		else{
			throw new UserNotFoundException("Given id is not present");
		}
	
	}

	@Override
	public void deletePatientFromPatientId(Long patientId) {
		patientRepo.deleteById(patientId);
		
	}

	@Override
	public ResponseEntity<Object> updatePatientFromPatientId(Long patientId, PatientMapper patientMapper) {
		Optional<Patient> patientDetails = patientRepo.findById(patientId);
		if(patientDetails.isPresent()) {
			patientDetails.get().setPatientName(patientMapper.getPatientName());
			patientDetails.get().setPatientAddress(patientMapper.getPatientAddress());
			patientDetails.get().setPatientEmailId(patientMapper.getPatientEmailId());
			patientDetails.get().setPatientPassword(patientMapper.getPatientPassword());
			patientDetails.get().setPatientMobileNumber(patientMapper.getPatientMobileNumber());
			 Patient patientData = patientRepo.save(patientDetails.get());
			 return new ResponseEntity<>(new PatientResponse(new Date(), "200", "Patient updated Successfully", patientData),
						HttpStatus.OK);
		}
		else {
			throw new UserNotFoundException("Given id is not present");
		}
		
	}

	@Override
	public String generateToken(PatientMapper patient) throws Exception {
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(patient.getPatientEmailId(), patient.getPatientPassword()));

		} catch (Exception ex) {
			// TODO: handle exception
			throw new Exception("inavalid username/password");
		}
		UserDetails userToken = service.loadUserByUsername(patient.getPatientEmailId());
		jwtUtil.generateToken(userToken);


		return jwtUtil.generateToken(userToken);

	}
	
	

}
