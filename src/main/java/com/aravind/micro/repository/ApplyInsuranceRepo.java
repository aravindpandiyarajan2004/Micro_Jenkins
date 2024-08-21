package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.ApplyInsurance;

public interface ApplyInsuranceRepo {

	public String save(ApplyInsurance applyInsurance);

	public String update(ApplyInsurance applyInsurance);

	public String delete(int applyInsuranceId);

	public List<ApplyInsurance> findAllApplyInsurance();

	public ApplyInsurance findById(int applyInsuranceId);

	public ApplyInsurance getApplyInsuranceByApplicantId(int applicantId);

	List<ApplyInsurance> findByStatus(String status);

}
