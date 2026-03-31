import java.util.*;
import java.util.regex.*;

public class ExpressionTagEngine {

    static String evaluate(String input){
        Pattern p = Pattern.compile("\\[(SUM|MUL|MAX|MIN):([-]?(?:0|[1-9]\\d*)(?:,[-]?(?:0|[1-9]\\d*))+)]");
        Matcher m = p.matcher(input);

        StringBuffer sb = new StringBuffer();

        while(m.find()){
            String op = m.group(1);
            String[] nums = m.group(2).split(",");

            int result = Integer.parseInt(nums[0]);

            for(int i=1;i<nums.length;i++){
                int val = Integer.parseInt(nums[i]);
                switch(op){
                    case "SUM": result += val; break;
                    case "MUL": result *= val; break;
                    case "MAX": result = Math.max(result, val); break;
                    case "MIN": result = Math.min(result, val); break;
                }
            }
            m.appendReplacement(sb, String.valueOf(result));
        }
        m.appendTail(sb);

        // replace invalid/broken tags
        return sb.toString().replaceAll("\\[[^]]*]", "ERROR");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        while(n-- >0)
            System.out.println(evaluate(sc.nextLine()));
    }
}