package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class Test83 {

    public static void main(String[] args) {
        Test83 t = new Test83();
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(1);
//        ln.next.next.next = new ListNode(3);
//        ln.next.next.next.next = new ListNode(3);
        ListNode tt = t.deleteDuplicates(ln);
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode ln = head;
        while(ln != null){
            //相等，需要删除
            if(ln.next!=null&&ln.val == ln.next.val){
                ln.next = ln.next.next;
            }else{
                ln = ln.next;
            }
        }
        return head;
    }
}
