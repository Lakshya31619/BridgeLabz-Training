import java.util.Scanner;
public class StudentVoteChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Array to store age of 10 students
        int[] ages = new int[10];
        //Loop to take input and check voting eligibility
        for(int i = 0; i < ages.length; i++){
            //Input age of student
            ages[i] = sc.nextInt();
            //Calling method canStudentVote
            boolean canVote = canStudentVote(ages[i]);
            //Output
            if(canVote){
                System.out.println("Student " + (i + 1) + " can vote.");
            }else{
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
    }
    //Method to check if student can vote
    public static boolean canStudentVote(int age){
        //Validate negative age
        if(age < 0){
            return false;
        }
        //Check voting eligibility
        if(age >= 18){
            return true;
        }
        return false;
    }
}