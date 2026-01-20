import java.util.*;
public class ContainsDuplicate {
    public static boolean findDuplicate(int[] nums){
        List<Integer> ls = new ArrayList<>();
        for(int num : nums){
            if(ls.contains(num)){
                return false;
            }
            ls.add(num);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findDuplicate(nums));
    }
}