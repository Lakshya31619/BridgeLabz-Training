import java.util.regex.Pattern;
public class ValidateSSN {
    public static void main(String[] args) {
        String text = "123-45-6789";
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(text).matches());
    }
}