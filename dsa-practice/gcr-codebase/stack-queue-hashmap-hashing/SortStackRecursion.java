import java.util.Stack;
import java.util.Scanner;
public class SortStackRecursion {
    public static void sortStack(Stack<Integer> stack) {
        //Base case
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }
    //Helper function
    private static void insertSorted(Stack<Integer> stack, int value) {
        //Base case
        if(stack.isEmpty() || value >= stack.peek()){
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertSorted(stack, value);
        stack.push(top);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Number of elements in queue : ");
        int n = sc.nextInt();
        System.out.print("Enter queue elements : ");
        for(int i=0; i<n; i++){
            stack.push(sc.nextInt());
        }
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}