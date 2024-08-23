
package com.aravind.micro.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aravind.micro.model.Payment;
import com.aravind.micro.repository.PaymentRepo;

public class PaymentServiceImplTest {

	@Mock
	private PaymentRepo paymentRepo;

	@InjectMocks
	private PaymentServiceImpl paymentService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddPayment() {
		Payment payment = new Payment();
		payment.setPayId(1);
		payment.setAmount(1000);

		when(paymentRepo.save(payment)).thenReturn("Payment added successfully");

		String response = paymentService.addPayment(payment);

		assertEquals("Payment added successfully", response);
		verify(paymentRepo).save(payment);
	}

	@Test
	void testUpdatePayment() {
		Payment payment = new Payment();
		payment.setPayId(1);
		payment.setAmount(2000);

		when(paymentRepo.update(payment)).thenReturn("Payment updated successfully");

		String response = paymentService.updatePayment(payment);

		assertEquals("Payment updated successfully", response);
		verify(paymentRepo).update(payment);
	}

	@Test
	void testDeletePayment() {
		int payId = 1;

		when(paymentRepo.delete(payId)).thenReturn("Payment deleted successfully");

		String response = paymentService.deletePayment(payId);

		assertEquals("Payment deleted successfully", response);
		verify(paymentRepo).delete(payId);
	}

	@Test
	void testGetAllPayment() {
		Payment payment1 = new Payment();
		payment1.setPayId(1);
		payment1.setAmount(1000);

		Payment payment2 = new Payment();
		payment2.setPayId(2);
		payment2.setAmount(2000);

		when(paymentRepo.findAllPayments()).thenReturn(Arrays.asList(payment1, payment2));

		List<Payment> payments = paymentService.getAllPayment();

		assertNotNull(payments);
		assertEquals(2, payments.size());
		assertEquals(1000.0, payments.get(0).getAmount());
		assertEquals(2000.0, payments.get(1).getAmount());
		verify(paymentRepo).findAllPayments();
	}

	@Test
	void testGetPayment() {
		int payId = 1;
		Payment payment = new Payment();
		payment.setPayId(payId);
		payment.setAmount(1000);

		when(paymentRepo.findById(payId)).thenReturn(payment);

		Payment retrievedPayment = paymentService.getPayment(payId);

		assertNotNull(retrievedPayment);
		assertEquals(payId, retrievedPayment.getPayId());
		assertEquals(1000.0, retrievedPayment.getAmount());
		verify(paymentRepo).findById(payId);
	}
}
