package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class Test104 {

    public static void main(String[] args){
        TreeNode node1=new TreeNode(3, null, null);
        TreeNode node2=new TreeNode(4, null, null);
        TreeNode node3=new TreeNode(2, node1, node2);

        TreeNode node4=new TreeNode(4, null, null);
        TreeNode node5=new TreeNode(3, null, null);
        TreeNode node6=new TreeNode(2, node4, node5);

        TreeNode node7=new TreeNode(1, node3, node6);

        Test104 t = new Test104();
        int b = t.maxDepth(node3);
        System.out.println(b);
    }

    /**
     * 我的实现
     * @param root
     */
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int deep = 1;
        List<TreeNode> ceng = new ArrayList<>();
        ceng.add(root);
        while (true){
            List<TreeNode> list = new ArrayList<>();
            for(TreeNode tn : ceng){
                if(null!=tn){
                    if(tn.right!=null){
                        list.add(tn.right);
                    }
                    if(tn.left != null){
                        list.add(tn.left);
                    }
                }
            }
            if(list.size()>0){
                deep ++;
                ceng = list;
            }else{
                return deep;
            }
        }
    }


    /**
     * 牛逼的实现
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {

        if (root == null) return 0;

        int lHeight = maxDepth2(root.left);
        int rHeight = maxDepth2(root.right);

        return Math.max(lHeight, rHeight)+1;

    }
}
