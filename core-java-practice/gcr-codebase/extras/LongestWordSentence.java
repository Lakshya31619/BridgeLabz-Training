import java.util.Scanner;
public class LongestWordSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input sentence
        String s = sc.nextLine();
        //Calling method longestWord
        String longest = longestWord(s);
        //Output
        System.out.println("Longest word in given sentence : "+longest);
    }
    //Method to find longest word in the sentence
    public static String longestWord(String s){
        String [] words = s.split(" ");
        int max = Integer.MIN_VALUE;
        String longest = "";
        for(int i=0; i<words.length; i++){
            if(max<words[i].length()){
                max = words[i].length();
                longest = words[i];
            }
        }
        return longest;
    }
}