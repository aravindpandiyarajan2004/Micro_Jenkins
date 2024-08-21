package com.aravind.micro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.micro.model.Payment;
import com.aravind.micro.repository.PaymentRepo;
import com.aravind.micro.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepo paymentRepo;

	@Override
	public String addPayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	@Override
	public String updatePayment(Payment payment) {
		return paymentRepo.update(payment);
	}

	@Override
	public String deletePayment(int payId) {
		return paymentRepo.delete(payId);
	}

	@Override
	public List<Payment> getAllPayment() {
		return paymentRepo.findAllPayments();
	}

	@Override
	public Payment getPayment(int payId) {
		return paymentRepo.findById(payId);
	}

}
