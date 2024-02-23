package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }

        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[] {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
