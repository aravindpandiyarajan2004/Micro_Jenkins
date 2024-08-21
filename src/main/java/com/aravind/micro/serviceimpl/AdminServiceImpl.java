package com.aravind.micro.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Admin;
import com.aravind.micro.repository.AdminRepo;
import com.aravind.micro.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin login(String email, String password) {
		Admin admin = adminRepo.findByEmailAndPassword(email, password);
		return admin != null ? admin : null;
	}

}
