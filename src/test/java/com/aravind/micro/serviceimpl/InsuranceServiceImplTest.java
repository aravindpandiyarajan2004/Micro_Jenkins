
package com.aravind.micro.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aravind.micro.model.Insurance;
import com.aravind.micro.repository.InsuranceRepo;

public class InsuranceServiceImplTest {

	@Mock
	private InsuranceRepo insuranceRepo;

	@InjectMocks
	private InsuranceServiceImpl insuranceService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddInsurance() {
		Insurance insurance = new Insurance();
		insurance.setInusranceId(1);
		insurance.setInsuranceName("Health Insurance");

		when(insuranceRepo.save(insurance)).thenReturn("Insurance added successfully");

		String response = insuranceService.addInsurance(insurance);

		assertEquals("Insurance added successfully", response);
		verify(insuranceRepo).save(insurance);
	}

	@Test
	void testUpdateInsurance() {
		Insurance insurance = new Insurance();
		insurance.setInusranceId(1);
		insurance.setInsuranceName("Updated Insurance");

		when(insuranceRepo.update(insurance)).thenReturn("Insurance updated successfully");

		String response = insuranceService.updateInsurance(insurance);

		assertEquals("Insurance updated successfully", response);
		verify(insuranceRepo).update(insurance);
	}

	@Test
	void testDeleteInsurance() {
		int insuranceId = 1;

		when(insuranceRepo.delete(insuranceId)).thenReturn("Insurance deleted successfully");

		String response = insuranceService.deleteInsurance(insuranceId);

		assertEquals("Insurance deleted successfully", response);
		verify(insuranceRepo).delete(insuranceId);
	}

	@Test
	void testGetAllInsurance() {
		Insurance insurance1 = new Insurance();
		insurance1.setInusranceId(1);
		insurance1.setInsuranceName("Insurance 1");

		Insurance insurance2 = new Insurance();
		insurance2.setInusranceId(2);
		insurance2.setInsuranceName("Insurance 2");

		when(insuranceRepo.findAllInsurances()).thenReturn(Arrays.asList(insurance1, insurance2));

		List<Insurance> insurances = insuranceService.getAllInsurance();

		assertNotNull(insurances);
		assertEquals(2, insurances.size());
		assertEquals("Insurance 1", insurances.get(0).getInsuranceName());
		assertEquals("Insurance 2", insurances.get(1).getInsuranceName());
		verify(insuranceRepo).findAllInsurances();
	}

	@Test
	void testGetInsurance() {
		int insuranceId = 1;
		Insurance insurance = new Insurance();
		insurance.setInusranceId(insuranceId);
		insurance.setInsuranceName("Insurance 1");

		when(insuranceRepo.findById(insuranceId)).thenReturn(insurance);

		Insurance retrievedInsurance = insuranceService.getInsurance(insuranceId);

		assertNotNull(retrievedInsurance);
		assertEquals(insuranceId, retrievedInsurance.getInusranceId());
		assertEquals("Insurance 1", retrievedInsurance.getInsuranceName());
		verify(insuranceRepo).findById(insuranceId);
	}
}
