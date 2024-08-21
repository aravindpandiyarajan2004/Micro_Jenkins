package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.Insurance;

public interface InsuranceRepo {
	public String save(Insurance insurance);

	public String update(Insurance insurance);

	public String delete(int insuranceId);

	public List<Insurance> findAllInsurances();

	public Insurance findById(int insuranceId);

}
