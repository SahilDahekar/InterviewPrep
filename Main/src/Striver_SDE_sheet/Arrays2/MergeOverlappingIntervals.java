package Arrays2;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> mergeList = new LinkedList<>();
        for(int[] interval : intervals){
            if(mergeList.isEmpty() || mergeList.getLast()[1] < interval[0]){
                mergeList.add(interval);
            } else {
                mergeList.getLast()[1] = Math.max(mergeList.getLast()[1], interval[1]);
            }
        }

        return mergeList.toArray(new int[mergeList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}
