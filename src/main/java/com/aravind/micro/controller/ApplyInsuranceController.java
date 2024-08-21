package com.aravind.micro.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.model.Insurance;
import com.aravind.micro.service.EmailService;
import com.aravind.micro.serviceimpl.ApplyInsuranceServiceImpl;
import com.aravind.micro.serviceimpl.InsuranceServiceImpl;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/applyInsurance")
@CrossOrigin("http://localhost:3000")
public class ApplyInsuranceController {

	@Autowired
	private EmailService emailService;

	@Autowired
	ApplyInsuranceServiceImpl service;

	@Autowired
	InsuranceServiceImpl insuranceServiceImpl;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

//	@PostMapping
//	public String insertApplyInsurance(@RequestParam("insuranceDate") String insuranceDate, @RequestParam("healthIssue") boolean healthIssue, @RequestParam("policyNumber") long policyNumber, @RequestParam("status") String status, @RequestParam("reports") MultipartFile reports) {
//
//		String msg = "";
//
//		try {
//			byte[] reportsBytes = reports.getBytes();
//			ApplyInsurance apply = new ApplyInsurance(0,insuranceDate,healthIssue,policyNumber,status, reportsBytes,null,null);
//			service.addApplyInsurance(apply);
//			msg = SUCCESS;
//		} catch (Exception e) {
//			msg = FAILURE;
//		}
//
//		return msg;
//	}

	@PostMapping
	public String insertApplyInsurance(@RequestParam("insuranceDate") String insuranceDate,
			@RequestParam("healthIssue") boolean healthIssue, @RequestParam("policyNumber") long policyNumber,
			@RequestParam("status") String status, @RequestParam("reports") MultipartFile reports,
			@RequestParam("applicantId") int applicantId, @RequestParam("inusranceId") int inusranceId) {

		try {
			ApplyInsurance apply = new ApplyInsurance();
			apply.setInsuranceDate(insuranceDate);
			apply.setHealthIssue(healthIssue);
			apply.setPolicyNumber(policyNumber);
			apply.setStatus(status);
			apply.setReports(reports.getBytes());

			Insurance insurance = new Insurance();
			insurance.setInusranceId(inusranceId);
			apply.setInsurance(insurance);

			Applicant applicant = new Applicant();
			applicant.setApplicantId(applicantId);
			apply.setApplicant(applicant);

			service.addApplyInsurance(apply);

			return "Success";
		} catch (Exception e) {
			return "Failure";
		}
	}

	@GetMapping("/getInsuranceDetails" + "/{applicantId}")
	public ApplyInsurance getApplyInsuranceByApplicantId(@PathVariable("applicantId") int id) {

		return service.getApplyInsuranceByApplicantId(id);
	}

	@GetMapping("{applyInsuranceId}")
	public ApplyInsurance getApplyInsuranceById(@PathVariable("applyInsuranceId") int id) {

		return service.getApplyInsurance(id);
	}

	@GetMapping("/all")
	public List<ApplyInsurance> getApplyInsurances() {

		return service.getAllApplyInsurance();
	}

	@PutMapping
	public String updateApplyInsurance(@RequestBody ApplyInsurance applyInsurance) {
		String msg = "";

		try {
			service.updateApplyInsurance(applyInsurance);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@DeleteMapping("{applyInsuranceId}")
	public String deleteApplyInsuranceById(@PathVariable("applyInsuranceId") int id) {
		String msg = "";

		try {
			service.deleteApplyInsurance(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;

	}

//	@PostMapping("/sendEmail")
//	public ResponseEntity<String> sendEmail(@RequestParam String from, @RequestParam String to,
//			@RequestParam String subject, @RequestParam String body) {
//		try {
//
//			emailService.sendEmail(to, subject, body);
//			return ResponseEntity.ok("Email sent successfully");
//		} catch (MessagingException | IOException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Failed to send email: " + e.getMessage());
//		}
//	}

	@PostMapping("/sendEmail" + "/{applicantId}/{status}")
	public ResponseEntity<String> sendEmail(@PathVariable int applicantId, @PathVariable String status) {
		try {
			System.err.println(applicantId + " " + status);
			emailService.sendEmail(applicantId, status);
			return ResponseEntity.ok("Email sent successfully");
		} catch (MessagingException | IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestParam String from, @RequestParam String to,
			@RequestParam String subject, @RequestParam String body) {
		try {

			emailService.sendEmail(to, subject, body);
			return ResponseEntity.ok("Email sent successfully");
		} catch (MessagingException | IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}

	@GetMapping("/status/{status}")
    public ResponseEntity<List<ApplyInsurance>> getApplyInsuranceByStatus(@PathVariable("status") String status) {
        List<ApplyInsurance> insurances = service.getApplyInsuranceByStatus(status);
        return ResponseEntity.ok(insurances);
    }

}
