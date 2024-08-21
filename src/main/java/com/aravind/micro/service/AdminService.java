package com.aravind.micro.service;

import com.aravind.micro.model.Admin;

public interface AdminService {
	
	Admin login(String email, String password);

}
