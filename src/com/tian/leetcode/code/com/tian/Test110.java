package com.tian.leetcode.code.com.tian;


import com.tian.leetcode.code.com.tian.util.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * [1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
 */
public class Test110 {


    public static void main(String[] args){
        TreeNode node1=new TreeNode(4, null, null);
        TreeNode node2=new TreeNode(4, null, null);
        TreeNode node3=new TreeNode(3, node1, node2);

        TreeNode node4=new TreeNode(3, null, null);
        TreeNode node5=new TreeNode(2, node3, node4);

        TreeNode node6=new TreeNode(2, null, null);
        TreeNode node7=new TreeNode(1, node5, node6);

        Test110 t = new Test110();
        boolean b = t.isBalanced(node7);
        System.out.println(b);

    }

    public boolean isBalanced(TreeNode root) {
        int deep = 0;
        int min =  min(root,deep);
        deep = 0;
        int max =  max(root,deep);
        if(max - min > 1){
            return false;
        }
        return true;
    }

    public int min (TreeNode root,int deep){
        if(root==null){
            return deep;
        }else{
            deep++;
            return Math.min(min(root.left,deep),min(root.right,deep));
        }
    }
    public int max (TreeNode root,int deep){
        if(root==null){
            return deep;
        }else{
            deep++;
            return Math.max(max(root.left,deep),max(root.right,deep));
        }
    }
}
