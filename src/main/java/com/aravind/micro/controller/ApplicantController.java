package com.aravind.micro.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.serviceimpl.ApplicantServiceImpl;

@RestController
@RequestMapping("/applicant")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicantController {

	@Autowired
	ApplicantServiceImpl service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping("/login")
	public Applicant login(@RequestBody Applicant applicant) {
		return service.login(applicant.getEmail(), applicant.getPassword());
	}

	@PostMapping
	String insertApplicant(@RequestParam("applicantName") String applicantName, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile, @RequestParam("age") int age,
			@RequestParam("address") String address, @RequestParam("dob") String dob,
			@RequestParam("password") String password, @RequestParam("occupation") String occupation,
			@RequestParam("income") String income, @RequestParam("gender") String gender,
			@RequestParam("idProof") MultipartFile idProof) {
		String msg = "";
		try {
			byte[] idProofBytes = idProof.getBytes();
			Applicant applicant = new Applicant(0, applicantName, email, mobile, age, address, dob, password,
					occupation, income, gender, idProofBytes);
			service.addApplicant(applicant);
			msg = SUCCESS;
		} catch (IOException e) {
			e.printStackTrace();
			msg = FAILURE;
		} catch (Exception e) {
			e.printStackTrace();
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("{applicantId}")
	public Applicant getApplicantById(@PathVariable("applicantId") int id) {

		return service.getApplicant(id);
	}

	@GetMapping("/all")
	public List<Applicant> getApplicants() {

		return service.getAllApplicant();
	}

	@PutMapping
	public String updateApplicant(@RequestBody Applicant applicant) {
		String msg = "";

		try {
			service.updateApplicant(applicant);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@DeleteMapping("{applicantId}")
	public String deleteApplicantById(@PathVariable("applicantId") int id) {
		String msg = "";

		try {
			service.deleteApplicant(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;

	}

}
