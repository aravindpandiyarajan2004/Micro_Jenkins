package com.aravind.micro.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Risk;
import com.aravind.micro.repository.ApplyInsuranceRepo;
import com.aravind.micro.repository.RiskRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RiskRepoImpl implements RiskRepo {

	@Autowired
	EntityManager entityManager;

	@Autowired
	ApplyInsuranceRepo applyInsuranceRepo;

	@Override
	public String save(Risk risk) {
		if (risk != null) {
			entityManager.merge(risk);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public String update(Risk risk) {
		if (risk != null) {
			entityManager.merge(risk);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public String delete(int riskId) {
		Risk id = entityManager.find(Risk.class, riskId);
		if (id != null) {
			entityManager.remove(id);
			return "Success";
		}
		return "Failure";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Risk> findAllRisks() {
		String hql = "from Risk";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Risk findById(int riskId) {
		return entityManager.find(Risk.class, riskId);
	}

	@Override
	public boolean existsByApplicationId(int applicantId) {

		String jpql = "SELECT COUNT(r) > 0 FROM Risk r WHERE r.applicants.applicantId = :applicantId";
		TypedQuery<Boolean> query = entityManager.createQuery(jpql, Boolean.class);
		query.setParameter("applicantId", applicantId);
		return query.getSingleResult();

	}

}
