import java.util.*;

public class URLValidator {
    static Set<String> seen = new HashSet<>();

    static String validate(String url){

        if(!url.matches("^(http://|https://).+\\..+$"))
            return "INVALID URL: format is invalid";

        if(!(url.startsWith("http://") || url.startsWith("https://")))
            return "INVALID URL: protocol is invalid";

        String body = url.replaceFirst("https?://", "");
        String[] parts = body.split("\\.");

        if(parts.length != 2)
            return "INVALID URL: format is invalid";

        String name = parts[0];
        String domain = "." + parts[1];

        if(!name.matches("[a-z]{1,10}"))
            return "INVALID URL: website name is invalid";

        if(!domain.matches("\\.(com|co|in|org|gov)"))
            return "INVALID URL: domain is invalid";

        if(seen.contains(url))
            return "DUPLICATE URL FOUND";

        seen.add(url);
        return "VALID URL";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){
            System.out.println(validate(sc.nextLine()));
        }
    }
}