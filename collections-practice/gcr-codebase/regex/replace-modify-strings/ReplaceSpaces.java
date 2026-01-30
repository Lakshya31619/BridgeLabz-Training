public class ReplaceSpaces {
    public static void main(String[] args) {
        String text = "Hello  World   How  are    you.";
        String result = text.replaceAll("\\s+", " ");
        System.out.println(result);
    }
}