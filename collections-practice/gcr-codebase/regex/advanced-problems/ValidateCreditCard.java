import java.util.regex.Pattern;
public class ValidateCreditCard {
    public static void main(String[] args) {
        String visa = "4123456789012345";
        String masterCard = "5123456789012345";
        String regex = "^(4|5)\\d{15}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(visa).matches());
        System.out.println(pattern.matcher(masterCard).matches());
    }
}

