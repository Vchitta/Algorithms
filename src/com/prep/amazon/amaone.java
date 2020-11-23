package com.prep.amazon;

public class amaone {
	public class Solution
	{   
	   /* Class Trie{
	    class TrieNode{
	        static final int LETTERS_SIZE = 26;
	        TrieNode[] next;
	        boolean isEndofWord;
	        TrieNode(){
	            next = new TrieNode[LETTERS_SIZE];
	        }
	    }
	    TrieNode head;
	    
	    public Trie(){
	        head = new TrieNode();
	    }
	    
	    public void insert(String keyword){
	        TrieNode temp = head;
	        for(int i=0;i<keyword.length();i++){
	            int index = word.charAt(i)-'a';
	            if(temp.next[index]== null )
	            temp.next[index]= new TrieNode();
	            temp = temp.next[index];
	        }
	        temp.isEndofWord = true;
	    }
	      public List<String> startsWith(TreeNode node, String keyword, List<String> res){
	          if(node.isEndofWord == true){
	              res.add(keyword);
	              return res;
	          }
	          int count = 0;
	          for(int i=0;i<26;i++){
	              if(node.next[i]!=null && count<4){
	                  count++;
	                  ArrayList<String> out = startsWith(node.next[i],keyword+(char)('a'+i-1),res); 
	              }
	              
	          }
	          
	          
	      }
	    
	    public List<String> startsWith( String keyword){
	       
	       TrieNode temp = head;
	       startsWith(head, keyword, new ArrayList<>());
	       for(int i =0;i<keyword.length();i++){
	           int index = keyword.charAt(i)-'a';
	               
	       }
	    }
	    
	    
	    }
	    
	    
	    
	    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    List<List<String> > threeKeywordSuggestions(int numreviews, 
	                                                List<String> repository, 
	                                                String customerQuery)
	    {
	      List<List<String> > suggestionsList = new ArrayList<>();   
	        int queryLen = customerQuery.length();
	        if(queryLen <2) return suggestionsList;
	        if(repository.size() == 0 ) return suggestionsList;
	        Trie trie = new Trie();
	        for(String repoWord: repository)
	            trie.insert(repoWord);
	        
	        // StringBuilder sb = new StringBuilder(); 
	        
	        for(int i=2;i< queryLen;i++){
	            
	            String keyword = customerQuery.substring(0,i);
	            
	            
	            
	            
	        }  
	        
	          
	          
	    }
	    // METHOD SIGNATURE ENDS
	*/}
}
