public class University_Fees {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        int discount = (discountPercent*fee)/100;
        int pay = fee-discount;
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+pay);
    }
}
