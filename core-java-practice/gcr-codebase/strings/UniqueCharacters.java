import java.util.Scanner;
public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //Calling findUniqueCharacters function
        char [] uniqueChars = findUniqueCharacters(s);
        //Output
        System.out.print("Unique characters: ");
        for(int i=0; i<uniqueChars.length; i++){
            System.out.print(uniqueChars[i] + " ");
        }
    }
    //Function to get length of String
    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }
    //Function to find unique characters
    public static char[] findUniqueCharacters(String s) {
        int len = findLength(s);
        char [] temp = new char[len];
        int uniqueCount = 0;
        for (int i=0; i<len; i++) {
            char ch = s.charAt(i);
            boolean isUnique = true;
            for (int j=0; j<i; j++) {
                if(s.charAt(j)==ch) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) {
                temp[uniqueCount++] = ch;
            }
        }
        // Create new array of exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }   
}