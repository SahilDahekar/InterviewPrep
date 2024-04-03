package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int start = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            map.put(fruits[i], map.getOrDefault(fruits[i],0) + 1);
            while(map.size() > 2){
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if(map.get(fruits[start]) == 0){
                    map.remove(fruits[start]);
                }
                start++;
            }
            ans = Math.max(ans, i - start + 1);

        }
        
        return ans;
    }

    public static void main(String[] args){
        int[] fruits = new int[]{1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
}
