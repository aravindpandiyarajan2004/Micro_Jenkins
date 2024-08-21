package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Premium;

public interface PremiumService {
	public String addPremium(Premium premium);

	public String updatePremium(Premium premium);

	public String deletePremium(int premiumId);

	public List<Premium> getAllPremium();

	public Premium getPremium(int premiumId);

}
