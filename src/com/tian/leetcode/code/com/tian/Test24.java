package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 */
public class Test24 {

    public static void main(String[] args) {
        Test24 t = new Test24();
        ListNode l = t.swapPairs(ListNode.getIns(1));
        System.out.println(l);
    }

    /**
     * 我的实现
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        int len = 0;
        ListNode cu = head;
        while (null!=cu){
            len++;
            cu = cu.next;
        }
        int[] nums = new int[len];
        cu = head;
        int i = 0;
        while (null!=cu){
            nums[i++] = cu.val;
            cu = cu.next;
        }
        int temp = 0;
        for (int j = 0;j < len;j ++){
            if(j%2==1){
                temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
            }
        }
        cu = head;
        i = 0;
        while (null!=cu){
            cu.val = nums[i++];
            cu = cu.next;
        }

        return head;
    }
}
