public class CensorBadWords {
    public static void main(String[] args) {
        String text = "Ah shit here we go again.";
        String badWordsRegex = "\\b(shit)\\b";
        String censoredText = text.replaceAll("(?i)" + badWordsRegex, "****");
        System.out.println(censoredText);
    }
}