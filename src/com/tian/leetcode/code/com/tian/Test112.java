package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/description/
 */
public class Test112 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(1, null, null);

        TreeNode node4 = new TreeNode(11, node1, node2);
        TreeNode node5 = new TreeNode(13, null, null);
        TreeNode node6 = new TreeNode(4, null, node3);

        TreeNode node7 = new TreeNode(4, node4, null);
        TreeNode node8 = new TreeNode(8, node5, node6);

        TreeNode node9 = new TreeNode(5, node7, node8);


        Test112 t = new Test112();
        boolean b = t.hasPathSum(node9,18);
        System.out.println(b);

    }


    /**
     * 我的实现
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        } else if (root.left == null) {
            return hasPathSum(root.right, sum);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum);
        } else {
            return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
        }
    }
}
