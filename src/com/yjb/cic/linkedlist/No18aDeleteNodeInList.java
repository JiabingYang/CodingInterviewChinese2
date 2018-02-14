package com.yjb.cic.linkedlist;

/**
 * 面试题18（一）：在O(1)时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
 * 结点。
 */
public class No18aDeleteNodeInList {

    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点
     * <p>
     * Note:
     * 1. 这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，
     * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了
     * 2. 输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证
     *
     * @param head        链表的表头
     * @param toBeDeleted 待删除的结点
     * @return 删除后的头结点
     */
    private static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }
        if (toBeDeleted == head) {
            return head.next;
        }
        ListNode next = toBeDeleted.next;
        if (next != null) {
            toBeDeleted.value = next.value;
            toBeDeleted.next = next.next;
            return head;
        }
        ListNode p = head;
        while (p.next != toBeDeleted) {
            p = p.next;
        }
        p.next = null;
        return head;
    }

    /* ---------------- 依赖 -------------- */

    private static class ListNode {
        int value;
        ListNode next;
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码参考自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test13.java
     */
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        System.out.println("删除头结点");
        head = deleteNode(head, head); // 删除头结点
        printList(head);
        System.out.println("删除尾结点");
        head = deleteNode(head, last); // 删除尾结点
        printList(head);
        System.out.println("删除中间结点");
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);
        System.out.println("删除的结点不在链表中");
        head = deleteNode(head, node); // 删除的结点不在链表中
        printList(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
