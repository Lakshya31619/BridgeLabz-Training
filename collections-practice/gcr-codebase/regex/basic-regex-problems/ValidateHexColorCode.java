public class ValidateHexColorCode {
    public static boolean isValidHexColor(String color){
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }
    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("FFA500"));
    }
}