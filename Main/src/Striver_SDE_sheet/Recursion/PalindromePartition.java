import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void findCombinations(String s, int start, List<List<String>> ans, List<String> curr){
        if(start == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                curr.add(s.substring(start, i + 1));
                findCombinations(s, i + 1, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }

        return true;
    } 

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        findCombinations(s, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);
        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
}
