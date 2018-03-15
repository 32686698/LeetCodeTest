package com.tian.leetcode.code.com.tian;


import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 我的实现
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(null==root){
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        bianli(root,list);

        for(TreeNode tn : list){
            TreeNode left = tn.left;
            TreeNode right = tn.right;
            int leftDeep = 0;
            int rightDeep = 0;
            if(left!=null){
                leftDeep = max(left,0);
            }
            if(right!=null){
                rightDeep = max(right,0);
            }
            if(Math.abs(leftDeep-rightDeep)>1){
                return false;
            }
        }
        return true;
    }
    public int max (TreeNode root,int deep){
        if(root==null){
            return deep;
        }else{
            deep++;
            return Math.max(max(root.left,deep),max(root.right,deep));
        }
    }
    public void bianli(TreeNode root,List<TreeNode> list){
        list.add(root);
        if(root.left!=null){
            bianli(root.left,list);
        }if(root.right!=null){
            bianli(root.right,list);
        }
    }




    private boolean result = true;

    /**
     * 牛逼的实现
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1){
            result = false;
        }
        return 1 + Math.max(l, r);
    }
}
