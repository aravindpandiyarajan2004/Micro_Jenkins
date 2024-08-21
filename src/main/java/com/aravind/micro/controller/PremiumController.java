package com.aravind.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.micro.model.Premium;
import com.aravind.micro.serviceimpl.PremiumServiceImpl;

@RestController
@RequestMapping("/premium")
@CrossOrigin("http://localhost:3000")
public class PremiumController {

	@Autowired
	PremiumServiceImpl service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertPremium(@RequestBody Premium premium) {

		String msg = "";

		try {
			service.addPremium(premium);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@GetMapping("{premiumId}")
	public Premium getPremiumById(@PathVariable("premiumId") int id) {

		return service.getPremium(id);
	}

	@GetMapping("/all")
	public List<Premium> getPremiums() {

		return service.getAllPremium();
	}

	@PutMapping
	public String updatePremium(@RequestBody Premium premium) {
		String msg = "";

		try {
			service.updatePremium(premium);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@DeleteMapping("{premiumId}")
	public String deletePremiumById(@PathVariable("premiumId") int id) {
		String msg = "";

		try {
			service.deletePremium(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;

	}

	@GetMapping("/getByApplicant/{applicantId}")
	public ResponseEntity<List<Premium>> getPremiumsByApplicant(@PathVariable("applicantId") int applicantId) {
		List<Premium> premiums = service.getPremiumsByApplicant(applicantId);
		if (premiums.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(premiums);
	}

}
