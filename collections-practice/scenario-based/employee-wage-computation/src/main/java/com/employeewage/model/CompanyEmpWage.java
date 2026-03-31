package com.employeewage.model;
import java.util.ArrayList;
import java.util.List;
// UC 9 - Ability to save Total Wage for each Company using Instance Variables
// UC 13 - Store Daily Wage along with Total Wage
public class CompanyEmpWage {
    private String companyName;
    private int wagePerHour;
    private int numOfWorkingDays;
    private int maxHoursPerMonth;
    private int totalEmpWage;                // UC 9
    private List<Integer> dailyWages;        // UC 12 - Using ArrayList
    public CompanyEmpWage(String companyName, int wagePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.dailyWages = new ArrayList<>();   // UC 12
    }
    // UC 13 - Store daily wage
    public void addDailyWage(int wage) {
        dailyWages.add(wage);
    }
    public List<Integer> getDailyWages() {
        return dailyWages;
    }
    public String getCompanyName() {
        return companyName;
    }
    public int getWagePerHour() {
        return wagePerHour;
    }
    public int getNumOfWorkingDays() {
        return numOfWorkingDays;
    }
    public int getMaxHoursPerMonth() {
        return maxHoursPerMonth;
    }
    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }
    public int getTotalEmpWage() {
        return totalEmpWage;
    }
}