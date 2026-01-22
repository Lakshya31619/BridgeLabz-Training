import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class SetToSortedList {
    public static ArrayList<Integer> sortSet(HashSet<Integer> hs){
        ArrayList <Integer> ls = new ArrayList<>(hs);
        Collections.sort(ls);
        return ls;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in Set : ");
        int n = sc.nextInt();
        HashSet <Integer> hs = new HashSet<>();
        System.out.print("Enter elements in Set : ");
        for(int i=0; i<n; i++){
            hs.add(sc.nextInt());
        }
        System.out.println("Sorted List : "+sortSet(hs));
    }
}