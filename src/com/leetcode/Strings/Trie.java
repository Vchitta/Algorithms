package com.leetcode.Strings;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vidyachitta on 6/3/17.
 */
public class Trie {
    public class node{
        Map<Character,node> children;
        boolean last;
        node() {
            children = new HashMap<>();
            last = false;
        }
        }
        public node root;
        Trie(){
            root= new node();
        }


    public void insert(String word){
        node current = root;
        int len = word.length();
        for(int i =0; i<len;i++) {
            char ch =word.charAt(i);
            if (current.children.isEmpty()){
                current.children.put(ch,new node());
            }
            else {
                if (!current.children.containsKey(ch)){
                    current.children.put(ch,new node() );
                }
            }
            current = current.children.get(ch);
            if (i== len-1)
                current.last=true;
        }

    }

    public void search(String word){

    }

    @Override
    public String toString() {
        node current =root;
        while (!current.children.isEmpty()){
            for(char ch:current.children.keySet()){
                System.out.println();
            }
        }
        return "";

    }

    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.insert("abc");
        dict.insert("abcd");

    }

}
