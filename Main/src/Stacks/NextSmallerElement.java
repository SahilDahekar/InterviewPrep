package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        int index = n - 1;

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i >= 0; i--){
            int num = nums[i];
            while(!st.isEmpty() && st.peek() >= num){
                st.pop();
            }

            if(st.isEmpty()){
                res[index--] = -1;
            } else {
                res[index--] = st.peek();
            }

            st.push(num);
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,4,3};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
