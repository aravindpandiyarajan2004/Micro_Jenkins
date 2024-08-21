package com.aravind.micro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Insurance;
import com.aravind.micro.repository.InsuranceRepo;
import com.aravind.micro.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepo insuranceRepo;

	@Override
	public String addInsurance(Insurance insurance) {
		return insuranceRepo.save(insurance);
	}

	@Override
	public String updateInsurance(Insurance insurance) {
		return insuranceRepo.update(insurance);
	}

	@Override
	public String deleteInsurance(int insuranceId) {
		return insuranceRepo.delete(insuranceId);
	}

	@Override
	public List<Insurance> getAllInsurance() {
		return insuranceRepo.findAllInsurances();
	}

	@Override
	public Insurance getInsurance(int insuranceId) {
		return insuranceRepo.findById(insuranceId);
	}

}
