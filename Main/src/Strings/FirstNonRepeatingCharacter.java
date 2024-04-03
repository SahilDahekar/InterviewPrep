package Strings;

public class FirstNonRepeatingCharacter {
    public static char firstNonRepeatingCharacter(String s){
        for(char ch : s.toCharArray()){
            if(s.indexOf(ch) == s.lastIndexOf(ch)){
                return ch;
            }
        }
        return '\0';
    }
    
    // OR

    // public static char firstNonRepeatingCharacter(String s){
    //     for(char ch : s.toCharArray()){
    //         if(s.indexOf(ch, s.indexOf(ch) + 1) == -1){
    //             return ch;
    //         }
    //     }
    //     return '\0';
    // }

    public static void main(String[] args) {
        String input = "geeksforgeeks";
        System.out.println(firstNonRepeatingCharacter(input));
    }
}
