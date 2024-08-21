package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Insurance;

public interface InsuranceService {
	public String addInsurance(Insurance insurance);

	public String updateInsurance(Insurance insurance);

	public String deleteInsurance(int insuranceId);

	public List<Insurance> getAllInsurance();

	public Insurance getInsurance(int insuranceId);

}
