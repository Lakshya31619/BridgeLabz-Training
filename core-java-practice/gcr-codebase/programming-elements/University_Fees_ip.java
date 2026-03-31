import java.util.Scanner;
public class University_Fees_ip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fee = sc.nextInt(); //University Fees
        int discountPercent = sc.nextInt(); //Discount Percentage
        double discount = (fee*discountPercent)/100; //Discount Amount
        double pay = fee-discount; //Discounted Fees
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+pay);
    }
}