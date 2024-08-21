package com.aravind.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.model.Risk;
import com.aravind.micro.repository.ApplicantRepo;
import com.aravind.micro.service.RiskService;

@RestController
@RequestMapping("/risk")
@CrossOrigin("http://localhost:3000")
public class RiskController {

	@Autowired
	private RiskService service;

	@Autowired
	private ApplicantRepo applicantRepo;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertRisk(@RequestBody Risk risk) {
		String msg = "";
		try {
			service.addRisk(risk);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("{riskId}")
	public Risk getRiskById(@PathVariable("riskId") int id) {
		return service.getRisk(id);
	}

	@GetMapping("/all")
	public List<Risk> getRisks() {
		return service.getAllRisk();
	}

	@PutMapping
	public String updateRisk(@RequestBody Risk risk) {
		String msg = "";
		try {
			service.updateRisk(risk);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@DeleteMapping("{riskId}")
	public String deleteRiskById(@PathVariable("riskId") int id) {
		String msg = "";
		try {
			service.deleteRisk(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("/calculate/{applicantId}/{applyInsuranceId}")
	public String calculateRiskScore(@PathVariable("applicantId") int applicantId,
			@PathVariable("applyInsuranceId") int applyInsuranceId) {
		try {
			Applicant applicant = applicantRepo.findById(applicantId);
			if (applicant == null) {
				return "Applicant not found";
			}
			return service.calculateRiskScore(applicant, applyInsuranceId);
		} catch (Exception e) {
			return FAILURE;
		}
	}

	@GetMapping("/applyInsurance/{id}")
	public ApplyInsurance getApplyInsuranceById(@PathVariable("id") int id) {
		return service.getApplyInsuranceById(id);
	}
}
