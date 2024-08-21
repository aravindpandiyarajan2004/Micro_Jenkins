package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.ApplyInsurance;

public interface ApplyInsuranceService {
	public String addApplyInsurance(ApplyInsurance applyInsurance);

	public String updateApplyInsurance(ApplyInsurance applyInsurance);

	public String deleteApplyInsurance(int applyInsuranceId);

	public List<ApplyInsurance> getAllApplyInsurance();

	public ApplyInsurance getApplyInsurance(int applyInsuranceId);

	public ApplyInsurance getApplyInsuranceByApplicantId(int applicantId);
	
	List<ApplyInsurance> getApplyInsuranceByStatus(String status);
	

	

}
