import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input String
        String s = sc.next();
        //Calling method findFrequent
        char ch = findFrequent(s);
        //Output
        System.out.println("Most Frequent Character in string "+s+" is : "+ch);
    }
    //Method to find most frequent character in string
    public static char findFrequent(String s){
        char ch = s.charAt(0);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            int count = 0;
            for(int j=0; j<s.length(); j++){
                if(x==s.charAt(j)){
                    count++;
                }
            }
            if(max<count){
                max = count;
                ch = x;
            }
        }
        return ch;
    }
}