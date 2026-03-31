import java.util.Scanner;
public class StringFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null || s.isEmpty()) {
            System.out.println(s);
            return;
        }
        String sTrim = trimString(s);
        String sPunc = spacePunctuation(sTrim);
        String cAfterPunc = capitalAfterPunctuation(sPunc);
        System.out.println(cAfterPunc);
    }
    public static String trimString(String s){
        String sTrim = s.trim().replaceAll("\\s+", " ");
        return sTrim;
    }
    public static String spacePunctuation(String sTrim){
        String sPunc = sTrim.replaceAll("\\s*([.!?,])\\s*", "$1 ");
        return sPunc;
    }
    public static String capitalAfterPunctuation(String sPunc){
        StringBuilder result = new StringBuilder(sPunc.length());
        boolean capitalizeNext = true;
        for (char ch : sPunc.toCharArray()) {
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }
            if (ch == '.' || ch == '!' || ch == '?') {
                capitalizeNext = true;
            }
        }
        return result.toString().trim();
    }
}