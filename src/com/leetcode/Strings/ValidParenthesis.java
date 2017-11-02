package com.leetcode.Strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by vidyachitta on 5/26/17.
 */
class Stack{
    Deque<Character> stack = new ArrayDeque<Character>();
    int top;
    Stack(){
        top = -1;
    }
    void push(char ch){
       stack.addFirst(ch);
        top=top+1;
       //return add;
    }
    char pop(){
        char ch = stack.removeFirst();
        top=top-1;
        return ch;
    }
    char peek(){
        return stack.peekFirst();
    }
}
public class ValidParenthesis {
    static boolean checkParanthesis(String str) {
        char top;
        Stack st = new Stack();
        char[] letters = str.toCharArray();
        for (int i =0; i <letters.length;i++ ) {
            char ch = letters[i];
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
                //System.out.println("push:"+ch +" "+st.top +"pook:"+st.peek());
            }
            if( st.top>-1 && ((ch == '}' && st.peek()=='{' )||(ch == ']' && st.peek()=='[' )|| (ch == ')' && st.peek()=='(' )  )){
                top = st.pop();
                //System.out.println("pop:"+ch +" "+st.top);
            }
            else if (ch == '}' || ch == ')' || ch == ']'){
                return false;
            }

        }

        if (st.top == -1) {
            return true;
        }

        return false;
    }




    public static void main(String[] args) {
        System.out.println(checkParanthesis(")"));
    }
}
