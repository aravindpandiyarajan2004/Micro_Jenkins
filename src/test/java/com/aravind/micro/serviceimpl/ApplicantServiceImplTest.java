package com.aravind.micro.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aravind.micro.model.Applicant;
import com.aravind.micro.repository.ApplicantRepo;

public class ApplicantServiceImplTest {

    @InjectMocks
    private ApplicantServiceImpl applicantService;

    @Mock
    private ApplicantRepo applicantRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddApplicant() {
        Applicant applicant = new Applicant();
        when(applicantRepo.save(applicant)).thenReturn("Applicant added successfully");

        
        String result = applicantService.addApplicant(applicant);

        
        assertEquals("Applicant added successfully", result);
    }

    @Test
    public void testUpdateApplicant() {
        
        Applicant applicant = new Applicant();
        when(applicantRepo.update(applicant)).thenReturn("Applicant updated successfully");

        
        String result = applicantService.updateApplicant(applicant);

  
        assertEquals("Applicant updated successfully", result);
    }

    @Test
    public void testDeleteApplicant() {
   
        int applicantId = 1;
        when(applicantRepo.delete(applicantId)).thenReturn("Applicant deleted successfully");

       
        String result = applicantService.deleteApplicant(applicantId);

        assertEquals("Applicant deleted successfully", result);
    }

    @Test
    public void testGetAllApplicant() {
        List<Applicant> applicants = new ArrayList<>();
        when(applicantRepo.findAllApplicant()).thenReturn(applicants);

        List<Applicant> result = applicantService.getAllApplicant();

        assertEquals(applicants, result);
    }

    @Test
    public void testGetApplicant() {
        int applicantId = 1;
        Applicant applicant = new Applicant();
        when(applicantRepo.findById(applicantId)).thenReturn(applicant);

       
        Applicant result = applicantService.getApplicant(applicantId);

        
        assertEquals(applicant, result);
    }

    @Test
    public void testLoginSuccess() {
       
        String email = "babu@gmail.com";
        String password = "Banu12@";
        Applicant applicant = new Applicant();
        applicant.setEmail(email);
        applicant.setPassword(password);

        when(applicantRepo.findByEmailAndPassword(email, password)).thenReturn(applicant);

        Applicant result = applicantService.login(email, password);

       
        assertEquals(applicant, result);
    }

    @Test
    public void testLoginFailure() {
 
        String email = "babu@gmail.comn";
        String password = "123";

        when(applicantRepo.findByEmailAndPassword(email, password)).thenReturn(null);

        Applicant result = applicantService.login(email, password);

  
        assertNull(result);
    }
}

