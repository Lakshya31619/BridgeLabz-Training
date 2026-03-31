import java.util.Scanner;
public class SplitWordLength {
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
        //Initialize 2d array
        String [][] wordLength = new String[words.length][2];
        //Store in 2d array
        for(int i=0; i<words.length; i++){
            wordLength[i][0] = words[i];
            wordLength[i][1] = String.valueOf(countLength(words[i]));
        }
        //Output
        for(int i=0; i<words.length; i++){
            System.out.print("Word : "+wordLength[i][0]);
            System.out.println(" | Length : "+Integer.parseInt(wordLength[i][1]));
        }
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