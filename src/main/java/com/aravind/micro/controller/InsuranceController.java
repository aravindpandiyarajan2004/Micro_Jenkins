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

import com.aravind.micro.model.Insurance;
import com.aravind.micro.serviceimpl.InsuranceServiceImpl;

@RestController
@RequestMapping("/insurance")
@CrossOrigin("http://localhost:3000")
public class InsuranceController {

	@Autowired
	InsuranceServiceImpl service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertInsurance(@RequestBody Insurance insurance) {

		String msg = "";

		try {
			service.addInsurance(insurance);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@GetMapping("{insuranceId}")
	public Insurance getInsuranceById(@PathVariable("insuranceId") int id) {

		return service.getInsurance(id);
	}

	@GetMapping("/all")
	public List<Insurance> getInsurances() {

		return service.getAllInsurance();
	}

	@PutMapping
	public String updateInsurance(@RequestBody Insurance insurance) {
		String msg = "";

		try {
			service.updateInsurance(insurance);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@DeleteMapping("{insuranceId}")
	public String deleteInsuranceById(@PathVariable("insuranceId") int id) {
		String msg = "";

		try {
			service.deleteInsurance(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;

	}

}
