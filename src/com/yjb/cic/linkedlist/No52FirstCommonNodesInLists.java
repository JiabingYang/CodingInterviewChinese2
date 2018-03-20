package com.yjb.cic.linkedlist;

public class No52FirstCommonNodesInLists {

    private static Node findFirstCommonNode1(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int len1 = 1;
        Node p1 = head1;
        while (p1.next != null) {
            len1++;
            p1 = p1.next;
        }

        int len2 = 1;
        Node p2 = head1;
        while (p2.next != null) {
            len2++;
            p2 = p2.next;
        }

        if (p1 != p2) {
            return null; //不相交
        }

        Node pFront;
        Node pBack;
        int lenDiff;

        //确定head1和head2哪个比较长，pBack指向短的链表表头
        if (len1 < len2) {
            pFront = head2;
            pBack = head1;
            lenDiff = len2 - len1;
        } else {
            pFront = head1;
            pBack = head2;
            lenDiff = len1 - len2;
        }

        //让pFront指向lenLong-lenShort的位置
        for (int i = 0; i < lenDiff; i++) {
            pFront = pFront.next;
        }

        //两个指针同时向链表尾部移动，直到找到交点。
        while (pFront != pBack) {
            pFront = pFront.next;
            pBack = pBack.next;
        }

        return pFront;
    }

    /**
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     * <p>
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
     * <p>
     * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
     * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
     * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
     */
    private static Node findFirstCommonNode2(Node head1, Node head2) {
        Node p1 = head1, p2 = head2;
        while (p1 != p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }
        return p1;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
