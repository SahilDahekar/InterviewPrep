package Arrays;

public class KadanesAlgo {

    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            max = Math.max(max, currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
