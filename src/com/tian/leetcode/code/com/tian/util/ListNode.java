package com.tian.leetcode.code.com.tian.util;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val+"->"+next;
    }
}
