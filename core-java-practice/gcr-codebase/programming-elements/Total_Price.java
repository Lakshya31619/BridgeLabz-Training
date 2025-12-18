import java.util.Scanner;
public class Total_Price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int unit_price = sc.nextInt(); //Unit Price 
        int quantity = sc.nextInt(); //Quantity
        int total = unit_price*quantity; //Total Price
        System.out.println("The total purchase price is INR "+total+" if the quantity "+quantity+" and unit price is INR "+unit_price);
    }
}
