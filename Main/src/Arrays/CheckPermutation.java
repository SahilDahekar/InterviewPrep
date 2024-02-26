package Arrays;

public class CheckPermutation {
    public static boolean isCheckPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

                
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isCheckPermutation("anagram", "naramag"));
    }
}
