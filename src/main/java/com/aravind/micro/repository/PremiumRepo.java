package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.Premium;

public interface PremiumRepo {
	public String save(Premium premium);

	public String update(Premium premium);

	public String delete(int premiumId);

	public List<Premium> findAllPremiums();

	public Premium findById(int premiumId);
	
	public Premium getPremiumByApplicantId(int applicantId);

	public List<Premium> findByApplicantId(int applicantId);

}
