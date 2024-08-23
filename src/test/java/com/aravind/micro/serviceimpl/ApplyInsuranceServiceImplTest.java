package com.aravind.micro.serviceimpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aravind.micro.model.ApplyInsurance;
import com.aravind.micro.repository.ApplyInsuranceRepo;

public class ApplyInsuranceServiceImplTest {

    @InjectMocks
    private ApplyInsuranceServiceImpl applyInsuranceService;

    @Mock
    private ApplyInsuranceRepo applyInsuranceRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddApplyInsurance() {
        
        ApplyInsurance applyInsurance = new ApplyInsurance();
        when(applyInsuranceRepo.save(applyInsurance)).thenReturn("Insurance application added successfully");

        
        String result = applyInsuranceService.addApplyInsurance(applyInsurance);

        
        assertEquals("Insurance application added successfully", result);
    }

    @Test
    public void testUpdateApplyInsurance() {
        ApplyInsurance applyInsurance = new ApplyInsurance();
        when(applyInsuranceRepo.update(applyInsurance)).thenReturn("Insurance application updated successfully");

        
        String result = applyInsuranceService.updateApplyInsurance(applyInsurance);

        
        assertEquals("Insurance application updated successfully", result);
    }

    @Test
    public void testDeleteApplyInsurance() {
       
        int applyInsuranceId = 1;
        when(applyInsuranceRepo.delete(applyInsuranceId)).thenReturn("Insurance application deleted successfully");

        
        String result = applyInsuranceService.deleteApplyInsurance(applyInsuranceId);

        
        assertEquals("Insurance application deleted successfully", result);
    }

    @Test
    public void testGetAllApplyInsurance() {
        
        List<ApplyInsurance> applyInsurances = new ArrayList<>();
        when(applyInsuranceRepo.findAllApplyInsurance()).thenReturn(applyInsurances);

        
        List<ApplyInsurance> result = applyInsuranceService.getAllApplyInsurance();

        assertEquals(applyInsurances, result);
    }

    @Test
    public void testGetApplyInsurance() {
     
        int applyInsuranceId = 1;
        ApplyInsurance applyInsurance = new ApplyInsurance();
        when(applyInsuranceRepo.findById(applyInsuranceId)).thenReturn(applyInsurance);

        
        ApplyInsurance result = applyInsuranceService.getApplyInsurance(applyInsuranceId);

        
        assertEquals(applyInsurance, result);
    }

    @Test
    public void testGetApplyInsuranceByApplicantId() {
        
        int applicantId = 1;
        ApplyInsurance applyInsurance = new ApplyInsurance();
        when(applyInsuranceRepo.getApplyInsuranceByApplicantId(applicantId)).thenReturn(applyInsurance);

        
        ApplyInsurance result = applyInsuranceService.getApplyInsuranceByApplicantId(applicantId);

        
        assertEquals(applyInsurance, result);
    }

    @Test
    public void testGetApplyInsuranceByStatus() {
        
        String status = "Approved";
        List<ApplyInsurance> applyInsurances = new ArrayList<>();
        when(applyInsuranceRepo.findByStatus(status)).thenReturn(applyInsurances);

        
        List<ApplyInsurance> result = applyInsuranceService.getApplyInsuranceByStatus(status);

      
        assertEquals(applyInsurances, result);
    }
}

