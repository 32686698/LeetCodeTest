package com.tian.leetcode.code.com.tian.util;

public class ListNode {

    public int val;
    public ListNode next;


    public static ListNode getIns(int... xx){
        ListNode ln = new ListNode();
        ListNode cu = ln;
        ListNode cuu = ln;
        int leng = xx.length;
        for(int i = 0 ; i < leng ; i ++){
            cu.val = xx[i];
            if(i!=leng-1) {
                cu.next = new ListNode();
                cu = cu.next;
            }
        }
        return ln;
    }

    public ListNode() {
    }
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x,ListNode next){
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return val+"->"+next;
    }
}
