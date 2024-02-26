package Arrays;

public class CheckPermutation {
    public static boolean isCheckPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int[] count = new int[256];

        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for(int n : count){
            if(n != 0){
                return false;
            }
        }
                
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isCheckPermutation("anagram", "naramag"));
    }
}
