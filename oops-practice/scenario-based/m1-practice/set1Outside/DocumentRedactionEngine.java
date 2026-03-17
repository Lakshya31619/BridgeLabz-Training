import java.util.*;
import java.util.regex.*;

public class DocumentRedactionEngine {

    static String processLine(String input) {

        // Rule 1: Mask National ID
        input = input.replaceAll("ID:[A-Z]{3}\\d{6}", "ID:XXX******");

        // Rule 2: Mask Bank Account (keep last 4 digits)
        input = input.replaceAll("ACCT-\\d{4}-\\d{4}-(\\d{4})", "ACCT---$1");

        // Rule 3: Remove repeated words (case insensitive)
        input = input.replaceAll("(?i)\\b(\\w+)\\b(?:\\s+\\1\\b)+", "$1");

        // Rule 4: Reduce trailing special chars
        input = input.replaceAll("([!?.])\\1{2,}$", "$1");

        return input;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            System.out.println(processLine(sc.nextLine()));
        }
    }
}