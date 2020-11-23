package com.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vidyachitta on 7/15/17.
 */
/* Leetcode #419
Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

        You receive a valid board, made of only battleships or empty slots.
        Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
        At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.*/
public class BattleArray {
    public static int countBattleships(char[][] board) {
        int count =0;
        for (int i1=0;i1<board.length;i1++)
            for (int j1 = 0; j1<board[0].length; j1++){
                    int i=i1,j=j1;
                if (board[i][j]=='X'){
                    board[i][j]='Z';
                    if (j+1<board[0].length && board[i][j+1]=='X'){
                        while (j+1<board[0].length && board[i][j+1]=='X'){
                            board[i][j+1]='Z';
                            j++;
                        }
                    }else if (i+1<board.length && board[i+1][j]=='X'){
                        while (i+1<board.length && board[i+1][j]=='X'){
                            board[i+1][j]='Z';
                            i++;
                        }
                    }
                    count++;
                }
            }
        return count;
    }
    public static int lineBattleships(char[][] board){
        int count =0;
        for (int i=0;i<board.length;i++)
            for (int j = 0; j<board[0].length; j++){
                if (board[i][j]=='X' && !((j>0 && board[i][j-1]=='X')||(i>0 && board[i-1][j]=='X')))
                    count++;
            }
        return count;
    }
    public static int numIslands(int[][] board) {
        int count =0;
        for (int i=0;i<board.length;i++)
            for (int j = 0; j<board[0].length; j++) {
                if (board[i][j]==1){
                    dfs(i,j,board);
                    count++;
                }
            }
        return count;
            }
    static void dfs(int i, int j, int[][] board){
        if (i<0 || j<0 ||j>=board[0].length||i>=board.length||!(board[i][j] ==1) )
            return;
        board[i][j]=0;
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j-1,board);
        dfs(i,j+1,board);

    }
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] board= new int[m][n];
        List<Integer> res = new ArrayList<>();
        for (int[] item :positions){
            board=addLand(item[0],item[1],board);
            res.add(numIslands(board));
        }
        //System.out.println(Arrays.deepToString(board));

        return res;
    }
    static int[][] addLand(int i, int j,int[][] board){
        board[i][j] = 1;
        return board;
    }

    public static void main(String[] args) {

        char[][] input={"11000".toCharArray(),"11000".toCharArray(),"00100".toCharArray(),"00011".toCharArray()};
        System.out.println("[[0,0],[0,1],[1,2],[2,1]]".replace('[','{').replace(']','}'));
        int[][] ints={{0,0},{0,1},{1,2},{2,1}};
//        System.out.println(Arrays.deepToString(input));
//        System.out.println(numIslands(input));
        //System.out.println(numIslands2(3,3,ints));
        Solution sol = new Solution();
     //   System.out.println(sol(3,3,ints));
    }
}


class Solution{
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
		return null;
        
    }
}