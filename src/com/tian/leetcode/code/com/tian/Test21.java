package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class Test21 {

    public static void main(String[] args) {
        Test21 t = new Test21();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        ListNode tt = t.mergeTwoLists3(l1,l2);
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //l1存小的第一个数小的链表
        if(l1.val>l2.val){
            ListNode l3 = l1;
            l1 = l2;
            l2 = l3;
        }
        ListNode l3 = new ListNode(l1.val);
        ListNode l3Temp = l3;
        l1 = l1.next;
        while (l1!=null){
            if(l2==null){
                l3Temp.next = l1;
                break;
            }else {
                if (l1.val >= l2.val) {
                    l3Temp.next = l2;
                    l2 = l2.next;
                } else {
                    l3Temp.next = l1;
                    l1 = l1.next;
                }
            }
            l3Temp = l3Temp.next;
        }
        if (l2!=null){
            l3Temp.next = l2;
        }
        return l3;
    }

    /**
     * 根据样例，对我的实现的优化
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode l3Temp = l3;
        while (l1!=null&&l2!=null){
            if (l1.val >= l2.val) {
                l3Temp.next = l2;
                l2 = l2.next;
            } else {
                l3Temp.next = l1;
                l1 = l1.next;
            }
            l3Temp = l3Temp.next;
        }
        if (l1!=null){
            l3Temp.next = l1;
        }else if(l2!=null){
            l3Temp.next = l2;
        }
        return l3.next;
    }

    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val>l2.val){
            ListNode l3 = l2;
            l3.next = mergeTwoLists2(l1,l2.next);
            return l3;
        }else{
            ListNode l3 = l1;
            l3.next = mergeTwoLists2(l1.next,l2);
            return l3;
        }
    }
}
