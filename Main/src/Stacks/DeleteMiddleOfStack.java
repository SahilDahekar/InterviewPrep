package Stacks;

import java.util.Stack;

public class DeleteMiddleOfStack {
    
    public static void deleteMid(Stack<Integer>s,int size){
        int count = 0;
        solve(s, size, count);
    } 
    
    public static void solve(Stack<Integer> s,int size, int count){
        if(count == size/2){
            s.pop();
            return;
        }
        
        int num = s.pop();
        
        solve(s, size, ++count);
        
        s.push(num);
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        deleteMid(s, 5);
        System.out.println(s);
    }
}
