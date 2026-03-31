import java.util.Scanner;
public class LexicalTwist {
    public static String reverse(String s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev += s.charAt(i);
        }
        return rev;
    }
    public static int countVowels(String s){
        int vowel = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
                vowel++;
            }
        }
        return vowel;
    }
    public static int countConsonants(String s){
        int conso = 0;
        for(int i=0; i<s.length(); i++){
            if((s.charAt(i)!='A' && s.charAt(i)!='E' && s.charAt(i)!='I'&& s.charAt(i)!='O' && s.charAt(i)!='U')){
                conso++;
            }
        }
        return conso;
    }
    public static boolean isVowel(Character x){
        if(x=='A'||x=='E'||x=='I'||x=='O'||x=='U'){
            return true;
        }
        return false;
    }
    public static boolean isConsonant(Character x){
        if((x!='A' && x!='E' && x!='I'&& x!='O' && x!='U')){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First String : ");
        String s1 = sc.nextLine();
        if(s1.contains(" ")){
            System.out.println(s1 + " is an invalid word.");
            return;
        }
        System.out.print("Enter Second String : ");
        String s2 = sc.nextLine();
        //Case Insensitive
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        String s2Reverse = reverse(s2);
        //Case 1
        if(s1.equals(s2Reverse)){
            String s1Reverse = reverse(s1);
            s1Reverse = s1Reverse.toLowerCase();
            String res = "";
            for(int i=0; i<s1Reverse.length(); i++){
                if(s1Reverse.charAt(i)=='a'||s1Reverse.charAt(i)=='e'||s1Reverse.charAt(i)=='i'||s1Reverse.charAt(i)=='o'||s1Reverse.charAt(i)=='u'){
                    res += '@';
                }else{
                    res += s1Reverse.charAt(i);
                }
            }
            System.out.println(res);
        }else{
            String combo = s1+s2;
            combo = combo.toUpperCase();
            int vowel = countVowels(combo);
            int conso = countConsonants(combo);
            if(vowel>conso){
                String ans = "";
                for(int i=0; i<combo.length(); i++){
                    String temp = ""+ combo.charAt(i);
                    if((isVowel(combo.charAt(i))) && !ans.contains(temp)){
                        ans += combo.charAt(i);
                    }
                    temp = "";
                    if(ans.length()==2){
                        System.out.println(ans);
                        break;
                    }
                }
            }else if(vowel<conso){
                String ans = "";
                for(int i=0; i<combo.length(); i++){
                    String temp = ""+ combo.charAt(i);
                    if((isConsonant(combo.charAt(i))) && !ans.contains(temp)){
                        ans += combo.charAt(i);
                    }
                    temp = "";
                    if(ans.length()==2){
                        System.out.println(ans);
                        break;
                    }
                }
            }else{
                System.out.println("Vowels and Consonants are equal.");
            }
        }
    }
}