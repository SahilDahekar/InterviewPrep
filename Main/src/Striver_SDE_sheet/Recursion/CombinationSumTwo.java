
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo{

    public static void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> curr){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i - 1]){
                continue;
            }

            if(arr[i] > target){
                break;
            }

            curr.add(arr[i]);
            findCombination(i + 1, arr, target - arr[i], ans, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> ans = combinationSum2(candidates, target);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}