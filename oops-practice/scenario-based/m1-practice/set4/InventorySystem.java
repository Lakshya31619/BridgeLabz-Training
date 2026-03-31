import java.util.*;

abstract class Product{
    String name; double price; int qty;
    Product(String n,double p,int q){
        name=n; price=p; qty=q;
    }
    abstract void display();
    double total(){ return price*qty; }
}

class Electronics extends Product{
    int warranty;
    Electronics(String n,double p,int q,int w){
        super(n,p,q); warranty=w;
    }
    void display(){
        System.out.println(name+" - Price: "+price+", Quantity: "+qty+", Warranty: "+warranty+" months");
    }
}

class Clothing extends Product{
    String size;
    Clothing(String n,double p,int q,String s){
        super(n,p,q); size=s;
    }
    void display(){
        System.out.println(name+" - Price: "+price+", Quantity: "+qty+", Size: "+size);
    }
}

public class InventorySystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        List<Product> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            String line=sc.nextLine();
            if(line.trim().isEmpty()){ i--; continue; }

            String[] in=line.split(",\\s*");

            if(in[0].equals("Electronics")){
                Product p=new Electronics(in[1],Double.parseDouble(in[2]),
                        Integer.parseInt(in[3]),Integer.parseInt(in[4]));
                list.add(p);
                System.out.println("Product added to inventory: "+in[1]);
            } else {
                Product p=new Clothing(in[1],Double.parseDouble(in[2]),
                        Integer.parseInt(in[3]),in[4]);
                list.add(p);
                System.out.println("Product added to inventory: "+in[1]);
            }
        }

        System.out.println("Inventory:");
        double total=0;
        for(Product p:list){
            p.display();
            total+=p.total();
        }

        System.out.printf("Total value of the inventory: %.2f\n", total);
    }
}