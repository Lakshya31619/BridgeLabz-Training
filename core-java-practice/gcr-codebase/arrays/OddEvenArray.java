import java.util.Scanner;
public class OddEvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("A natural number is required.");
            return;
        }
        int[] odd = new int[(n/2)+1];
        int[] even = new int[(n/2)+1];
        int e_index = 0; //Even index
        int o_index = 0; //Odd index
        //Storing in odd/even arrays
        for(int i=1; i<=n; i++){
            if(i%2 == 0){
                even[e_index++] = i;
            } else {
                odd[o_index++] = i;
            }
        }
        System.out.print("Odd Numbers : ");
        for(int i=0; i<o_index; i++){
            System.out.print(odd[i] + " ");
        }
        System.out.println();
        System.out.print("Even Numbers : ");
        for(int i=0; i<e_index; i++){
            System.out.print(even[i] + " ");
        }
    }
}