package com.yjb.cic.linkedlist;

import java.util.LinkedList;

/**
 * 面试题6：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * <p>
 * 栈/递归
 * 时间n 空间n
 */
public class No6PrintListInReversedOrder {

    public static void main(String[] args) {
        Node head1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node head2 = new Node(1, null);
        Node head3 = null;
        printListReverselyRecursively(head1);
        System.out.println();
        printListReverselyIteratively(head1);
        System.out.println();
        printListReverselyRecursively(head2);
        System.out.println();
        printListReverselyIteratively(head2);
        System.out.println();
        printListReverselyRecursively(head3);
        System.out.println();
        printListReverselyIteratively(head3);
    }

    private static void printListReverselyRecursively(Node head) {
        if (head == null) {
            return;
        }
        if (head.next != null) {
            printListReverselyRecursively(head.next);
        }
        System.out.print(head.element);
    }

    private static void printListReverselyIteratively(Node head) {
        if (head == null) {
            return;
        }
        LinkedList<Integer> elements = new LinkedList<>();
        while (head != null) {
            elements.push(head.element);
            head = head.next;
        }
        while (elements.peek() != null) {
            System.out.print(elements.pop());
        }
    }

    private static class Node {
        int element;
        Node next;

        Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
