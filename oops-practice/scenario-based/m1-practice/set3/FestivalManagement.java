import java.util.*;

abstract class Festival{
    String name, location, date;
    Festival(String n,String l,String d){
        name=n; location=l; date=d;
    }
    abstract void display();
}

class Music extends Festival{
    String headliner, genre; int price;
    Music(String n,String l,String d,String h,String g,int p){
        super(n,l,d); headliner=h; genre=g; price=p;
    }
    void display(){
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Headliner: "+headliner);
        System.out.println("Music Genre: "+genre);
        System.out.println("Ticket Price: "+price);
    }
}

class Food extends Festival{
    String cuisine; int stalls, fee;
    Food(String n,String l,String d,String c,int s,int f){
        super(n,l,d); cuisine=c; stalls=s; fee=f;
    }
    void display(){
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Cuisine: "+cuisine);
        System.out.println("Number of Stalls: "+stalls);
        System.out.println("Entry Fee: "+fee);
    }
}

class Art extends Festival{
    String type; int artists, fee;
    Art(String n,String l,String d,String t,int a,int f){
        super(n,l,d); type=t; artists=a; fee=f;
    }
    void display(){
        System.out.println("Festival Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Art Type: "+type);
        System.out.println("Number of Artists: "+artists);
        System.out.println("Exhibition Fee: "+fee);
    }
}

public class FestivalManagement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<String,Festival> map=new HashMap<>();

        while(true){
            String line=sc.nextLine();
            if(line.equals("EXIT")) break;

            String[] in=line.split(" ");

            if(in[0].equals("ADD_FESTIVAL")){
                if(in[1].equals("MUSIC")){
                    map.put(in[2], new Music(in[2],in[3],in[4],in[5],in[6],Integer.parseInt(in[7])));
                }
                else if(in[1].equals("FOOD")){
                    map.put(in[2], new Food(in[2],in[3],in[4],in[5],Integer.parseInt(in[6]),Integer.parseInt(in[7])));
                }
                else{
                    map.put(in[2], new Art(in[2],in[3],in[4],in[5],Integer.parseInt(in[6]),Integer.parseInt(in[7])));
                }
            }
            else if(in[0].equals("DISPLAY_DETAILS")){
                map.get(in[1]).display();
            }
        }
    }
}