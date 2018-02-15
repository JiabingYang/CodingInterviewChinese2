package com.yjb.cic.linkedlist;

/**
 * 面试题18（二）：删除链表中重复的结点
 * 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * 结点被删除之后，链表如图3.4（b）所示。
 */
public class No18bDeleteDuplicatedNode {

    private static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode p = pre.next;
            if (p.value != p.next.value) {
                pre = pre.next;
                continue;
            }
            int val = p.value;
            do {
                p = p.next;
            } while (p != null && p.value == val);
            pre.next = p;
        }
        return dummy.next;
    }

    /* ---------------- 依赖 -------------- */

    private static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码参考自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test57.java
     */
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
        test08();
        test09();
        test10();
    }

    // 1->2->3->3->4->4->5
    private static void test01() {
        System.out.println("test01: 1->2->3->3->4->4->5");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        print(deleteDuplication(n1));
    }

    // 1->2->3->4->5->6->7
    private static void test02() {
        System.out.println("test02: 1->2->3->4->5->6->7");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        print(deleteDuplication(n1));
    }

    // 1->1->1->1->1->1->2
    private static void test03() {
        System.out.println("test03: 1->1->1->1->1->1->2");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        print(deleteDuplication(n1));
    }


    // 1->1->1->1->1->1->1
    private static void test04() {
        System.out.println("test04: 1->1->1->1->1->1->1");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        print(deleteDuplication(n1));
    }

    // 1->1->2->2->3->3->4->4
    private static void test05() {
        System.out.println("test05: 1->1->2->2->3->3->4->4");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        print(deleteDuplication(n1));
    }

    // 1->1->2->3->3->4->5->5
    private static void test06() {
        System.out.println("test06: 1->1->2->3->3->4->5->5");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        print(deleteDuplication(n1));
    }

    // 1->1->2->2->3->3->4->5->5
    private static void test07() {
        System.out.println("test07: 1->1->2->2->3->3->4->5->5");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        print(deleteDuplication(n1));
    }

    // 1->2
    private static void test08() {
        System.out.println("test08: 1->2");
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        print(deleteDuplication(n1));
    }

    // 1
    private static void test09() {
        System.out.println("test09: 1");
        ListNode n1 = new ListNode(1);
        print(deleteDuplication(n1));
    }

    // null
    private static void test10() {
        System.out.println("test10: null");
        print(deleteDuplication(null));
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
