package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class Test108 {

    public static void main(String[] args){
        int[] nums = new int[]{-10,-3,0,5,9};
        Test108 t = new Test108();
        TreeNode tn = t.sortedArrayToBST(nums);
        System.out.println(tn);
    }


    /**
     * 我的实现
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        int rootIndex = nums.length/2;
        TreeNode treeNode = new TreeNode(nums[rootIndex]);
        List<Integer> numList = new ArrayList<>();
        for(int num : nums){
            numList.add(num);
        }
        TreeNode head = treeNode;
        bulid(numList.subList(0,numList.size()/2),numList.subList(numList.size()/2+1,numList.size()),head);
        return treeNode;
    }

    public static void bulid(List<Integer> numListLeft,List<Integer> numListRight,TreeNode treeNode){
        int leftSize = numListLeft.size();
        int rightSize = numListRight.size();
        if(leftSize==1){
            treeNode.left = new TreeNode(numListLeft.get(0));
        }else if(leftSize>1){
            treeNode.left = new TreeNode(numListLeft.get(leftSize/2));
            bulid(numListLeft.subList(0,leftSize/2),numListLeft.subList(leftSize/2+1,leftSize), treeNode.left);
        }
        if(rightSize==1){
            treeNode.right = new TreeNode(numListRight.get(0));
        }else if(rightSize>1){
            treeNode.right = new TreeNode(numListRight.get(rightSize/2));
            bulid(numListRight.subList(0,rightSize/2),numListRight.subList(rightSize/2+1,rightSize), treeNode.right);
        }
    }


    /**
     * 牛逼的实现
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return buildHelper(nums, 0, nums.length - 1);
    }

    private TreeNode buildHelper(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildHelper(nums, left, mid - 1);
        node.right = buildHelper(nums, mid + 1, right);
        return node;
    }
}
