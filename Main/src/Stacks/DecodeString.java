package Stacks;

import java.util.Stack;

public class DecodeString{
    public static String decode(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ']'){
                st.push(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '['){
                    sb.insert(0, st.pop());
                }

                st.pop();

                String sub = sb.toString();
                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0, st.pop());
                }

                int len = Integer.valueOf(sb.toString());

                for(int j = 0; j < len; j++){
                    for(char c : sub.toCharArray()){
                        st.push(c);
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();    
        while(!st.isEmpty()){
            res.insert(0, st.pop());
        }

        return res.toString();
    }   

    public static void main(String[] args) {
        // String str = "3[a]2[bc]";
        String str = "3[a2[cc]]";
        System.out.println(decode(str));
    }
}