package com.demo.jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entity.Patient;
import com.demo.repository.PatientRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PatientRepository patientRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
      
    	Patient patientDetails = patientRepo.findBypatientEmailId(username);
        return new org.springframework.security.core.userdetails.User(patientDetails.getPatientEmailId(),patientDetails.getPatientPassword(),new ArrayList<>());
    }

       
    }

