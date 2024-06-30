package Arrays3;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int el = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]){
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int k = 0; k < nums.length; k++){
            if(nums[k] == el){
                cnt1++;
            }
        }

        if(cnt1 > nums.length/2){
            return el;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
