package Strings2;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        
        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int n : count){
            if(n != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
