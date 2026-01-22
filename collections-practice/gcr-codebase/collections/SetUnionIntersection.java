import java.util.HashSet;
import java.util.Scanner;
public class SetUnionIntersection {
    public static HashSet<Integer> findUnion(HashSet<Integer> hs1, HashSet<Integer> hs2){
        HashSet<Integer> union = new HashSet<>();
        for(int i : hs1){
            union.add(i);
        }
        for(int i : hs2){
            union.add(i);
        }
        return union;
    }
    public static HashSet<Integer> findIntersection(HashSet<Integer> hs1, HashSet<Integer> hs2){
        HashSet<Integer> intersection = new HashSet<>();
        for(int i : hs1){
            if(hs2.contains(i)){
                intersection.add(i);
            }
        }
        return intersection;
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
        System.out.println("Union of both sets : "+findUnion(hs1, hs2));
        System.out.println("Intersection of both sets : "+findIntersection(hs1, hs2));
    }
}