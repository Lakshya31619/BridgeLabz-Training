import java.util.*;

class Team{
    String id, sec, domain, name;
    int score;
    Team(String i,String s,String d,String n,int sc){
        id=i; sec=s; domain=d; name=n; score=sc;
    }
}

public class ProjectCompetition{
    static List<Team> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){
            String[] in=sc.nextLine().split(" ");

            switch(in[0]){
                case "REGISTER":
                    boolean exists=false;
                    for(Team t:list) if(t.id.equals(in[1])) exists=true;
                    if(!exists)
                        list.add(new Team(in[1],in[2],in[3],in[4],Integer.parseInt(in[5])));
                    break;

                case "REVISE":
                    boolean found=false;
                    for(Team t:list){
                        if(t.id.equals(in[1])){
                            t.score=Integer.parseInt(in[2]);
                            System.out.println("REVISED "+t.id+" "+t.score);
                            found=true;
                        }
                    }
                    if(!found) System.out.println("team is not available");
                    break;

                case "FILTERDOMAIN":
                    boolean f=false;
                    for(Team t:list){
                        if(t.domain.equals(in[1])){
                            System.out.println(t.id+" "+t.sec+" "+t.domain+" "+t.name+" "+t.score);
                            f=true;
                        }
                    }
                    if(!f) System.out.println("Team is not available for the domain: "+in[1]);
                    break;

                case "QUALIFY":
                    int cutoff=Integer.parseInt(in[1]);
                    boolean q=false;
                    for(Team t:list){
                        if(t.score>=cutoff){
                            System.out.println(t.id+" "+t.sec+" "+t.domain+" "+t.name+" "+t.score);
                            q=true;
                        }
                    }
                    if(!q) System.out.println("No team qualified");
                    break;
            }
        }
    }
}