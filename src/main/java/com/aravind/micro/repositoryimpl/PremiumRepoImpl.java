package com.aravind.micro.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Premium;
import com.aravind.micro.repository.PremiumRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PremiumRepoImpl implements PremiumRepo {

	@Autowired
	EntityManager entityManager;

	@Override
	public String save(Premium premium) {
		if (premium != null) {
			entityManager.merge(premium);
			return "Succces";
		} else {
			return "Failure";
		}
	}

	@Override
	public String update(Premium premium) {
		if (premium != null) {
			entityManager.merge(premium);
			return "Succces";
		} else {
			return "Failure";
		}
	}

	@Override
	public String delete(int premiumId) {
		Premium id = entityManager.find(Premium.class, premiumId);
		if (id != null) {
			entityManager.remove(id);
			return "Success";
		}
		return "Failure";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Premium> findAllPremiums() {
		String hql = "from Premium";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Premium findById(int premiumId) {
		return entityManager.find(Premium.class, premiumId);

	}
	
	@Override
	public Premium getPremiumByApplicantId(int applicantId) {
	      return entityManager.createQuery("select p from Premium p where p.applicant.applicantId = :applicantId",Premium.class
	    		  ).setParameter("applicantId", applicantId).getSingleResult();
	}

	@Override
    public List<Premium> findByApplicantId(int applicantId) {
        String query = "SELECT p FROM Premium p WHERE p.applicant.applicantId = :applicantId";
		TypedQuery<Premium> typedQuery = entityManager.createQuery(query, Premium.class);
		typedQuery.setParameter("applicantId", applicantId);
		return typedQuery.getResultList();
	}

}
