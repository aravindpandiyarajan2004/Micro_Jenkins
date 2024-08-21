package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.model.Risk;

public interface RiskService {
	public String addRisk(Risk risk);

	public String updateRisk(Risk risk);

	public String deleteRisk(int riskId);

	public List<Risk> getAllRisk();

	public Risk getRisk(int riskId);

	public String calculateRiskScore(Applicant applicant, int applyInsuranceId);

	public ApplyInsurance getApplyInsuranceById(int id);

	public boolean isRiskCalculated(int applicantId);

}
