package com.aravind.micro.repository;

import com.aravind.micro.model.Admin;

public interface AdminRepo {
	 Admin findByEmailAndPassword(String email, String password);

}
