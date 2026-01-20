//Booyer Moore Voting Algorithm
public class MajorityElement {
    //O(n)
    public static int findElement(int[] nums){
        int count = 0;
        int k = 0;
        for(int num : nums){
            if(count==0){
                k = num;
            }
            if(num==k){
                count++;
            }else{
                count--;
            }
        }
        return k;
    }
    //O(nlogn)
    //public static int findElement(int[] nums){
    //  Arrays.sort(nums);
    //  return nums[nums.length/2];
    //}
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,1};
        System.out.println(findElement(nums));
    }
}