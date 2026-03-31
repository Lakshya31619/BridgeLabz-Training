public class University_Fees {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        int discount = (discountPercent*fee)/100; //Calculation of discount
        int pay = fee-discount; //Payable amount
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+pay);
    }
}
