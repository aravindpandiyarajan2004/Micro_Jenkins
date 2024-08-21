package com.aravind.micro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.repository.ApplyInsuranceRepo;
import com.aravind.micro.service.ApplyInsuranceService;


@Service
public class ApplyInsuranceServiceImpl implements ApplyInsuranceService {

	@Autowired
	ApplyInsuranceRepo applyInsuranceRepo;

	
	@Override
	public String addApplyInsurance(ApplyInsurance applyInsurance) {
		return applyInsuranceRepo.save(applyInsurance);

	}

//	@Override
//	public String addApplyInsurance(ApplyInsurance applyInsurance) {
//		 applyInsuranceRepo.save(applyInsurance);
//		Applicant applicant = ((ApplyInsurance) applicantRepo).getApplicant();
//
//		if (applicant != null) {
//			String applicantEmail = applicant.getEmail();
//			emailService.sendSimpleMessage(applicantEmail, "Insurance Application Received",
//					"Your application is under progress. Awaiting approval.");
//		}
//
//		return "Success";
//	}

	@Override
	public String updateApplyInsurance(ApplyInsurance applyInsurance) {
		return applyInsuranceRepo.update(applyInsurance);
	}

	@Override
	public String deleteApplyInsurance(int applyInsuranceId) {
		return applyInsuranceRepo.delete(applyInsuranceId);
	}

	@Override
	public List<ApplyInsurance> getAllApplyInsurance() {
		return applyInsuranceRepo.findAllApplyInsurance();
	}

	@Override
	public ApplyInsurance getApplyInsurance(int applyInsuranceId) {
		return applyInsuranceRepo.findById(applyInsuranceId);
	}

	@Override
	public ApplyInsurance getApplyInsuranceByApplicantId(int applicantId) {
		
		return applyInsuranceRepo.getApplyInsuranceByApplicantId(applicantId);
	}

	public List<ApplyInsurance> getApplyInsuranceByStatus(String status) {
		  return applyInsuranceRepo.findByStatus(status);
	}



	
	
}
