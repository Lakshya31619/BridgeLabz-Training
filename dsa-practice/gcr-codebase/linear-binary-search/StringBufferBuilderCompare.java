import java.util.Scanner;
public class StringBufferBuilderCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long [] time = compareBufferBuilder(s);
        System.out.println("StringBuffer Time : "+time[0]);
        System.out.println("StringBuilder Time : "+time[1]);
        compareTime(time);
    }
    public static long[] compareBufferBuilder(String s){
        //StringBuffer
        StringBuffer s1 = new StringBuffer();
        long n1 = System.nanoTime();
        for(int i=0; i<s.length(); i++){
            s1.append(s.charAt(i));
        }
        long t1 = System.nanoTime()-n1;
        //StringBuilder
        StringBuilder s2 = new StringBuilder();
        long n2 = System.nanoTime();
        for(int i=0; i<s.length(); i++){
            s2.append(s.charAt(i));
        }
        long t2 = System.nanoTime()-n2;
        return new long[]{t1, t2};
    }
    public static void compareTime(long[] time){
        if(time[0]<time[1]){
            System.out.println("StringBuffer is faster.");
        }else if(time[1]<time[0]){
            System.out.println("StringBuilder is faster.");
        }else{
            System.out.println("Both has equal time.");
        }
    }
}