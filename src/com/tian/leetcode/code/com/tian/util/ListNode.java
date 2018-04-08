package com.tian.leetcode.code.com.tian.util;

public class ListNode {

    public int val;
    public ListNode next;

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
