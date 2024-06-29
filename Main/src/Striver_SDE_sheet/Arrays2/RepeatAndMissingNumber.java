package Arrays2;

import java.util.Arrays;

public class RepeatAndMissingNumber {
    public static int[] repeatedNumber(int[] arr) {
        int n = arr.length;  // n is the length of the array

        // Initialize variables
        int xor1 = 0;
        int setBitNo;
        int x = 0;
        int y = 0;

        // Calculate xor1, which is the XOR of all elements in arr and all numbers from 1 to n
        for (int i = 0; i < n; i++) {
            xor1 ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        // Get the rightmost set bit in xor1
        setBitNo = xor1 & ~(xor1 - 1);

        // Divide elements in two sets based on the set bit
        for (int i = 0; i < n; i++) {
            if ((arr[i] & setBitNo) != 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBitNo) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        // Determine which of x or y is the duplicate and which is missing
        boolean xRepeat = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                xRepeat = true;
                break;
            }
        }

        int[] ans = new int[2];
        if (xRepeat) {
            ans[0] = x;  // x is the repeated number
            ans[1] = y;  // y is the missing number
        } else {
            ans[0] = y;  // y is the repeated number
            ans[1] = x;  // x is the missing number
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        System.out.println(Arrays.toString(repeatedNumber(arr)));
    }
}
