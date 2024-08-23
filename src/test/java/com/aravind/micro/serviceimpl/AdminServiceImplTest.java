package com.aravind.micro.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aravind.micro.model.Admin;
import com.aravind.micro.repository.AdminRepo;

public class AdminServiceImplTest {

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private AdminRepo adminRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess() {
        String email = "admin@gmail.com";
        String password = "123";
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);

        when(adminRepo.findByEmailAndPassword(email, password)).thenReturn(admin);

        Admin result = adminService.login(email, password);

        assertEquals(admin, result);
    }

    @Test
    public void testLoginFailure() {
        String email = "admin@gmail.com";
        String password = "1234";

        when(adminRepo.findByEmailAndPassword(email, password)).thenReturn(null);

        Admin result = adminService.login(email, password);

        assertNull(result);
    }
}

