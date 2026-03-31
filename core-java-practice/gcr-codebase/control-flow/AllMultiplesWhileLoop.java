import java.util.Scanner;
public class AllMultiplesWhileLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0 && number<100){ //Positive number and Less than 100
            int i = 100;
            while(i!=1){
                if(i%number==0){
                    System.out.println(i);
                }
                i--;
            }
        }else{
            System.out.println("A postive integer less than 100 is required");
        }
    }
}