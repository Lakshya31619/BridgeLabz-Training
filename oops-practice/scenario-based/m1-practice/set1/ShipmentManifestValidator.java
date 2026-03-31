import java.util.*;
import java.text.*;

public class Main {

    static boolean isValidCode(String code) {
        if (!code.matches("SHIP-[1-9][0-9]{5}")) return false;

        String digits = code.substring(5);
        int count = 1;

        for (int i = 1; i < digits.length(); i++) {
            if (digits.charAt(i) == digits.charAt(i - 1)) {
                count++;
                if (count > 3) return false;
            } else {
                count = 1;
            }
        }
        return true;
    }

    static boolean isValidDate(String date) {
        try {
            if (!date.matches("20\\d{2}-\\d{2}-\\d{2}")) return false;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isValidMode(String mode) {
        return Arrays.asList("AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT")
                .contains(mode);
    }

    static boolean isValidWeight(String weight) {
        if (!weight.matches("([1-9]\\d{0,5}|0)(\\.\\d{1,2})?")) return false;
        double val = Double.parseDouble(weight);
        return val > 0 && val <= 999999.99;
    }

    static boolean isValidStatus(String status) {
        return Arrays.asList("DELIVERED", "CANCELLED", "IN_TRANSIT")
                .contains(status);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\|");

            if (parts.length != 5) {
                System.out.println("NON-COMPLIANT RECORD");
                continue;
            }

            if (isValidCode(parts[0]) &&
                isValidDate(parts[1]) &&
                isValidMode(parts[2]) &&
                isValidWeight(parts[3]) &&
                isValidStatus(parts[4])) {

                System.out.println("COMPLIANT RECORD");
            } else {
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
    }
}