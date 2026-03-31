import java.util.function.Function;
public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = message -> message.length();
        int maxLength = 50;
        String[] messages = {
                "Hello",
                "This is a short message",
                "This message is definitely going to exceed the allowed character limit"
        };
        for (String msg : messages) {
            int length = stringLength.apply(msg);
            if (length > maxLength) {
                System.out.println("Message too long (" + length + " chars): " + msg);
            } else {
                System.out.println("Message accepted (" + length + " chars): " + msg);
            }
        }
    }
}