import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<String>();
        gp(ls,n,0,0,"");
        return ls;
    }
    public static void gp(List<String> ls,int n,int open,int close,String ans) {
		if(open==n && close==n) {
			ls.add(ans);
			return;
		}
		if(n>open) {
			gp(ls,n,open+1,close,ans+"(");
		}
		if(open>close) {
			gp(ls,n,open,close+1,ans+")");
		}
	}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generateParenthesis(n));
    }
}