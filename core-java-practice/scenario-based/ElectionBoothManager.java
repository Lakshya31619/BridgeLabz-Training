import java.util.Scanner;
public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Candidates 1, 2 and 3
        int c1 = 0, c2 = 0, c3 = 0;
        while(true) {
            //Input  //Press -1 to exit
            int age = sc.nextInt();
            if(age==-1) {
                break;
            }
            //Check age
            if(age>=18){
                System.out.println("Eligible to vote.");
                int vote = sc.nextInt();
                // Record vote
                if(vote==1){
                    c1++;
                }else if(vote==2){
                    c2++;
                }else if(vote==3){
                    c3++;
                }else{
                    System.out.println("Invalid vote.");
                }
            }else{
                System.out.println("Not eligible to vote.");
            }
            System.out.println();
        }
        // Output
        System.out.println("Candidate 1: " + c1 + " votes");
        System.out.println("Candidate 2: " + c2 + " votes");
        System.out.println("Candidate 3: " + c3 + " votes");
    }
}