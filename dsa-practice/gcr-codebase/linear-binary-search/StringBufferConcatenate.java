import java.util.Scanner;
public class StringBufferConcatenate {
    public static void main(String[] args) {
        //Input String
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of words : ");
        int n = sc.nextInt();
        String [] words = new String[n];
        System.out.println("Enter words in array : ");
        for(int i=0; i<n; i++){
            words[i] = sc.next();
        }
        //Output
        System.out.println(concatBuffer(words));
    }
    public static String concatBuffer(String[] words){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<words.length; i++){
            sb.append(words[i]);
        }
        //Convert StringBuffer to String
        return sb.toString();
    }    
}