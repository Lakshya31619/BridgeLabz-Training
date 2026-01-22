import java.util.HashSet;
import java.util.Scanner;
public class SetFindSubsets {
    public static boolean checkSubset(HashSet<Integer> hs1, HashSet<Integer> hs2){
        return hs2.containsAll(hs1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in Set 1 : ");
        int n = sc.nextInt();
        HashSet <Integer> hs1 = new HashSet<>();
        System.out.print("Enter elements in Set 1 : ");
        for(int i=0; i<n; i++){
            hs1.add(sc.nextInt());
        }
        System.out.print("Enter number of elements in Set 2 : ");
        int m = sc.nextInt();
        HashSet <Integer> hs2 = new HashSet<>();
        System.out.print("Enter elements in Set 1 : ");
        for(int i=0; i<m; i++){
            hs2.add(sc.nextInt());
        }
        System.out.println(checkSubset(hs1, hs2));
    }
}