package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Payment;

public interface PaymentService {
	public String addPayment(Payment payment);

	public String updatePayment(Payment payment);

	public String deletePayment(int payId);

	public List<Payment> getAllPayment();

	public Payment getPayment(int payId);

}
