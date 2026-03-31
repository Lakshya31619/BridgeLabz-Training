package com.employeewage.repository;
import com.employeewage.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// UC 10 - Manage Employee Wage of multiple companies
// UC 12 - Use ArrayList instead of array
public class CompanyRepository {
    private List<CompanyEmpWage> companyList = new ArrayList<>();
    public void addCompany(CompanyEmpWage company) {
        companyList.add(company);
    }
    public List<CompanyEmpWage> getAllCompanies() {
        return companyList;
    }
    // UC 14 - Ability to get Total Wage when queried by Company
    public Optional<CompanyEmpWage> findByName(String name) {
        return companyList.stream()
                .filter(c -> c.getCompanyName().equals(name))
                .findFirst();
    }
}