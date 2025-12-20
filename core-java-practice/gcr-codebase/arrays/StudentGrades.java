import java.util.Scanner;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Number of students
        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];
        //Input marks
        for(int i=0; i<n; i++){
            for (int j=0; j<3; j++){
                double mark = sc.nextDouble();
                while(mark<0) { //positive marks
                    mark = sc.nextDouble();
                }
                marks[i][j] = mark;
            }
        }
        // Calculate grades
        for(int i=0; i<n; i++){
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total/300)*100;
            double pct = percentage[i];
            if(pct>=80){
                grade[i] = "A";
            }else if(pct>=70){
                grade[i] = "B";
            }else if(pct>=60){
                grade[i] = "C";
            }else if(pct>=50){
                grade[i] = "D";
            }else if(pct>=40){
                grade[i] = "E";
            }else{
                grade[i] = "R";
            }
        }
        for(int i=0; i<n; i++){
            System.out.println("Student "+(i+1)+" : Physics "+marks[i][0]+" | Chemistry "+marks[i][1]+" | Maths "+marks[i][2]+" | Percentage "+percentage[i]+" | Grade " + grade[i]);
        }
    }
}