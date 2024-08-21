package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.Payment;

public interface PaymentRepo {
	public String save(Payment payment);

	public String update(Payment payment);

	public String delete(int payId);

	public List<Payment> findAllPayments();

	public Payment findById(int payId);

}
