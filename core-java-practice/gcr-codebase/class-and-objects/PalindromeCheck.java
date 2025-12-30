public class PalindromeCheck {
    // PalindromeChecker Class
    static class PalindromeChecker {
        // Attribute
        private String text;
        // Constructor
        public PalindromeChecker(String text) {
            this.text = text;
        }
        // Method to check palindrome
        public boolean isPalindrome() {
            String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
            String reversed = "";
            for (int i = cleanedText.length() - 1; i >= 0; i--) {
                reversed += cleanedText.charAt(i);
            }
            return cleanedText.equals(reversed);
        }
        // Method to display result
        public void displayResult() {
            if (isPalindrome()) {
                System.out.println(text + " is palindrome");
            } else {
                System.out.println(text + " is not Palindrome");
            }
        }
    }
    public static void main(String[] args) {
        // Create PalindromeChecker objects
        PalindromeChecker p1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker p2 = new PalindromeChecker("Hello");
        // Display results
        p1.displayResult();
        p2.displayResult();
    }
}