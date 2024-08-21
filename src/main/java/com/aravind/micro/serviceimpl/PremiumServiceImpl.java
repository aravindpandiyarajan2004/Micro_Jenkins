package com.aravind.micro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Premium;
import com.aravind.micro.repository.PremiumRepo;
import com.aravind.micro.service.PremiumService;

@Service
public class PremiumServiceImpl implements PremiumService {

	@Autowired
	PremiumRepo premiumRepo;

	@Override
	public String addPremium(Premium premium) {
		return premiumRepo.save(premium);
	}

	@Override
	public String updatePremium(Premium premium) {
		return premiumRepo.update(premium);
	}

	@Override
	public String deletePremium(int premiumId) {
		return premiumRepo.delete(premiumId);
	}

	@Override
	public List<Premium> getAllPremium() {
		return premiumRepo.findAllPremiums();
	}

	@Override
	public Premium getPremium(int premiumId) {
		return premiumRepo.findById(premiumId);
	}

	public List<Premium> getPremiumsByApplicant(int applicantId) {
		return premiumRepo.findByApplicantId(applicantId);
	}

}
