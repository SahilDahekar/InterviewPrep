package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && match(st.peek(), ch)){
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.isEmpty();
    }

    public static boolean match(char ch1, char ch2){
        return (
            (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}')
        );
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        // String str = "(]";
        System.out.println(isValid(str));
    }
}
