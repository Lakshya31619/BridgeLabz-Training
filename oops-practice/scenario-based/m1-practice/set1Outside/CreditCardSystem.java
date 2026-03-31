import java.util.*;

class Transaction {
    String type;
    int amount;
    int remaining;
    Transaction(String t,int a,int r){
        type=t; amount=a; remaining=r;
    }
}

class Card {
    String number, holder;
    int limit, available;
    List<Transaction> list = new ArrayList<>();

    Card(String n,String h,int l){
        number=n; holder=h; limit=l; available=l;
    }
}

public class CreditCardSystem {
    static Map<String, Card> map = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            String[] in = sc.nextLine().split(" ");

            switch(in[0]){
                case "ISSUE":
                    map.putIfAbsent(in[1], new Card(in[1], in[2], Integer.parseInt(in[3])));
                    break;

                case "SPEND":
                    Card c = map.get(in[1]);
                    if(c == null || c.available < Integer.parseInt(in[2])){
                        System.out.println("Transaction declined");
                    } else {
                        int amt = Integer.parseInt(in[2]);
                        c.available -= amt;
                        c.list.add(new Transaction("SPEND", amt, c.available));
                        System.out.println("SPENT "+c.number+" "+c.available);
                    }
                    break;

                case "PAYMENT":
                    c = map.get(in[1]);
                    if(c == null){
                        System.out.println("Card not found");
                    } else {
                        int amt = Integer.parseInt(in[2]);
                        c.available = Math.min(c.limit, c.available + amt);
                        c.list.add(new Transaction("PAYMENT", amt, c.available));
                        System.out.println("PAYMENT DONE "+c.number+" "+c.available);
                    }
                    break;

                case "HOLDER":
                    List<Card> res = new ArrayList<>();
                    for(Card x: map.values())
                        if(x.holder.equals(in[1])) res.add(x);

                    if(res.isEmpty()){
                        System.out.println("No cards found");
                    } else {
                        res.sort((a,b)->a.number.compareTo(b.number));
                        for(Card x: res)
                            System.out.println(x.number+" "+x.available);
                    }
                    break;
            }
        }
    }
}