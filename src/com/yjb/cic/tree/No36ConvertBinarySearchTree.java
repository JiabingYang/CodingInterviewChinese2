package com.yjb.cic.tree;

/**
 * 面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class No36ConvertBinarySearchTree {

    /* ---------------- mySolution -------------- */
    private static BinaryTreeNode mySolution(BinaryTreeNode root) {
        BinaryTreeNode dummy = new BinaryTreeNode();
        mySolution(root, dummy);
        if (dummy.right != null) {
            dummy.right.left = null;
        }
        return dummy.right;
    }

    private static BinaryTreeNode mySolution(BinaryTreeNode root, BinaryTreeNode tail) {
        if (root == null) {
            return tail;
        }
        tail = mySolution(root.left, tail);
        tail.right = root;
        root.left = tail;
        tail = mySolution(root.right, root);
        return tail;
    }

    /* ---------------- solution1 -------------- */

    /**
     * 修改自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test27.java
     * <p>
     * 书上的写法，不过还是我自己写的更好
     */
    private static BinaryTreeNode solution1(BinaryTreeNode root) {
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        solution1(root, lastNode);
        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void solution1(BinaryTreeNode root, BinaryTreeNode[] lastNode) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            solution1(root.left, lastNode);
        }
        root.left = lastNode[0];

        if (lastNode[0] != null) {
            lastNode[0].right = root;
        }
        lastNode[0] = root;
        if (root.right != null) {
            solution1(root.right, lastNode);
        }
    }

    /* ---------------- 依赖 -------------- */
    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test25.java
     */
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;

        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;

        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;

        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;

        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before solution1: ");
        printTree(node10);
        System.out.println("null");
        System.out.print("After solution1 : ");
        printList(solution1(node10));
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.value = 2;

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.value = 3;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.value = 5;

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before solution1: ");
        printTree(node5);
        System.out.println("null");
        System.out.print("After solution1 : ");
        printList(solution1(node5));
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.value = 2;

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.value = 3;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.value = 5;

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before solution1: ");
        printTree(node1);
        System.out.println("null");
        System.out.print("After solution1 : ");
        printList(solution1(node1));
        System.out.println();
    }

    // 只有一个结点
    private static void test04() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        System.out.print("Before solution1: ");
        printTree(node1);
        System.out.println("null");
        System.out.print("After solution1 : ");
        printList(solution1(node1));
        System.out.println();
    }

    // 没有结点
    private static void test05() {
        System.out.print("Before solution1: ");
        printTree(null);
        System.out.println("null");
        System.out.print("After solution1 : ");
        printList(solution1(null));
        System.out.println();
    }
}
