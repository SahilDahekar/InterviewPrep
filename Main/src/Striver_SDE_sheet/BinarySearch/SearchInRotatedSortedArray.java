package BinarySearch;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[s] <= nums[mid]){
                if(target > nums[mid] || target < nums[s]){
                    s = mid + 1;
                }else{
                    e = mid - 1;
                }
            }
            else{
                if(target < nums[mid] || target > nums[e]){
                    e = mid - 1;
                }else{
                    s = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
