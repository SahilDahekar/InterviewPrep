package Arrays3;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public static void merge(int[] nums, int low, int mid, int high){
        List<Integer> ls = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                ls.add(nums[left]);
                left++;
            } else {
                ls.add(nums[right]);
                right++;
            }
        }

        while(left <= mid){
            ls.add(nums[left]);
            left++;
        }

        while(right <= high){
            ls.add(nums[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            nums[i] = ls.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high){
        int right = mid + 1;
        int cnt = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && arr[i] > (2 * (long)arr[right])){
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low >= high){
            return cnt;
        }

        int mid = low + (high - low)/2;

        cnt += mergeSort(nums, low , mid);
        cnt += mergeSort(nums, mid + 1 , high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low , mid , high);
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        int n = nums.length;
        System.out.println(mergeSort(nums, 0, n - 1));
    }
}
