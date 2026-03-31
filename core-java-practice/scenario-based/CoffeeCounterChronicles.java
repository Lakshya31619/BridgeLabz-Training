import java.util.Scanner;
public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coffee;
        int quantity = 0;
        double price = 0;
        double total = 0;
        double gst = 0;
        double finalBill = 0;
        while (true) {
            coffee = sc.next(); //Enter coffee type (Bru/Nescafe/Cappuccino)
            if (coffee.equalsIgnoreCase("exit")) { //If user inputs exit then break
                break;
            }
            quantity = sc.nextInt(); //Enter quantity
            switch (coffee.toLowerCase()) {
                case "bru":
                    price = 40;
                    break;
                case "nescafe":
                    price = 50;
                    break;
                case "cappuccino":
                    price = 60;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue;
            }
            //Calculation of bill
            total = price * quantity;
            gst = total * 0.05;
            finalBill = total + gst;
            System.out.println("Final Bill: INR " + finalBill);
        }
    }
}