import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < n; i++){
            fact = fact * i;
            num.add(i);
        }
        num.add(n);
        k--;
        StringBuilder ans = new StringBuilder();

        while(true){
            ans.append(num.get(k/fact));
            num.remove(k/fact);
            if(num.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / num.size();
        } 
        return ans.toString();
    }
    
    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n, k));
    }
}
