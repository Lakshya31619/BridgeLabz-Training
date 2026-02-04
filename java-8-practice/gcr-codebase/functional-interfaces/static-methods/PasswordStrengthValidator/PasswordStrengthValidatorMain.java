public class PasswordStrengthValidatorMain {
    public static void main(String[] args) {
        String[] passwords = {"pass123", "Password1", "Strong@123", "weakpass"};
        for (String pwd : passwords) {
            if (SecurityUtils.isStrongPassword(pwd)) {
                System.out.println("Strong password: " + pwd);
            } else {
                System.out.println("Weak password: " + pwd);
            }
        }
    }
}