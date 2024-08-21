package com.aravind.micro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.repository.ApplicantRepo;
import com.aravind.micro.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantRepo applicantRepo;

	@Override
	public String addApplicant(Applicant applicant) {
		return applicantRepo.save(applicant);
	}

	@Override
	public String updateApplicant(Applicant applicant) {
		return applicantRepo.update(applicant);
	}

	@Override
	public String deleteApplicant(int applicantId) {
		return applicantRepo.delete(applicantId);
	}

	@Override
	public List<Applicant> getAllApplicant() {
		return applicantRepo.findAllApplicant();
	}

	@Override
	public Applicant getApplicant(int applicantId) {
		return applicantRepo.findById(applicantId);
	}

	@Override
	public Applicant login(String email, String password) {
		Applicant applicant = applicantRepo.findByEmailAndPassword(email, password);
		return applicant != null ? applicant : null;
	}

}
