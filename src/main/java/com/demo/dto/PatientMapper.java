package com.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientMapper {

	@JsonProperty(value = "patientName")
	@Min(value = 3,message = "Patient name should be at least 3 charcters")
	private String patientName;
	
	@JsonProperty(value = "patientAddress")
	@Min(value = 10,message = "Patient address should be at least 10 charcters")
	private String patientAddress;
	
	@JsonProperty(value = "patientEmailId")
	@Email
	private String patientEmailId;
	
	@JsonProperty(value = "patientPassword")
	@Min(value = 8)
	@Max(value = 15)
	@Pattern(regexp="^[a-zA-Z0-9]*")
	private String patientPassword;
	
	@JsonProperty(value = "patientMobileNumber")
	@Min(value = 12,message = "Mobile number should be at least 10 character and extra 2 for country code")
	private String patientMobileNumber;
	
	@JsonProperty("jwt")
	private String jwt;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientEmailId() {
		return patientEmailId;
	}

	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	
	
	
}
