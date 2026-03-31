import java.util.Scanner;
public class ZaraBonusSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalEmployees = 10;
        double[] salary = new double[totalEmployees];
        double[] yearsOfService = new double[totalEmployees];
        double[] bonus = new double[totalEmployees];
        double[] newSalary = new double[totalEmployees];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        for (int i = 0; i < totalEmployees; i++) {
            //Employee details input
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Salary: ");
            salary[i] = sc.nextDouble();
            System.out.print("Years of Service: ");
            yearsOfService[i] = sc.nextDouble();
            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input! Please enter valid salary and years of service.");
                i--;
                continue;
            }
        }
        //Bonus Calculation
        for (int i = 0; i < totalEmployees; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        //Output
        for (int i = 0; i < totalEmployees; i++) {
            System.out.println("Employee "+(i+1)+"| Old Salary: "+salary[i]+" | Bonus: "+bonus[i]+" | New Salary: "+newSalary[i]);
        }
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}