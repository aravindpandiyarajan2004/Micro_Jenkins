package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.Applicant;

public interface ApplicantRepo {
	public String save(Applicant applicant);

	public String update(Applicant applicant);

	public String delete(int applicantId);

	public List<Applicant> findAllApplicant();

	public Applicant findById(int applicantId);

	public Applicant findByEmailAndPassword(String email, String password);
}
