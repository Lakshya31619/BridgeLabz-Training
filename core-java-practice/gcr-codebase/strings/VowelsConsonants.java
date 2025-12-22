import java.util.Scanner;
public class VowelsConsonants {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //input
        String s = sc.next();
        //Calling countVowel
        int [] vc = countVowel(s);
        //Output
        System.out.println("Vowels : "+vc[0]);
        System.out.println("Consonants : "+vc[1]);
    }
    public static int[] countVowel(String s){
        s = s.toLowerCase();
        char [] letters = s.toCharArray();
        int vowels = 0;
        int consonants = 0;
        //Check vowel or consonant using checkVowel()
        for(int i=0; i<s.length(); i++){
            if(checkVowel(letters[i]).equals("Vowel")){
                vowels++;
            }else{
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
    public static String checkVowel(Character ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return "Vowel";
        }else{
            return "Consonant";
        }
    }
}