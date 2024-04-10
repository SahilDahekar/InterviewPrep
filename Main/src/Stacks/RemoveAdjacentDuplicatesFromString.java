package Stacks;

import java.util.Stack;

public class RemoveAdjacentDuplicatesFromString {
    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            } else {
                st.push(ch);
            }
        }       

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0, st.pop());
        }

        return res.toString();
    }
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }
}
