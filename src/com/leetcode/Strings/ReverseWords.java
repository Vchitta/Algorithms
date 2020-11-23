package com.leetcode.Strings;

import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		//System.out.println(new ReverseWords().reverseWords("a good   example"));
		
		//char[] arr = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		System.out.println(new ReverseWords().reverseWord("hello"));
		//System.out.println("main: "+Arrays.toString(arr));
	}
	
	 public String reverseWord(String s) {
		   char[] letters= s.toCharArray();

		 int first =0, end=letters.length-1;
		 while(first < end){
			 char temp =letters[first];
			 letters[first++]=letters[end];
			 letters[end--]=temp;
		 }
		 return new String(letters);
	 }
	   public String reverseEachWord(String s) {
		   
		   char[] letters= s.toCharArray();
		   for(int i=0;i< letters.length;i++){
			   if(letters[i]==' '|| i==letters.length-1){
				   int first =i+1, end= i==letters.length-1? i:i-1;
					 while(first < end){
						 char temp =letters[first];
						 letters[first++]=letters[end];
						 letters[end--]=temp;
					 }
			   }
		   }
		   
		   return new String(letters);
	        
	    }

	/*
	 * without using split function
	 */
	public String reverseWords(String s) {

		StringBuilder res = new StringBuilder();
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			String letter = s.substring(i, i + 1);
			if (letter.equals(" ")) {

				// if(word.toString().trim().length()>0)
				res.insert(0, word + " ");

				word = new StringBuilder();
				while (s.substring(i, i + 1).equals(" "))
					i++;
				i--;
			} else {

				word.append(letter);

			}

		}
		if (word.length() != 0)
			res.insert(0, word + " ");
		return res.toString();

	}
	
	public void reverseWords(char[] s) {
		
		char[] res = new char[s.length];
		for(int i =0;i< s.length;i++){
			res[i]=s[i];
		}
		int end= s.length;
		for(int i =s.length-1, j=0;i>=0;i--){
			
			if(res[i]==' '||i==0) 
			{
				int k=i==0?i:i+1;
				for(;k<end;k++){
					s[j++] = res[k];
				}
				if(i!=0)
					s[j++]=res[i];
				end =i;
			}
			
		}
		
		System.out.println(Arrays.toString(s));

	}
	
}
