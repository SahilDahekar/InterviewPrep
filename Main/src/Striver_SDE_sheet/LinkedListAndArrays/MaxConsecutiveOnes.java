package LinkedListAndArrays;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                max = Math.max(cnt, max);
                cnt = 0;
            } else {
                cnt++;
            }
        }

        max = Math.max(cnt, max);

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
