package GreedyAlgorithm;

public class JumpOne {
    public static boolean canJump(int[] nums) {
        int jumps = 0;
        
        for(int i=0; i<nums.length; i++){
        
            if(jumps < i){
                return false;
            }
            
            jumps = Math.max(jumps, i + nums[i]);
            
        }
        
        return true; 
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
