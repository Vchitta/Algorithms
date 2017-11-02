package com.leetcode.Trees;

import java.util.*;

/**
 * Created by vidyachitta on 6/25/17.
 */
class Node{
    int value;
    Node left;
    Node right;

    Node(){
        this.value=0;
        this.left=null;
        this.right=null;
    }

    Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
    Node(int value,Node left,Node right){
        this.value=value;
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return this.value+"";
    }
}
public class Tree {
    Node root;
    Tree(){
        root=null;
    }
    Tree(int value){
        root=new Node(value);
    }

    void insert(int value){

        Node node=new Node(value);

        if (root==null){
            root=node;
            return;
        }

        Node parent= root;

        while (true){
            if(parent.value < value){
                //System.out.println(parent.value+ " " +value);
                if (parent.right == null) {
                    parent.right = node;
                    return;
                }
                else
                    parent=parent.right;
            }
            else if(parent.value>=value)
                if (parent.left == null) {
                    parent.left = node;
                    return;
                }
                else
                    parent=parent.left;
        }

    }
    void insert(Node root,int value){
        Node node=new Node(value);
        if(root==null) {
            root=node;
            return;
        }
        if(root.value<value)
            insert(root.left,value);
        else insert(root.right,value);

    }
    boolean search(Node root,int value){
        if (root==null) return false;
        if( root.value==value)
            return true;

        if (root.value<value)
            return search(root.right,value);
        else return search(root.left,value);
    }
    boolean searchIterative(int value){
        if (root==null) return false;
        Stack<Node> stack=new Stack<>();
        Node curr=root;
        stack.push(curr);

        while (!stack.isEmpty()){
            Node node=stack.pop();
            if(node.value==value)
                return true;
            if (node.left!=null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);

        }

        return false;
    }
    void printLevel(int level,Node root){
        if (root==null)return;
        if (level==1)
            System.out.print(root.value);
        else {
            printLevel(level-1,root.left);
            printLevel(level-1,root.right);
        }

    }
    void printLevelOrder(){
        int depth=findDepth(root);
        for (int i=1;i<=depth;i++){
            printLevel(i,root);
            System.out.println();
        }
    }
    int findDepth(Node root){

        if (root==null)
            return -1;
        return Math.max(findDepth(root.left)+1, findDepth(root.right)+1);
    }
    boolean isLeaf(Node node){
        if (node.right==null && node.left==null)
            return true;
        return false;
    }
    void inOrderTraversal(Node root){
        if (root==null)return;

        inOrderTraversal(root.left);
        System.out.print(root);
        inOrderTraversal(root.right);

    }
    void inOrderIterative(){

        if (root==null)return;
        Stack<Node> stack=new Stack();
        Node current = root;
        while (stack.size()>0||current!=null){
            if (current!=null){
                stack.push(current);
                current=current.left;
            }else {
                Node node=stack.pop();
                System.out.print(node);
                current=node.right;
            }
        }
    }
    void preOrderTraversal(Node root){
        if (root==null) return;

        System.out.print(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    void postOrderTraversal(Node root){
        if (root==null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root);
    }
    void preOrderiterative(){
        if (root==null)return;

        Stack<Node> stack=new Stack();
        Node node;
        stack.push(root);
        while (stack.size()>0){
            node=stack.pop();
            System.out.print(node);
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }

    }
    void postOrderIterative2(){
        if (root==null)return;

        Stack<Node> stack=new Stack();
        Stack<Node> stackrev=new Stack();

        Node node;
        stack.push(root);
        while (stack.size()>0){
            node=stack.pop();
            stackrev.push(node);
            //System.out.print(node);
            if (node.left!=null)
                stack.push(node.left);
            if (node.right!=null)
                stack.push(node.right);
        }
        while (stackrev.size()>0)
            System.out.print(stackrev.pop());

    }
    void postOrderIterative1(){
        if (root==null) return;
        Stack<Node> stack=new Stack<>();
        List<Node> list=new ArrayList<>();
        Node current=root;
        if (current.right != null)
            stack.push(current.right);
        stack.push(current);
        current=current.left;



        while (stack.size()>0){
            while (current!=null){
                if (current.right != null)
                    stack.push(current.right);
                stack.push(current);
                current=current.left;
            }

            current=stack.pop();
            if (stack.size()>0 && current.right!=null && current.right==stack.peek()){
                Node node=stack.pop();
                stack.push(current);
                current=node;
            }
            else {
                list.add(current);
                current=null;
            }
        }
    }
    void levelOrderTraversal(){
        if (root== null) return;
        Queue<Node> queue = new LinkedList<>();
        Node current= root;
        int width=0;
        queue.offer(current);
        while (!queue.isEmpty()){
            width=queue.size();
            while (width>0){
                current=queue.poll();
                System.out.print(current);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right!= null)
                    queue.offer(current.right);
                width--;
            }
            System.out.println();

        }




    }
    int diameterOfBinaryTree(Node root) {
        if(root == null) return 0;
        int left= diameterOfBinaryTree(root.left);
        int right= diameterOfBinaryTree(root.right);

        return Math.max(Math.max(left,right),findDepth(root.left)+findDepth(root.right)+2);

    }

    boolean isBalanced(Node root){

        if (root==null) return true;
        if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(findDepth(root.left)-findDepth(root.right))<=1  )
            return true;
        return false;
    }

    int maxPathSum(Node root){


        return 0;
    }

    public static void main(String[] args) {

        //             5
        //        2          8
        //     1     3     7    9
        //   0                     11

        Tree tree=new Tree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        tree.insert(0);
        tree.insert(11);
        System.out.println(tree.isBalanced(tree.root));
        System.out.println(tree.findDepth(tree.root));
//        Tree tree1=new Tree();
//        tree1.insert(1);
        //tree.printTree(tree.root);
        //tree.printLevelOrder();
//        tree.postOrderTraversal(tree.root);
//        System.out.println();
//        tree.postOrderIterative2();
//        System.out.println();
//        tree.inOrderIterative();
//        System.out.println();
//
//        tree.levelOrderTraversal();
//        System.out.println();
//        tree.printLevelOrder();

        //System.out.println(tree.searchIterative(11));
        //tree.postOrderTraversal(tree.root);
    }



}
