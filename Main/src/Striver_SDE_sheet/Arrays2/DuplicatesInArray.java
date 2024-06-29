package Arrays2;

public class DuplicatesInArray{

    // Slow Approach
    // public static int findDuplicate(int[] nums) {
    //     int n = nums.length;

    //     int i = 0;
    //     while(i < n){
    //         int correct = nums[i] - 1;
    //         if(nums[i] < n && nums[i] != nums[correct]){
    //             swap(nums, correct, i);
    //         } else {
    //             i++;
    //         }
    //     }

    //     for(int k = 0; k < n; k++){
    //         if(nums[k] != k + 1){
    //             return nums[k];
    //         }
    //     }

    //     return n;

    // }
    
    // public static void swap(int[] nums, int a, int b){
    //     int temp = nums[a];
    //     nums[a] = nums[b];
    //     nums[b] = temp;
    // }

    //Better Approach

    // public int findDuplicate(int[] nums) {
    //     int fast = 0;
    //     int slow = 0;

    //     do{
    //         fast = nums[nums[fast]];
    //         slow = nums[slow];
    //     } while(fast != slow);

    //     fast = 0;

    //     while(fast != slow){
    //         fast = nums[fast];
    //         slow = nums[slow];
    //     }

    //     return fast;
    // }


    // Fastest Approach
    public static int findDuplicate(int[] nums) {
        boolean[] repeat = new boolean[nums.length];

        for(int i = 0; i<nums.length; i++){
            if(repeat[nums[i]]){
                return nums[i];
            }
            repeat[nums[i]] = true;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}