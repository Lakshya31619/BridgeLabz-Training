import java.util.Scanner;
import java.util.HashSet;
public class SetEquals {
    public static boolean checkEqual(HashSet<Integer> hs1, HashSet<Integer> hs2){
        if(hs1.equals(hs2)){
            return true;
        }
        return false;
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
        System.out.println(checkEqual(hs1, hs2));
    } 
}