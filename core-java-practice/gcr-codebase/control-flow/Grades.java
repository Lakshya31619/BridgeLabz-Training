import java.util.Scanner;
public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input subject Marks
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();
        double average = (physics+chemistry+maths)/3.0; //Average
        char grade;
        String remarks;
        if(average>=80){
            grade = 'A';
            remarks = "Level 4, above agency-normalized standards";
        }else if(average>=70){
            grade = 'B';
            remarks = "Level 3, at agency-normalized standards";
        }else if(average>=60){
            grade = 'C';
            remarks = "Level 2, below but approaching agency-normalized standards";
        }else if(average>=50){
            grade = 'D';
            remarks = "Level 1, well below agency-normalized standards";
        }else if(average>=40) {
            grade = 'E';
            remarks = "Level 1-, too below agency-normalized standards";
        }else{
            grade = 'R';
            remarks = "Remedial standards";
        }
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}