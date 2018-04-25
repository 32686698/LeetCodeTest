package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 t = new Test2();
        ListNode res = t.addTwoNumbers(ListNode.getIns(9),ListNode.getIns(1,9,9,9,9,9,9,9,9,9,9));
        System.out.println(res);
    }


    /**
     * 我的实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        int int1 = 0,int2 = 0;
        ListNode res = new ListNode(0);
        ListNode cuRes = res;
        while (null!=l1){
            int1 = l1.val;
            if(null!=l2){
                int2 = l2.val;
            }else{
                int2 = 0;
            }
            count = count + int1+int2;

            cuRes.val = count%10;
            count = count/10;
            if(l1.next!=null) {
                cuRes.next = new ListNode(0);
                cuRes = cuRes.next;
            }

            l1 = l1.next;
            if(null!=l2) {
                l2 = l2.next;
            }
        }
        if(null!=l2){
            cuRes.next = new ListNode(0);
            cuRes = cuRes.next;
        }
        while (null!=l2){
            int2 = l2.val;
            count = count + int2;

            cuRes.val = count%10;
            count = count/10;
            if(l2.next!=null) {
                cuRes.next = new ListNode(0);
                cuRes = cuRes.next;
            }

            l2 = l2.next;
        }
        if(count!=0){
            if(cuRes.next==null){
                cuRes.next = new ListNode(0);
                cuRes = cuRes.next;
            }
            cuRes.val = count%10;
        }
        return res;
    }
}
