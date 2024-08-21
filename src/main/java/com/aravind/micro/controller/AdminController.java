package com.aravind.micro.controller;

import com.aravind.micro.model.Admin;
import com.aravind.micro.model.Applicant;
import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.model.Insurance;
import com.aravind.micro.model.Payment;
import com.aravind.micro.model.Risk;
import com.aravind.micro.model.Premium;
import com.aravind.micro.service.AdminService;
import com.aravind.micro.service.ApplicantService;
import com.aravind.micro.service.ApplyInsuranceService;
import com.aravind.micro.service.InsuranceService;
import com.aravind.micro.service.PaymentService;
import com.aravind.micro.service.RiskService;
import com.aravind.micro.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private ApplyInsuranceService applyInsuranceSerice;

	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private RiskService riskService;

	@Autowired
	private PremiumService premiumService;

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/login")
	public Admin login(@RequestBody Admin admin) {
		return adminService.login(admin.getEmail(), admin.getPassword());
	}

	@GetMapping("/applicants")
	public List<Applicant> getAllApplicants() {
		return applicantService.getAllApplicant();
	}

	@GetMapping("/insurances")
	public List<Insurance> getAllInsurances() {
		return insuranceService.getAllInsurance();
	}

	@GetMapping("/risks")
	public List<Risk> getAllRisks() {
		return riskService.getAllRisk();
	}

	@GetMapping("/premiums")
	public List<Premium> getAllPremiums() {
		return premiumService.getAllPremium();
	}

	@GetMapping("/applyInsurance")
	public List<ApplyInsurance> getAllApplyInsurance() {
		return applyInsuranceSerice.getAllApplyInsurance();

	}

	@GetMapping("/payment")
	public List<Payment> getAllPayment() {
		return paymentService.getAllPayment();

	}

	@PutMapping("/applyInsurance/{id}")
	public String updateApplicationStatus(@PathVariable int id, @RequestBody ApplyInsurance updatedApplication) {
		ApplyInsurance existingApplication = applyInsuranceSerice.getApplyInsurance(id);
		if (existingApplication != null) {
			existingApplication.setStatus(updatedApplication.getStatus());
			return applyInsuranceSerice.addApplyInsurance(existingApplication); // Save the updated application
		}
		return null;
	}

	@GetMapping("/risk-calculated/{applicantId}")
	public boolean isRiskCalculated(@PathVariable("applicantId") int applicantId) {
		return riskService.isRiskCalculated(applicantId);
	}
}
