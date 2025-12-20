import java.util.Scanner;
public class StudentAgeVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Number of students
        int [] students = new int[n]; //Initialize empty array of size n
        for(int i=0; i<n; i++){
            students[i] = sc.nextInt(); //Age of Student
        }
        for(int i=0; i<n; i++){
            if(students[i]>=18){
                System.out.println("The student with age "+students[i]+" can vote.");
            }else if(students[i]<0){
                System.out.println("Invalid age");
            }else{
                System.out.println("The student with age "+students[i]+" cannot vote.");
            }
        }
    }
}