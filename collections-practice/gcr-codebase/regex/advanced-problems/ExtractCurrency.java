import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The total price sums up to Rs.50";
        String regex = "Rs\\.\\d+(\\.\\d{2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}