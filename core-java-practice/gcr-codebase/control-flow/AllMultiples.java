import java.util.Scanner;;
public class AllMultiples {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0 && number<100){ //Positive number and Less than 100
            for(int i=100; i>=1; i--){
                if(i%number==0){
                    System.out.println(i);
                }
            }
        }else{
            System.out.println("A postive integer less than 100 is required");
        }
    }
}