import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ExtractDates {
    public static void main(String[] args) {
        String text = "Tech Navya is scheduled for 30/01/2026 and 31/01/2026";
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }   
}