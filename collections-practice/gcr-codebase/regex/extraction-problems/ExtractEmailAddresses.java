import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractEmailAddresses {
    public static void main(String[] args) {
        String text = "Contact us at lakshya316@gmail.com and lakshya619@gmail.com";
        String regex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}