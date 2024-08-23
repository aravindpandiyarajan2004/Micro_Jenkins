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

import com.aravind.micro.model.Premium;
import com.aravind.micro.repository.PremiumRepo;

public class PremiumServiceImplTest {

	@Mock
	private PremiumRepo premiumRepo;

	@InjectMocks
	private PremiumServiceImpl premiumService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddPremium() {
		Premium premium = new Premium();
		premium.setPremiumId(1);
		premium.setTotalAmount(500);

		when(premiumRepo.save(premium)).thenReturn("Premium added successfully");

		String response = premiumService.addPremium(premium);

		assertEquals("Premium added successfully", response);
		verify(premiumRepo).save(premium);
	}

	@Test
	void testUpdatePremium() {
		Premium premium = new Premium();
		premium.setPremiumId(1);
		premium.setTotalAmount(600.0);
		
		when(premiumRepo.update(premium)).thenReturn("Premium updated successfully");

		String response = premiumService.updatePremium(premium);

		assertEquals("Premium updated successfully", response);
		verify(premiumRepo).update(premium);
	}

	@Test
	void testDeletePremium() {
		int premiumId = 1;

		when(premiumRepo.delete(premiumId)).thenReturn("Premium deleted successfully");

		String response = premiumService.deletePremium(premiumId);

		assertEquals("Premium deleted successfully", response);
		verify(premiumRepo).delete(premiumId);
	}

	@Test
	void testGetAllPremium() {
		Premium premium1 = new Premium();
		premium1.setPremiumId(1);
		premium1.setTotalAmount(500.0);

		Premium premium2 = new Premium();
		premium2.setPremiumId(2);
		premium2.setTotalAmount(600.0);

		when(premiumRepo.findAllPremiums()).thenReturn(Arrays.asList(premium1, premium2));

		List<Premium> premiums = premiumService.getAllPremium();

		assertNotNull(premiums);
		assertEquals(2, premiums.size());
		assertEquals(500.0, premiums.get(0).getTotalAmount());
		assertEquals(600.0, premiums.get(1).getTotalAmount());
		verify(premiumRepo).findAllPremiums();
	}

	@Test
	void testGetPremium() {
		int premiumId = 1;
		Premium premium = new Premium();
		premium.setPremiumId(premiumId);
		premium.setTotalAmount(500.0);

	
		when(premiumRepo.findById(premiumId)).thenReturn(premium);

		Premium retrievedPremium = premiumService.getPremium(premiumId);

		assertNotNull(retrievedPremium);
		assertEquals(premiumId, retrievedPremium.getPremiumId());
		assertEquals(500.0, retrievedPremium.getTotalAmount());
		verify(premiumRepo).findById(premiumId);
	}

	@Test
	void testGetPremiumsByApplicant() {
		int applicantId = 1;
		Premium premium1 = new Premium();
		premium1.setPremiumId(1);
		premium1.setTotalAmount(500.0);

		Premium premium2 = new Premium();
		premium2.setPremiumId(2);
		premium2.setTotalAmount(600.0);


		when(premiumRepo.findByApplicantId(applicantId)).thenReturn(Arrays.asList(premium1, premium2));

		List<Premium> premiums = premiumService.getPremiumsByApplicant(applicantId);

		assertNotNull(premiums);
		assertEquals(2, premiums.size());
		assertEquals(500.0, premiums.get(0).getTotalAmount());
		assertEquals(600.0, premiums.get(1).getTotalAmount());
		verify(premiumRepo).findByApplicantId(applicantId);
	}
}
