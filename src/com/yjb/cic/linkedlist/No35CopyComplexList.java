package com.yjb.cic.linkedlist;

import java.util.HashMap;

/**
 * 面试题35：复杂链表的复制
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
 * 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
public class No35CopyComplexList {

    /**
     * 使用HashMap
     * <p>
     * 时间n 空间n
     */
    private static ComplexListNode clone1(ComplexListNode head) {
        ComplexListNode dummy = new ComplexListNode();
        ComplexListNode pNew = dummy;
        ComplexListNode p = head;
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        while (p != null) {
            ComplexListNode c = new ComplexListNode();
            c.value = p.value;
            map.put(p, c);
            pNew.next = c;
            pNew = c;
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).sibling = map.get(p.sibling);
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 更好的方法
     * 分三步（见注释示意图）
     * <p>
     * 时间n 空间1
     */
    private static ComplexListNode clone2(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        // 当前head: [1, 3]->[2, null]->[3, null]->[4, 2]->[5, null]->null
        ComplexListNode p = head;
        while (p != null) {
            ComplexListNode next = p.next;
            ComplexListNode c = new ComplexListNode();
            c.value = p.value;
            c.next = next;
            p.next = c;
            p = next;
        }
        // 当前head: [1, 3]->[1, null]->[2, null]->[2, null]->[3, null]->[3, null]->[4, 2]->[4, null]->[5, null]->[5, null]->null
        p = head;
        while (p != null) {
            if (p.sibling != null) {
                p.next.sibling = p.sibling.next;
            }
            p = p.next.next;
        }
        // 当前head: [1, 3]->[1, 3]->[2, null]->[2, null]->[3, null]->[3, null]->[4, 2]->[4, 2]->[5, null]->[5, null]->null
        p = head;
        ComplexListNode newHead = head.next;
        while (p != null) {
            ComplexListNode next = p.next;
            if (next != null) {
                p.next = next.next;
            }
            p = next;
        }
        // 当前newHead: [1, 3]->[2, null]->[3, null]->[4, 2]->[5, null]->null
        return newHead;
    }

    /* ---------------- 依赖 -------------- */
    private static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test26.java
     */
    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        System.out.println("head");
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;
        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;
        printList(head);
        ComplexListNode newHead = clone2(head);
        printList(newHead);

        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        System.out.println("head2");
        ComplexListNode head2 = new ComplexListNode();
        head2.value = 1;
        head2.next = new ComplexListNode();
        head2.next.value = 2;
        head2.next.next = new ComplexListNode();
        head2.next.next.value = 3;
        head2.next.next.next = new ComplexListNode();
        head2.next.next.next.value = 4;
        head2.next.next.next.next = new ComplexListNode();
        head2.next.next.next.next.value = 5;
        head2.next.sibling = head2.next.next.next.next;
        head2.next.next.next.sibling = head2.next.sibling;
        head2.next.next.sibling = head2.next.next;
        printList(head2);
        ComplexListNode newHead2 = clone2(head2);
        printList(newHead2);

        // 1
        System.out.println("head3");
        ComplexListNode head3 = new ComplexListNode();
        head3.value = 1;
        printList(head3);
        ComplexListNode newHead3 = clone2(head3);
        printList(newHead3);

        // null
        System.out.println("head4");
        ComplexListNode head4 = new ComplexListNode();
        printList(head4);
        ComplexListNode newHead4 = clone2(head4);
        printList(newHead4);
    }

    private static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print("[" + head.value + ", " + (head.sibling == null ? null : head.sibling.value) + "]" + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
