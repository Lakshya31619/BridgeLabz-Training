import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
public class ListReverse {
    public static ArrayList<Integer> reverseArrayList(ArrayList <Integer> al){
        ArrayList <Integer> reversed = new ArrayList<>();
        for(int i=al.size()-1; i>=0; i--){
            reversed.add(al.get(i));
        }
        return reversed;
    }
    public static LinkedList<Integer> reverseLinkedList(LinkedList <Integer> ll){
        LinkedList <Integer> reversed = new LinkedList<>();
        for(int i=ll.size()-1; i>=0; i--){
            reversed.add(ll.get(i));
        }
        return reversed;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in list : ");
        int n = sc.nextInt();
        System.out.print("Enter list elements : ");
        ArrayList <Integer> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(sc.nextInt());
        }
        LinkedList <Integer> ll = new LinkedList<>();
        for(int i=0; i<n; i++){
            ll.add(al.get(i));
        }
        al = reverseArrayList(al);
        System.out.println("Reversed ArrayList : "+al);
        ll = reverseLinkedList(ll);
        System.out.println("Reversed LinkedList : "+ll);
    }
}