import java.util.Scanner;
public class VowelsConsonantsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input String
        String s = sc.nextLine();
        //Calling method countVC
        int [] vc = countVC(s);
        //Output
        System.out.println("Vowel Count : "+vc[0]);
        System.out.println("Consonant Count : "+vc[1]);
    }
    //Method to count vowels and consonants
    public static int[] countVC(String s){
        int v = 0, c = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                v++;
            }else{
                c++;
            }
        }
        return new int[]{v, c};
    }
}