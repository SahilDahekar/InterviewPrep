package Stacks;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] directories = path.split("/");

        // System.out.println(Arrays.toString(directories));

        for(String dir : directories){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            } else if (dir.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            } else {
                st.push(dir);
            }
        }

        return "/" + String.join("/", st);
    }
    public static void main(String[] args){
        String str = "/home/";
        // String str = "/../";
        // String str = "/home//foo";
        System.out.println(simplifyPath(str));
    }
}
