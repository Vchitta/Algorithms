package com.leetcode.Trees;

import java.util.List;

/**
 * Created by vidyachitta on 6/28/17.
 */

public class formingTree extends Tree{
    Node sortedListBST( List<Integer> list){
            if (list.isEmpty())
                return null;

            int mid = (list.size() - 1) / 2;
            Node root = new Node(list.get(mid));
            
                root.left = sortedListBST(list.subList(0, mid));

                root.right = sortedListBST(list.subList(mid + 1, list.size()));


            return root;

    }

    }