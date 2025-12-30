import java.util.Scanner;
public class LineComparisionProblem {
    public static void main(String[] args) {
        LineComparisionWelcome();
        System.out.println("*Use Case-I*");
        int [] inputs = LineComparisionInput();
        int x1 = inputs[0];
        int x2 = inputs[1];
        int y1 = inputs[2];
        int y2 = inputs[3];
        double length = LineComparisionLength(x1, x2, y1, y2);
        System.out.println("Length of a line : "+length);
        boolean flag = LineComparisionEquals();
        if(flag){
            System.out.println("Both lengths are equal");
        }else{
            System.out.println("Both lengths are not equal");
        }
        LineCompare();
    }
    //Welcome
    public static void LineComparisionWelcome(){
        System.out.println("Welcome to Line Comparision Computation Program");
    }
    //Input
    public static int[] LineComparisionInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input X-coordinates : ");
        String c1 = sc.nextLine();
        System.out.print("Input Y-coordinates : ");
        String c2 = sc.nextLine();
        int x1 = c1.charAt(0)-'0';
        int x2 = c2.charAt(0)-'0';
        int y1 = c1.charAt(c1.length()-1)-'0';
        int y2 = c2.charAt(c2.length()-1)-'0';
        return new int[]{x1, x2, y1, y2};
    }
    //Use Case 1
    public static double LineComparisionLength(int x1, int x2, int y1, int y2){
        double length = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1),2));
        return length;
    }
    //Use Case 2
    public static boolean LineComparisionEquals(){
        System.out.println("**Use Case-II**");
        System.out.println("Input 1st plane coordinates : ");
        int [] input1 = LineComparisionInput();
        int x1 = input1[0];
        int x2 = input1[1];
        int y1 = input1[2];
        int y2 = input1[3];
        double l1 = LineComparisionLength(x1, x2, y1, y2);
        System.out.println("Input 2nd plane coordinates : ");
        int [] input2 = LineComparisionInput();
        x1 = input2[0];
        x2 = input2[1];
        y1 = input2[2];
        y2 = input2[3];
        double l2 = LineComparisionLength(x1, x2, y1, y2);
        System.out.println(l2);
        return l1==l2;
    }
    //Use Case 3
    public static void LineCompare(){
        System.out.println("***Use Case-III***");
        System.out.println("Input 1st plane coordinates : ");
        int [] input1 = LineComparisionInput();
        int x1 = input1[0];
        int x2 = input1[1];
        int y1 = input1[2];
        int y2 = input1[3];
        double l1 = LineComparisionLength(x1, x2, y1, y2);
        System.out.println("Input 2nd plane coordinates : ");
        int [] input2 = LineComparisionInput();
        x1 = input2[0];
        x2 = input2[1];
        y1 = input2[2];
        y2 = input2[3];
        double l2 = LineComparisionLength(x1, x2, y1, y2);
        if(l1==l2){
            System.out.println("Both lengths are equal");
        }else if(l1>l2){
            System.out.println("Length 1 is greater than Length 2");
        }else{
            System.out.println("Length 1 is lesser than Length 2");
        }
    }
}