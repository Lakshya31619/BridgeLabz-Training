package com.employeewage.service;
import com.employeewage.model.*;
import com.employeewage.repository.*;
import com.employeewage.util.*;
import java.util.Random;
// UC 11 - Implement Interface
public class EmpWageServiceImpl implements IEmpWageService {
    // UC 3 - Add Part-time & Full-time Employee
    private static final int IS_PART_TIME = 1;
    private static final int IS_FULL_TIME = 2;
    private CompanyRepository repository = new CompanyRepository();
    // UC 8 - Compute Employee Wage for multiple companies using parameters
    @Override
    public void addCompany(String companyName, int wagePerHour, int workingDays, int maxHours) {
        // Regex validation
        if (!CompanyValidator.isValidCompanyName(companyName)) {
            throw new IllegalArgumentException("Invalid Company Name");
        }
        repository.addCompany(new CompanyEmpWage(companyName, wagePerHour, workingDays, maxHours));
    }
    @Override
    public void computeWages() {
        for (CompanyEmpWage company : repository.getAllCompanies()) {
            int totalHours = 0;
            int totalDays = 0;
            System.out.println("\n----------------------------------------");
            System.out.println("Computing Wage for Company: " + company.getCompanyName());
            System.out.println("----------------------------------------");
            while (totalHours < company.getMaxHoursPerMonth() && totalDays < company.getNumOfWorkingDays()) {
                totalDays++;
                int empHours = 0;
                int check = new Random().nextInt(3);
                switch (check) {
                    case IS_PART_TIME:
                        empHours = 4;
                        break;
                    case IS_FULL_TIME:
                        empHours = 8;
                        break;
                    default:
                        empHours = 0;
                }
                int dailyWage = empHours * company.getWagePerHour();
                totalHours += empHours;
                company.addDailyWage(dailyWage);
                System.out.println("Day " + totalDays + " | Hours Worked: " + empHours + " | Daily Wage: " + dailyWage);
            }
            int totalWage = totalHours * company.getWagePerHour();
            company.setTotalEmpWage(totalWage);
            System.out.println("\nSummary for " + company.getCompanyName());
            System.out.println("Total Days Worked: " + totalDays);
            System.out.println("Total Hours Worked: " + totalHours);
            System.out.println("Daily Wages: " + company.getDailyWages());
            System.out.println("Total Employee Wage: " + totalWage);
            System.out.println("----------------------------------------");
        }
    }
    @Override
    public int getTotalWage(String companyName) {
        return repository.findByName(companyName)
                .map(CompanyEmpWage::getTotalEmpWage)
                .orElseThrow(() -> new RuntimeException("Company Not Found"));
    }
}