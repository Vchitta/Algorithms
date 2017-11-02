package com.leetcode.Strings;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by vidyachitta on 6/4/17.
 */


public class PostfixEvaluaion {
     static int PFEvaluaton(String comptation){

         /*
         This is imagining that operands are single digited
          */
         int len=comptation.length(),res=0;
         Stack<Integer> st =new Stack<Integer>();

         for (int i=0;i<len;i++){
             char ch = comptation.charAt(i);
             if (Character.isDigit(ch)){

                st.push(Character.getNumericValue(ch));
             }
             else{try{

                 int a =st.pop();
                 int b = st.pop();
                 switch (ch) {
                     case '+':
                         res = a + b;
                         break;
                     case '-':
                         res = a - b;
                         break;
                     case '*':
                         res = a * b;
                         break;
                     case '/':
                         try{
                             res = a / b;
                         }catch (ArithmeticException e){
                             return 101;
                         }

                 }
                 }catch(EmptyStackException e){
                 return 100;
             }

                 st.push(res);
             }
         }
         return st.pop();
     }
    static int evalRPN (String[] tokens){
         /*
         considering the operands and operators as tokens and not single digited.
          */
        int len=tokens.length,res=0;
        Stack<Integer> st =new Stack<Integer>();
         try {
             for(String oper:tokens){
                 try{ int a=Integer.parseInt(oper)  ;
                     st.push(a);
                 }catch (NumberFormatException e){


                     int b =st.pop();
                     int a = st.pop();
                     switch (oper) {
                         case "+":
                             res = a + b;
                             break;
                         case "-":
                             res = a - b;
                             break;
                         case "*":
                             res = a * b;
                             break;
                         case "/":{
                             try{
                                 res = a / b;
                             }catch (ArithmeticException exc){
                                 return 101;
                             }}

                     }
                     st.push(res);

                 }
             }



         return st.pop();
         }catch (EmptyStackException ex){
             return 100;}
    }

    public static void main(String[] args) {
        String[] tokens = {"4","3","-"};
        System.out.println(evalRPN(tokens));
    }
}
