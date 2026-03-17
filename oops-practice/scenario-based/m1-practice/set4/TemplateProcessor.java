import java.util.*;
import java.util.regex.*;

public class TemplateProcessor {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        Pattern p=Pattern.compile("\\$\\{(\\w+):(.*?)\\}");

        while(n-- >0){
            String line=sc.nextLine();
            Matcher m=p.matcher(line);
            StringBuffer sb=new StringBuffer();

            while(m.find()){
                String type=m.group(1);
                String val=m.group(2);
                String rep="INVALID";

                try{
                    switch(type){
                        case "UPPER": rep=val.toUpperCase(); break;
                        case "LOWER": rep=val.toLowerCase(); break;
                        case "DATE":
                            String[] d=val.split("-");
                            if(d.length==3)
                                rep=d[2]+"/"+d[1]+"/"+d[0];
                            break;
                        case "REPEAT":
                            String[] r=val.split(",");
                            int c=Integer.parseInt(r[1]);
                            rep="";
                            for(int i=0;i<c;i++) rep+=r[0];
                            break;
                    }
                }catch(Exception e){ rep="INVALID"; }

                m.appendReplacement(sb, rep);
            }
            m.appendTail(sb);
            System.out.println(sb.toString());
        }
    }
}