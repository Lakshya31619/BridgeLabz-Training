package com.employeewage.service;
// UC 11 - Interface approach
public interface IEmpWageService {
    void addCompany(String companyName, int wagePerHour, int workingDays, int maxHours);
    // UC 7 - Class method to compute employee wage
    void computeWages();
    // UC 14 - Get total wage by company
    int getTotalWage(String companyName);
}