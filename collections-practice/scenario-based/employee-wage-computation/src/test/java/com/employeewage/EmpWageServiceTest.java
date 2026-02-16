package com.employeewage;
import com.employeewage.service.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EmpWageServiceTest {
    @Test
    void givenValidCompany_whenAdded_shouldComputeWage() {
        EmpWageServiceImpl service = new EmpWageServiceImpl();
        service.addCompany("Google", 30, 20, 100);
        service.computeWages();
        int wage = service.getTotalWage("Google");
        assertTrue(wage >= 0);
    }
    @Test
    void givenInvalidCompanyName_shouldThrowException() {
        EmpWageServiceImpl service = new EmpWageServiceImpl();
        assertThrows(IllegalArgumentException.class, () -> service.addCompany("google123", 20, 20, 100));
    }
}