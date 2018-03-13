package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class Test101 {

    public static void main(String[] args){
        TreeNode node1=new TreeNode(3, null, null);
        TreeNode node2=new TreeNode(4, null, null);
        TreeNode node3=new TreeNode(2, node1, node2);

        TreeNode node4=new TreeNode(4, null, null);
        TreeNode node5=new TreeNode(3, null, null);
        TreeNode node6=new TreeNode(2, node4, node5);

        TreeNode node7=new TreeNode(1, node3, node6);

        Test101 t = new Test101();
        boolean b = t.isSymmetric(node3);
        System.out.println(b);

    }


    /**
     * 我的实现 层序遍历
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        TreeNode cn = root;
        List<TreeNode> ceng = new ArrayList<>();
        ceng.add(cn);
        while (true){
            List<TreeNode> list = new ArrayList<>();
            boolean isOver = true;
            for(TreeNode tn : ceng){
                if(tn==null){
                    list.add(null);
                    list.add(null);
                }else {
                    list.add(tn.left);
                    list.add(tn.right);
                    isOver = false;
                }
            }
            if(isOver){
                return true;
            }
            for(int i = 0 ; i < list.size()/2;i++){
                if(list.get(i)==null&&list.get(list.size()-1-i)==null){
                    continue;
                }else if(list.get(i)==null||list.get(list.size()-1-i)==null){
                    return false;
                }else if(list.get(i).val != list.get(list.size()-1-i).val){
                    return false;
                }
            }
            ceng = list;
        }
    }


    /**
     * 牛逼的实现
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return func(root.left, root.right);
    }
    public boolean func(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }else if(t1 != null && t2 != null && t1.val == t2.val) {
            return func(t1.left, t2.right) && func(t1.right, t2.left);
        }else {
            return false;
        }
    }


}
