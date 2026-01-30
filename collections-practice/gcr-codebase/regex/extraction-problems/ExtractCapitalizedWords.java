import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ExtractCapitalizedWords {
    public static void main(String[] args) {
        String text = "A quick brown Fox jumps over a lazy Dog.";
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}