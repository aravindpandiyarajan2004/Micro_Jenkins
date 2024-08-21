package com.aravind.micro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.model.Risk;
import com.aravind.micro.repository.ApplyInsuranceRepo;
import com.aravind.micro.repository.RiskRepo;
import com.aravind.micro.service.RiskService;

@Service
public class RiskServiceImpl implements RiskService {

	@Autowired
	RiskRepo riskRepo;

	@Autowired
	ApplyInsuranceRepo applyInsuranceRepo;

	@Override
	public String addRisk(Risk risk) {
		return riskRepo.save(risk);
	}

	@Override
	public String updateRisk(Risk risk) {
		return riskRepo.update(risk);
	}

	@Override
	public String deleteRisk(int riskId) {
		return riskRepo.delete(riskId);
	}

	@Override
	public List<Risk> getAllRisk() {
		return riskRepo.findAllRisks();
	}

	@Override
	public Risk getRisk(int riskId) {
		return riskRepo.findById(riskId);
	}

	@Override
	public String calculateRiskScore(Applicant applicant, int applyInsuranceId) {
		int riskScore = 0, ageRisk = 0, genderRisk = 0, incomeRisk = 0, healthRisk = 0;

		ApplyInsurance applyInsurance = applyInsuranceRepo.findById(applyInsuranceId);
		boolean healthIssue = applyInsurance != null && applyInsurance.isHealthIssue();

		if (applicant.getAge() >= 18 && applicant.getAge() <= 30) {
			ageRisk += 2;
		} else if (applicant.getAge() > 30 && applicant.getAge() <= 45) {
			ageRisk += 3;
		} else if (applicant.getAge() > 45 && applicant.getAge() <= 60) {
			ageRisk += 4;
		} else {
			ageRisk += 5;
		}

		if ("male".equalsIgnoreCase(applicant.getGender())) {
			genderRisk += 3;
		} else if ("female".equalsIgnoreCase(applicant.getGender())) {
			genderRisk += 2;
		}

		try {
			double income = Double.parseDouble(applicant.getIncome().replace(",", ""));
			if (income < 100000) {
				incomeRisk += 2;
			} else if (income > 100000 && income <= 300000) {
				incomeRisk += 3;
			} else if (income > 300000 && income >= 400000) {
				incomeRisk += 4;
			} else {
				incomeRisk += 5;
			}
		} catch (NumberFormatException e) {
			incomeRisk += 15;
		}

		if (healthIssue) {
			healthRisk += 5;
		}

		// Determine risk level based on the total score
		riskScore = ageRisk + genderRisk + healthRisk + incomeRisk;

		String riskLevel;
		if (riskScore <= 10) {
			riskLevel = "Low Risk";
		} else if (riskScore > 10 && riskScore <= 20) {
			riskLevel = "Moderate Risk";
		} else {
			riskLevel = "High Risk";
		}

		Risk risk = new Risk();
		risk.setRiskScore(riskScore);
		risk.setRiskType(riskLevel);
		risk.setApplicants(applicant);

		return riskRepo.save(risk);
	}

	@Override
	public ApplyInsurance getApplyInsuranceById(int id) {
		return applyInsuranceRepo.findById(id);
	}

	@Override
	public boolean isRiskCalculated(int applicantId) {
		return riskRepo.existsByApplicationId(applicantId);
	}

}
