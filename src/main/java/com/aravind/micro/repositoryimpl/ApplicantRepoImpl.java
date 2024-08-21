package com.aravind.micro.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.repository.ApplicantRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ApplicantRepoImpl implements ApplicantRepo {

	@Autowired
	EntityManager entityManager;

	@Override
	public String save(Applicant applicant) {
		if (applicant != null) {
			entityManager.merge(applicant);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public String update(Applicant applicant) {
		if (applicant != null) {
			entityManager.merge(applicant);
			return "Success";
		}
		return "Failure";
	}

	@Override
	public String delete(int applicantId) {
		Applicant id = entityManager.find(Applicant.class, applicantId);
		if (id != null) {
			entityManager.remove(id);
			return "Success";
		}
		return "Failure";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Applicant> findAllApplicant() {
		String hql = "from Applicant";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Applicant findById(int applicantId) {
		return entityManager.find(Applicant.class, applicantId);

	}

	@Override
	public Applicant findByEmailAndPassword(String email, String password) {
		String jpql = "SELECT a FROM Applicant a WHERE a.email = :email AND a.password = :password";
		TypedQuery<Applicant> query = entityManager.createQuery(jpql, Applicant.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		return query.getResultStream().findFirst().orElse(null);
	}

}
