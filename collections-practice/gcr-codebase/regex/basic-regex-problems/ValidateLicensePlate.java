public class ValidateLicensePlate {
    public static boolean isValidPlate(String plate){
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }
    public static void main(String[] args) {
        System.out.println(isValidPlate("AB1234"));
        System.out.println(isValidPlate("A12345"));
    }
}