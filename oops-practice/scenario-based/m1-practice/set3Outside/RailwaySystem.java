import java.util.*;

class Booking{
    String pid; int seats, fare;
    Booking(String p,int s,int f){pid=p; seats=s; fare=f;}
}

class Train{
    String id, src, dest;
    int total, base;
    int booked=0;
    List<Booking> list=new ArrayList<>();

    Train(String i,String s,String d,int t,int b){
        id=i; src=s; dest=d; total=t; base=b;
    }
}

public class RailwaySystem{
    static List<Train> trains=new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){
            String[] in=sc.nextLine().split(" ");

            switch(in[0]){
                case "ADDTRAIN":
                    boolean ex=false;
                    for(Train t:trains) if(t.id.equals(in[1])) ex=true;
                    if(!ex)
                        trains.add(new Train(in[1],in[2],in[3],
                                Integer.parseInt(in[4]),
                                Integer.parseInt(in[5])));
                    break;

                case "BOOK":
                    Train t=null;
                    for(Train x:trains) if(x.id.equals(in[1])) t=x;

                    if(t==null || t.total-t.booked < Integer.parseInt(in[3])){
                        System.out.println("Booking failed");
                    } else {
                        int seats=Integer.parseInt(in[3]);
                        int fare=(seats*t.base)+(seats*25);
                        t.booked+=seats;
                        t.list.add(new Booking(in[2],seats,fare));
                        System.out.println("BOOKED "+t.id+" "+in[2]+" "+fare);
                    }
                    break;

                case "CANCEL":
                    for(Train x:trains){
                        if(x.id.equals(in[1])){
                            Iterator<Booking> it=x.list.iterator();
                            boolean found=false;
                            while(it.hasNext()){
                                Booking b=it.next();
                                if(b.pid.equals(in[2])){
                                    x.booked-=b.seats;
                                    it.remove();
                                    System.out.println("CANCELLED "+x.id+" "+in[2]);
                                    found=true;
                                }
                            }
                            if(!found) System.out.println("Cancellation failed");
                        }
                    }
                    break;

                case "ROUTE":
                    boolean found=false;
                    for(Train x:trains){
                        if(x.src.equals(in[1]) && x.dest.equals(in[2])){
                            System.out.println(x.id+" "+(x.total-x.booked));
                            found=true;
                        }
                    }
                    if(!found) System.out.println("No trains available");
                    break;

                case "SUMMARY":
                    for(Train x:trains){
                        int sum=0;
                        for(Booking b:x.list) sum+=b.fare;
                        System.out.println(x.id+" "+sum);
                    }
                    break;
            }
        }
    }
}