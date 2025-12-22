import java.util.Scanner;
public class CharacterType {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.next();
        //Calling checkType
        String [][] type = checkType(s);
        //Output
        for(int i=0; i<type.length; i++){
            System.out.println("Character : "+type[i][0]+" | Type : "+type[i][1]);
        }
    }
    //Assign values to 2d array
    public static String[][] checkType(String s){
        s = s.toLowerCase();
        String [][] type = new String[s.length()][2];
        for(int i=0; i<s.length(); i++){
            if(checkVowel(s.charAt(i)).equals("Vowel")){
                type[i][0] = ""+s.charAt(i);
                type[i][1] = "Vowel";
            }else if(checkVowel(s.charAt(i)).equals("Consonant")){
                type[i][0] = ""+s.charAt(i);
                type[i][1] = "Consonant";
            }else{
                type[i][0] = ""+s.charAt(i);
                type[i][1] = "Not a Letter";
            }
        }
        return type;
    }
    //Check vowel, consonant or not a letter
    public static String checkVowel(Character ch){
        if(ch>='a' && ch<='z'){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                return "Vowel";
            }else{
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
}