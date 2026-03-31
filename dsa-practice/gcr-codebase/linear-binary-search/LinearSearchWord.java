public class LinearSearchWord {
    static String findSentence(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) return s;
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {"Linear search is simple", "Data structures are important"};
        String word = "search";
        System.out.println(findSentence(sentences, word));
    }
}