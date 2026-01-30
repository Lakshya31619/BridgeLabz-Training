import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "Hello hello World world.";
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}