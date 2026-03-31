import java.util.Stack;
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i)==')'){
                    while(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }
                }
                if(s.charAt(i)=='}'){
                    while(!stack.isEmpty() && stack.peek()=='{'){
                        stack.pop();
                    }
                }
                if(s.charAt(i)==']'){
                    while(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "(())";
        System.out.println(isValid(s));
    }
}