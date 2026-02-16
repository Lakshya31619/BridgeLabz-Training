package com.employeewage.controller;
import com.employeewage.service.*;
// UC Master Start
public class EmployeeController {
    private IEmpWageService service = new EmpWageServiceImpl();
    public void start() {
        System.out.println("Welcome to Employee Wage Computation Program");
        // UC 8 - Add multiple companies
        service.addCompany("TCS", 20, 20, 100);
        service.addCompany("Infosys", 25, 22, 120);
        service.computeWages();
        // UC 14 - Query total wage
        System.out.println("Total Wage for TCS: " + service.getTotalWage("TCS"));
    }
}