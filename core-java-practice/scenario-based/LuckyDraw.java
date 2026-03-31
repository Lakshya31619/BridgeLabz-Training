import java.util.Scanner;
public class LuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input visitors
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            //Input drawn number
            int num = sc.nextInt();
            //Check for invalid input
            if(num<=0){
                continue;
            }
            //Check lucky draw condition
            if(num%3==0 && num%5==0){
                System.out.println("Visitor " + i + " wins a gift");
            }else{
                System.out.println("Visitor " + i + " does not win a gift");
            }
        }
    }
}