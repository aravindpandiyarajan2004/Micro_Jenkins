package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Applicant;

public interface ApplicantService {

	Applicant login(String email, String password);

	public String addApplicant(Applicant applicant);

	public String updateApplicant(Applicant applicant);

	public String deleteApplicant(int applicantId);

	public List<Applicant> getAllApplicant();

	public Applicant getApplicant(int applicantId);

}
