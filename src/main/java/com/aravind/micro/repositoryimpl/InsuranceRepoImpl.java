package com.aravind.micro.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Insurance;
import com.aravind.micro.repository.InsuranceRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InsuranceRepoImpl implements InsuranceRepo {

	@Autowired
	EntityManager entityManager;

	@Override
	public String save(Insurance insurance) {
		if (insurance != null) {
			entityManager.merge(insurance);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public String update(Insurance insurance) {
		if (insurance != null) {
			entityManager.merge(insurance);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public String delete(int insuranceId) {
		Insurance id = entityManager.find(Insurance.class, insuranceId);
		if (id != null) {
			entityManager.remove(id);
			return "Success";
		}
		return "Failure";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance> findAllInsurances() {
		String hql = "from Insurance";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Insurance findById(int insuranceId) {
		return entityManager.find(Insurance.class, insuranceId);
	}

}
