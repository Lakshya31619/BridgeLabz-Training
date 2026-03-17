import java.util.*;

abstract class Account{
    String id,name;
    double bal;
    Account(String i,String n,double b){id=i; name=n; bal=b;}
    abstract boolean withdraw(double amt);
    void deposit(double amt){bal+=amt;}
}

class Savings extends Account{
    Savings(String i,String n,double b){super(i,n,b);}
    boolean withdraw(double amt){
        double total=amt+2;
        if(bal-total<0) return false;
        bal-=total; return true;
    }
}

class Current extends Account{
    Current(String i,String n,double b){super(i,n,b);}
    boolean withdraw(double amt){
        double total=amt+5;
        if(bal-total<-10000) return false;
        bal-=total; return true;
    }
}

class Business extends Account{
    Business(String i,String n,double b){super(i,n,b);}
    boolean withdraw(double amt){
        double charge=amt*0.01;
        double total=amt+charge;
        if(bal-total<-50000) return false;
        bal-=total; return true;
    }
}

public class BankAccountSystem{
    static Map<String,Account> map=new HashMap<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){
            String[] in=sc.nextLine().split(" ");

            switch(in[0]){
                case "Create":
                    Account a=null;
                    if(in[3].equals("SavingsAccount"))
                        a=new Savings(in[1],in[2],Double.parseDouble(in[4]));
                    else if(in[3].equals("CurrentAccount"))
                        a=new Current(in[1],in[2],Double.parseDouble(in[4]));
                    else
                        a=new Business(in[1],in[2],Double.parseDouble(in[4]));

                    map.put(in[1],a);
                    System.out.println("Account Created: "+in[1]);
                    break;

                case "Deposit":
                    a=map.get(in[1]);
                    if(a==null) System.out.println("Account Not Found");
                    else{
                        a.deposit(Double.parseDouble(in[2]));
                        System.out.println("Deposited Successfully");
                    }
                    break;

                case "Withdraw":
                    a=map.get(in[1]);
                    if(a==null) System.out.println("Account Not Found");
                    else{
                        if(a.withdraw(Double.parseDouble(in[2])))
                            System.out.println("Withdrawal Successful");
                        else
                            System.out.println("Insufficient Funds");
                    }
                    break;
            }
        }
    }
}