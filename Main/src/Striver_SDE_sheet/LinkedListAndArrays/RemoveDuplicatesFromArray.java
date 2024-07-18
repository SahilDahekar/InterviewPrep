package LinkedListAndArrays;

public class RemoveDuplicatesFromArray {
    public static int removeDuplicates(int[] nums) {
        int ptr = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[ptr - 1] != nums[i]){
                nums[ptr] = nums[i];
                ptr++;
            }
        }

        return ptr;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
