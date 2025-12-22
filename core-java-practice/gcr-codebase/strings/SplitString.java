import java.util.Scanner;
public class SplitString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.nextLine();
        //Calling Count length
        int count = countLength(s);
        //Calling Count spaces
        int spaces = countSpaces(s);
        //Calling Split array
        String [] w1 = splitArray(s);
        //Output
        System.out.print("Custom split array : ");
        for(int i=0; i<w1.length; i++){
            System.out.print(w1[i]+" ");
        }
        System.out.println();
        //Built-in split
        String [] w2 = s.split(" ");
        //Output
        System.out.print("Built-in split array : ");
        for(int i=0; i<w2.length; i++){
            System.out.print(w2[i]+" ");
        }
        System.out.println();
        //Compare both split string arrays
        System.out.println(compare(w1, w2));
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
        String [] w1 = new String[spaces+1];
        //Custom split words
        String temp = ""; //temp string to store word
        int index = 0; //index pointer for array
        for(int i=0; i<count; i++){
            if(s.charAt(i)!=' '){
                temp += s.charAt(i);
            }else{
                w1[index++] = temp;
                temp = ""; //Empty the temp string
            }
        }
        w1[index] = temp; //last temp string is last word
        return w1;
    }
    public static boolean compare(String [] w1, String [] w2){
        for(int i=0; i<w1.length; i++){
            if(!w1[i].equals(w2[i])){
                return false;
            }
        }
        return true;
    }
}