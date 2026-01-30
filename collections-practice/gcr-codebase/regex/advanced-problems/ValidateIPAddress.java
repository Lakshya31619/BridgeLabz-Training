import java.util.regex.Pattern;
public class ValidateIPAddress {
    public static void main(String[] args) {
        String text = "192.168.1.1";
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"+"(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(text).matches());
    }
}