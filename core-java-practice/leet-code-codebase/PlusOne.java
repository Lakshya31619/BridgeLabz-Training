import java.util.Scanner;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int [] ans = new int[digits.length+1];
        ans[0] = 1;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] digits = new int[n];
        for(int i=0; i<n; i++){
            digits[i] = sc.nextInt();
        }
        int [] res = plusOne(digits);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}