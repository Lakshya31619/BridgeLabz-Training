import java.util.Scanner;
import java.util.ArrayList;
public class ListRemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> ls){
        ArrayList <Integer> removed = new ArrayList<>();
        for(int i=0; i<ls.size(); i++){
            if(!removed.contains(ls.get(i))){
                removed.add(ls.get(i));
            }
        }
        return removed;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in list : ");
        int n = sc.nextInt();
        ArrayList <Integer> ls = new ArrayList<>();
        System.out.print("Enter elemets in list : ");
        for(int i=0; i<n; i++){
            ls.add(sc.nextInt());
        }
        System.out.println(removeDuplicates(ls));
    }   
}