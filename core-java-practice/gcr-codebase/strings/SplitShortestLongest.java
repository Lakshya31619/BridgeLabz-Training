import java.util.Scanner;
public class SplitShortestLongest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.nextLine();
        //Calling Count length
        int count = countLength(s);
        //Calling Count spaces
        int spaces = countSpaces(s);
        //Calling Split array
        String [] words = splitArray(s);
        int min = Integer.MAX_VALUE; //Minimum length
        int max = Integer.MIN_VALUE; //Maximum length
        String shortest = "";
        String longest = "";
        //Longest and shortest word
        for(int i=0; i<words.length; i++){
            if(countLength(words[i])>max){
                max = countLength(words[i]);
                longest = words[i];
            }
            if(countLength(words[i])<min){
                min = countLength(words[i]);
                shortest = words[i];
            }
        }
        //Output
        System.out.println("Longest word : "+longest);
        System.out.println("Shortest word : "+shortest);
    }
    public static int countLength(String s){
        int count = 0; //Length of string
        try{
            while(true){
                s.charAt(count);
                count++;
            }
        }catch(StringIndexOutOfBoundsException e){}
        return count;
    }
    public static int countSpaces(String s){
        int count = countLength(s);
        int spaces = 0;
        for(int i=0; i<count; i++){
            if(s.charAt(i)==' '){
                spaces++;
            }
        }
        return spaces;
    }
    public static String [] splitArray(String s){
        int count = countLength(s);
        int spaces = countSpaces(s);
        String [] words = new String[spaces+1];
        //Custom split words
        String temp = ""; //temp string to store word
        int index = 0; //index pointer for array
        for(int i=0; i<count; i++){
            if(s.charAt(i)!=' '){
                temp += s.charAt(i);
            }else{
                words[index++] = temp;
                temp = ""; //Empty the temp string
            }
        }
        words[index] = temp; //last temp string is last word
        return words;
    }
}