package Stacks;

public class RemoveOuterParenthesis {
    public static String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(count > 0){
                    res.append(ch);
                }
                count++;
            } else {
                count--;
                if(count > 0){
                    res.append(ch);
                }
            }
        }

        return res.toString();
    }

    // public static String removeOuterParentheses(String s){
    //     Stack<Character> st = new Stack<>();
    //     StringBuilder res = new StringBuilder();
    //     for(int i = 0; i < s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(ch == '('){
    //             if(st.size() > 0){
    //                 res.append(ch);
    //             }
    //             st.push(ch);
    //         } else {
    //             st.pop();
    //             if(st.size() > 0){
    //                 res.append(ch);
    //             }
    //         }
    //     }

    //     return res.toString();
    // }

    public static void main(String[] args) {
        String str = "(()())(())((()))";
        System.out.println(removeOuterParentheses(str));
    }
}
