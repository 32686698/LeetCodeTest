package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class Test100 {

    public static void main(String[] args){
        TreeNode nodeD=new TreeNode(1, null, null);
        TreeNode nodeC=new TreeNode(2, nodeD, null);
        TreeNode nodeB=new TreeNode(3, null, nodeC);

        TreeNode nodeH=new TreeNode(4, null, null);
        TreeNode nodeK=new TreeNode(5, null, null);
        TreeNode nodeG=new TreeNode(6, nodeH, nodeK);
        TreeNode nodeF=new TreeNode(7, nodeG, null);
        TreeNode nodeE=new TreeNode(8, null, nodeF);

        TreeNode nodeA=new TreeNode(9, nodeB, nodeE);
        TreeNode nodeAA=new TreeNode(9, nodeB, nodeE);
        Test100 t = new Test100();
        boolean b = t.isSameTree(null,null);
        System.out.println(b);
    }

    /**
     * 我的实现 ，参考了树的遍历代码
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> listp = new ArrayList<>();
        List<Integer> listq = new ArrayList<>();
        bianli(p,listp);
        bianli(q,listq);
        if(listp.size() != listq.size()){
            return false;
        }
        for(int i = 0 ; i < listp.size() ; i ++ ){
            Integer strp = listp.get(i);
            Integer strq = listq.get(i);
            if(strp==null&&strq==null){
                continue;
            }else if(strp==null&&strq!=null){
                return false;
            }else if(strp!=null&&strq==null){
                return false;
            }else if(!strp.equals(strq)){
                return false;
            }
        }
        return true;
    }

    public static void bianli(TreeNode treeNode,List<Integer> list){
        if(treeNode==null){
            list.add(null);
            return;
        }
        list.add(treeNode.val);
        if(treeNode.left!=null)
        {
            bianli(treeNode.left,list);
        }else{
            list.add(null);
        }
        if(treeNode.right!=null)
        {
            bianli(treeNode.right,list);
        }else{
            list.add(null);
        }
    }


    /**
     * 牛逼的实现
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        if (p.val==q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else{
            return false;
        }
    }

    /**
     * 二叉树的三种遍历
     * @param treeNode
     */
    public static void bianli(TreeNode treeNode){
//        System.out.print(treeNode.val+" ");//先序遍历
        if(treeNode.left!=null)
        {
            bianli(treeNode.left);
        }
//        System.out.print(treeNode.val+" ");//中序遍历
        if(treeNode.right!=null)
        {
            bianli(treeNode.right);
        }
        System.out.print(treeNode.val+" ");//后序遍历
    }
}
