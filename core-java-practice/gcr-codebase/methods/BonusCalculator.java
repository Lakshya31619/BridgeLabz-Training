import java.util.Random;
public class BonusCalculator {
    public static void main(String[] args) {
        //2D array to store old salary and years of service
        double[][] employeeData = generateEmployeeData();
        //2D array to store new salary and bonus
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        //Calling method to display summary
        displaySummary(employeeData, updatedData);
    }
    //Method to generate salary and years of service
    public static double[][] generateEmployeeData(){
        double[][] data = new double[10][2];
        Random rand = new Random();
        for(int i = 0; i < data.length; i++){
            //Generate 5-digit salary
            data[i][0] = rand.nextInt(90000) + 10000;
            //Generate years of service (1 to 10)
            data[i][1] = rand.nextInt(10) + 1;
        }
        return data;
    }
    //Method to calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(double[][] data){
        double[][] result = new double[10][2];
        for(int i = 0; i < data.length; i++){
            double salary = data[i][0];
            double years = data[i][1];
            double bonus;
            //Bonus logic
            if(years > 5){
                bonus = salary * 0.05;
            }else{
                bonus = salary * 0.02;
            }
            //Store new salary and bonus
            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }
    //Method to calculate totals and display results
    public static void displaySummary(double[][] oldData, double[][] newData){
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");
        for(int i = 0; i < oldData.length; i++){
            totalOldSalary += oldData[i][0];
            totalNewSalary += newData[i][0];
            totalBonus += newData[i][1];
            System.out.println((i + 1) + "\t" +oldData[i][0] + "\t\t" +(int)oldData[i][1] + "\t" +newData[i][1] + "\t\t" +newData[i][0]);
        }
        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}