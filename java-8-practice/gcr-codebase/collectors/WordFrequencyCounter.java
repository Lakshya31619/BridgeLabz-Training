import java.util.*;
import java.util.stream.Collectors;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "think of something you cannot think to think of";
        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> 1, 
                                Integer::sum  
                        ));
        System.out.println(wordCount);
    }
}