import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class ListNthFromEnd {
    public static int getFromEnd(LinkedList<Integer> ls, int k){
        ListIterator<Integer> fast = ls.listIterator();
        ListIterator<Integer> slow = ls.listIterator();
        for (int i=0; i<k; i++){
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is greater than list length");
            }
            fast.next();
        }
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        return slow.next();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in list : ");
        int n = sc.nextInt();
        LinkedList <Integer> ls = new LinkedList<>();
        System.out.print("Enter elemets in list : ");
        for(int i=0; i<n; i++){
            ls.add(sc.nextInt());
        }
        System.out.print("Enter nth element from last : ");
        int k = sc.nextInt();
        System.out.println(getFromEnd(ls, k));
    }
}