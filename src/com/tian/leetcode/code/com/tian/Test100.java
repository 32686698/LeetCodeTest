package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.Stack;

public class Test100 {

    public static void main(String[] args){

    }

    public void bianli(TreeNode treeNode){
        TreeNode parentTn = treeNode;
        TreeNode tn = treeNode.left;
        Stack<TreeNode> tnStack = new Stack<>();
        tnStack.push(parentTn);
        tn = treeNode.left;
        while (!tnStack.isEmpty()){
            if(tn!=null){
                tnStack.push(tn);
                tn = tn.left;
            }
            //切换到右边
            if(tn==null){

            }
        }

    }
}
