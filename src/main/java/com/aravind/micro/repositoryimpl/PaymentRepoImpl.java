package com.aravind.micro.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Payment;
import com.aravind.micro.repository.PaymentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentRepoImpl implements PaymentRepo {
	@Autowired
	EntityManager entityManager;

	@Override
	public String save(Payment payment) {
		if (payment != null) {
			entityManager.merge(payment);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public String update(Payment payment) {
		if (payment != null) {
			entityManager.merge(payment);
			return "Success";
		} else {
			return "Failure";
		}

	}

	@Override
	public String delete(int payId) {
		Payment id = entityManager.find(Payment.class, payId);
		if (id != null) {
			entityManager.remove(id);
			return "Success";
		}
		return "Failure";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findAllPayments() {
		String hql = "from Payment";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Payment findById(int payId) {
		return entityManager.find(Payment.class, payId);
	}

}
