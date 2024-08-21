package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.Risk;

public interface RiskRepo {
	public String save(Risk risk);

	public String update(Risk risk);

	public String delete(int riskId);

	public List<Risk> findAllRisks();

	public Risk findById(int riskId);

	boolean existsByApplicationId(int applicantId);

}
