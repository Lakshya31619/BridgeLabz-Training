import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class ListFrequency {
    public static HashMap<String, Integer> getFrequency(List<String> ls, HashMap<String, Integer> hm){
        for(int i=0; i<ls.size(); i++){
            hm.put(ls.get(i), hm.getOrDefault(ls.get(i), 0)+1);
        }
        return hm;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items in list : ");
        int n = sc.nextInt();
        List <String> ls = new ArrayList<>();
        System.out.print("Enter items in list : ");
        for(int i=0; i<n; i++){
            ls.add(sc.next());
        }
        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println(getFrequency(ls, hm));
    }
}