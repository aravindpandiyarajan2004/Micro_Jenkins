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

import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.model.Risk;
import com.aravind.micro.repository.ApplyInsuranceRepo;
import com.aravind.micro.repository.RiskRepo;

public class RiskServiceImplTest {

	@Mock
	private RiskRepo riskRepo;

	@Mock
	private ApplyInsuranceRepo applyInsuranceRepo;

	@InjectMocks
	private RiskServiceImpl riskService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddRisk() {
		Risk risk = new Risk();
		risk.setRiskScore(10);
		risk.setRiskType("Low Risk");

		when(riskRepo.save(risk)).thenReturn("Risk added successfully");

		String response = riskService.addRisk(risk);

		assertEquals("Risk added successfully", response);
		verify(riskRepo).save(risk);
	}

	@Test
	void testUpdateRisk() {
		Risk risk = new Risk();
		risk.setRiskScore(15);
		risk.setRiskType("Moderate Risk");

		when(riskRepo.update(risk)).thenReturn("Risk updated successfully");

		String response = riskService.updateRisk(risk);

		assertEquals("Risk updated successfully", response);
		verify(riskRepo).update(risk);
	}

	@Test
	void testDeleteRisk() {
		int riskId = 1;

		when(riskRepo.delete(riskId)).thenReturn("Risk deleted successfully");

		String response = riskService.deleteRisk(riskId);

		assertEquals("Risk deleted successfully", response);
		verify(riskRepo).delete(riskId);
	}

	@Test
	void testGetAllRisk() {
		Risk risk1 = new Risk();
		risk1.setRiskScore(10);
		risk1.setRiskType("Low Risk");

		Risk risk2 = new Risk();
		risk2.setRiskScore(20);
		risk2.setRiskType("High Risk");

		when(riskRepo.findAllRisks()).thenReturn(Arrays.asList(risk1, risk2));

		List<Risk> risks = riskService.getAllRisk();

		assertNotNull(risks);
		assertEquals(2, risks.size());
		assertEquals("Low Risk", risks.get(0).getRiskType());
		assertEquals("High Risk", risks.get(1).getRiskType());
		verify(riskRepo).findAllRisks();
	}

	@Test
	void testGetApplyInsuranceById() {
		int applyInsuranceId = 1;
		ApplyInsurance applyInsurance = new ApplyInsurance();
		applyInsurance.setApplyInsuranceId(applyInsuranceId);

		when(applyInsuranceRepo.findById(applyInsuranceId)).thenReturn(applyInsurance);

		ApplyInsurance retrievedApplyInsurance = riskService.getApplyInsuranceById(applyInsuranceId);

		assertNotNull(retrievedApplyInsurance);
		assertEquals(applyInsuranceId, retrievedApplyInsurance.getApplyInsuranceId());
		verify(applyInsuranceRepo).findById(applyInsuranceId);
	}

	@Test
	void testIsRiskCalculated() {
		int applicantId = 1;

		when(riskRepo.existsByApplicationId(applicantId)).thenReturn(true);

		boolean result = riskService.isRiskCalculated(applicantId);

		assertEquals(true, result);
		verify(riskRepo).existsByApplicationId(applicantId);
	}
}
