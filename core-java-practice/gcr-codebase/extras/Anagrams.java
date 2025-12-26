import java.util.Scanner;
public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input two Strings
        String s1 = sc.next();
        String s2 = sc.next();
        //Calling method checkAnagram
        boolean flag = checkAnagram(s1, s2);
        //Output
        if(flag){
            System.out.println("Anagram");
        }else{
            System.out.println("Not Anagram");
        }
    }
    //Method to check if two strings are equal
    public static boolean checkAnagram(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int [] freq1 = new int[26];
        for(int i=0; i<s1.length(); i++){
            freq1[s1.charAt(i)-'a']++;
        }
        int [] freq2 = new int[26];
        for(int i=0; i<s2.length(); i++){
            freq2[s2.charAt(i)-'a']++;
        }
        for(int i=0; i<freq1.length; i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}