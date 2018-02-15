package com.yjb.cic.linkedlist;

/**
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
 * 表3所示。
 */
public class No25MergeSortedLists {

    /**
     * 归并排序的思想合并
     */
    private static ListNode merge1(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 == null) {
            p.next = head2;
        }
        if (head2 == null) {
            p.next = head1;
        }
        return dummy.next;
    }

    /**
     * 递归合并
     */
    private static ListNode merge2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head;
        if (head1.value < head2.value) {
            head = head1;
            head.next = merge2(head1.next, head2);
        } else {
            head = head2;
            head.next = merge2(head1, head2.next);
        }
        return head;
    }

    /* ---------------- 依赖 -------------- */
    private static class ListNode {
        private int value;
        private ListNode next;

        ListNode() {
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test17.java
     */
    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        head1.value = 1;

        head1.next = new ListNode();
        head1.next.value = 2;

        head1.next.next = new ListNode();
        head1.next.next.value = 3;

        head1.next.next.next = new ListNode();
        head1.next.next.next.value = 4;

        head1.next.next.next.next = new ListNode();
        head1.next.next.next.next.value = 5;


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;

        printList(head1);
        printList(head2);
        printList(merge1(head1, head2));
    }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
