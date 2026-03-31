import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, and JavaScript, but I haven't tried Cpp yet.";
        String regex = "\\b(Java|JavaScript|Cpp)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}