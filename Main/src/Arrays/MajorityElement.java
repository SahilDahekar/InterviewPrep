package Arrays;

public class MajorityElement {
    public static int getMajority(int[] nums){
        int cnt = 0;
        int el = nums[0];
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if (cnt == 0) {
                el = nums[i];
            } else if(nums[i] == el){
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == el){
                cnt1++;
            }
        }

        if(cnt1 > n/2){
            return el;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        System.out.println(getMajority(nums));
    }
}
