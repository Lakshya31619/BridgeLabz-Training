import java.util.Scanner;
public class ReplaceWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input string, old word and new word
        String s = sc.nextLine();
        String os = sc.next();
        String ns = sc.next();
        //Calling method replaceWord
        String res = replaceWord(s, os, ns);
        //Output
        System.out.println("New String : "+res);
    }
    //Method to replace old word with new word
    public static String replaceWord(String s, String os, String ns){
        String [] words = s.split(" ");
        for(int i=0; i<words.length; i++){
            if(words[i].equals(os)){
                words[i] = ns;
            }
        }
        String res = " ";
        for(int i=0; i<words.length-1; i++){
            res +=  words[i]+" "; 
        }
        res += words[words.length-1];
        return res;
    }
}