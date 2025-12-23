import java.util.Scanner;
public class StudentCanVote {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        //Input
        int n = sc.nextInt(); //Number of students
        //Ages of students in array
        int [] ages = new int [n];
        for(int i=0; i<n; i++){
            ages[i] = sc.nextInt();
        }
        //Calling canVote function
        String [][] votes = canVote(ages);
        //Output
        for(int i=0; i<votes.length; i++){
            System.out.println("Age : "+votes[i][0]+" | Status : "+votes[i][1]);
        }
    }
    //Function canVote
    public static String[][] canVote(int [] ages){
        String [][] votes = new String[ages.length][2];
        for(int i=0; i<votes.length; i++){
            if(ages[i]<18){
                votes[i][0] = String.valueOf(ages[i]);
                votes[i][1] = "Cannot vote";
            }else{
                votes[i][0] = String.valueOf(ages[i]);
                votes[i][1] = "Can vote";
            }
        }
        return votes;
    }
}