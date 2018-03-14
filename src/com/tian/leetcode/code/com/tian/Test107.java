package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 */
public class Test107 {

    public static void main(String[] args){
        TreeNode node1=new TreeNode(3, null, null);
        TreeNode node2=new TreeNode(4, null, null);
        TreeNode node3=new TreeNode(2, node1, node2);

        TreeNode node4=new TreeNode(4, null, null);
        TreeNode node5=new TreeNode(3, null, null);
        TreeNode node6=new TreeNode(2, node4, node5);

        TreeNode node7=new TreeNode(1, node3, node6);

        Test107 t = new Test107();
        List<List<Integer>> b = t.levelOrderBottom(node7);
        for(List<Integer> list : b){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    /**
     * 我的实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<TreeNode> ceng = new ArrayList<>();
        ceng.add(root);
        while (true){
            List<TreeNode> tns = new ArrayList<>();
            List<Integer> ins = new ArrayList<>();
            for(TreeNode tn : ceng){
                if(tn==null){
                    continue;
                }
                ins.add(tn.val);
                tns.add(tn.left);
                tns.add(tn.right);
            }
            //完了
            if(ins.size()==0){
                break;
            }else{
                list.add(ins);
                ceng = tns;
            }
        }
        Collections.reverse(list);
        return list;
    }


    /**
     * 牛逼的实现 不太能理解
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) return out;

        traverse(out, root, 0);

        Collections.reverse(out);

        return out;
    }

    public void traverse(List<List<Integer>> out, TreeNode root, int depth) {

        if ( root == null) return;

        // The slow will increase gradualy one by one -> add a new list when reaching a new depth
        if ( depth == out.size() ) out.add(new ArrayList<Integer>());

        traverse(out, root.left, depth+1);


        out.get(depth).add(root.val);


        traverse(out, root.right, depth+1);
    }

}
