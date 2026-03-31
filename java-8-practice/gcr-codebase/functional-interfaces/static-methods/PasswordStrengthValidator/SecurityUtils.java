public interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[@#$%^&+=!].*");
        return hasUpperCase && hasDigit && hasSpecialChar;
    }
}