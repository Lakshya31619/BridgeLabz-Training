import java.util.Scanner;
public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input Number of students
        int n = sc.nextInt();
        //Output //Calling maxHandshakes method
        if(maxHandshakes(n)==-1){
            System.out.println("Not enough students");
        }else{
            System.out.println("Possible handshakes : "+maxHandshakes(n));
        }
    }
    //Method for maximum handshakes
    public static int maxHandshakes(int n){
        //Check if more than 1 student
        if(n>1){
            //Formula for maximum handshakes
            return (n*(n-1))/2;
        }
        return -1;
    }
}