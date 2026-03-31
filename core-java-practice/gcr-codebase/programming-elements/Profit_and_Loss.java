public class Profit_and_Loss {
    public static void main(String[] args) {
        int cp = 129; //Cost Price
        int sp = 191; //Selling Price
        int p = sp-cp; //Profit
        double pp = (p*100/cp); //Profit Percentage
        System.out.println("The Cost Price is INR "+cp+"and Selling Price is INR "+sp+ "\n" + "The Profit is INR "+p+" and the Profit Percentage is "+pp+"%");
    }
}
