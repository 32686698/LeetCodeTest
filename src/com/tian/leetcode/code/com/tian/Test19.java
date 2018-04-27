package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Test19 {

    public static void main(String[] args) {
        Test19 t = new Test19();
        ListNode a = t.removeNthFromEnd1(ListNode.getIns(1,2),2);
        System.out.println(a);
        a = t.removeNthFromEnd1(ListNode.getIns(1,2,3,4,5),2);
        System.out.println(a);
    }

    /**
     * 我的实现 1，两次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int len = 0;
        while (null!=current){
            len ++;
            current = current.next;
        }
        current = head;
        for (int i = 1;i < len-n ; i ++ ){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    /**
     * 我的实现2，1次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head.next==null)return null;
        ListNode current = head;
        ListNode last = null;
        int len = 0;
        while (null!=current){
            if(len == n){
                last = head;
            }else if(len>n){
                last = last.next;
            }
            len ++;
            current = current.next;
        }
        if(null==last){
            head = head.next;
        }else {
            last.next = last.next.next;
        }
        return head;
    }

}
