package com.Interviews.Google;

import java.util.Arrays;
import java.util.Stack;

public class Audible {


	static String[] prefixToPostfix(String[] prefixes) {
		String[] postfixes = new String[prefixes.length];
		Stack<String> stack = new Stack<String>();
		for(int stringNum=0; stringNum<prefixes.length; stringNum++){
			String prefix = prefixes[stringNum];
			String operandOne, operandTwo;

			int len = prefix.length();
			for (int pos = len - 1; pos >= 0; pos--){
				if (Character.isDigit(prefix.charAt(pos))){
					stack.push(String.valueOf(prefix.charAt(pos)));
				}else{
					operandOne = stack.pop();
					operandTwo = stack.pop();
					operandTwo += prefix.charAt(pos);
					stack.push(operandOne + operandTwo);
				}
			}

			postfixes[stringNum] = stack.pop();
			if(!stack.isEmpty()){
				System.out.println("not a valid prefix string: "+prefixes[stringNum]);
				 stack =new Stack<String>(); // get a new stack for the next prefix string
			}
		}
		return postfixes;


		/*String[] postfixes = new String[prefixes.length];
		Stack<String> stack =new Stack<String>();

		for(int stringNum=0; stringNum<prefixes.length; stringNum++){
			String prefix = prefixes[stringNum];
			int stringLen = prefix.length();

			for (int pos = stringLen - 1; pos >= 0; pos--){
				if (Character.isDigit(prefix.charAt(pos)))
					stack.push(prefix.charAt(pos)+"");
				else
			//	 first pop gives operandOne and then second stack pop gives operandTwo

					stack.push(stack.pop() + stack.pop() + prefix.charAt(pos)+"");
			}

			 all the characters in one string are parsed and now the 
		 * last stack push will have a postfix of expression
		 * saving in the array of postfixes 

			postfixes[stringNum] = stack.pop();
			if(!stack.isEmpty()){
				System.out.println("not a valid prefix string: "+prefixes[stringNum]);
				 stack =new Stack<String>(); // get a new stack for the next prefix string
			}

		}
		return postfixes;
		 */
	}



	public static void main(String[] args)  {
		String[] strs ={"+12","++123","*34","+1*23"};
		System.out.println(Arrays.toString(prefixToPostfix(strs)));
	}
}
