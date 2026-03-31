import java.util.Scanner;
import java.util.ArrayList;
public class ListRotateElements {
    public static ArrayList<Integer> rotate(ArrayList<Integer> ls, int k){
        ArrayList <Integer> rotated = new ArrayList<>();
        for(int i=0; i<ls.size(); i++){
            if(i>=k){
                rotated.add(ls.get(i));
            }
        }
        for(int i=0; i<ls.size(); i++){
            if(i<k){
                rotated.add(ls.get(i));
            }
        }
        return rotated;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in list : ");
        int n = sc.nextInt();
        ArrayList <Integer> ls = new ArrayList<>();
        System.out.print("Enter elements in list : ");
        for(int i=0; i<n; i++){
            ls.add(sc.nextInt());
        }
        System.out.print("Rotate by : ");
        int k = sc.nextInt();
        System.out.println("Rotated list by "+k+" :"+rotate(ls, k));
    }   
}