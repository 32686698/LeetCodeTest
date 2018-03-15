package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

public class Test111 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(4, node1, null);

        TreeNode node4 = new TreeNode(3, node2, null);
        TreeNode node5 = new TreeNode(2, node4, null);

        TreeNode node7 = new TreeNode(1, node5, null);

        Test111 t = new Test111();
        int b = t.minDepth(node7);
        System.out.println(b);

    }

    /**
     * 我的实现
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return min(root, 1);
    }
    public int min(TreeNode treeNode, int deep) {
        if (treeNode.left == null && treeNode.right == null) {
            return deep;
        } else if(treeNode.left==null){
            deep++;
            return min(treeNode.right, deep);
        }else if(treeNode.right==null){
            deep++;
            return min(treeNode.left, deep);
        }else{
            deep++;
            return Math.min(min(treeNode.right, deep), min(treeNode.left, deep));
        }
    }


    /**
     * 牛逼的实现，还没看明白
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return (left==0||right==0)? left+right+1:Math.min(left,right)+1;
    }
}
