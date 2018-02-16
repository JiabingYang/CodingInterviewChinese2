package com.yjb.cic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题32（三）：之字形打印二叉树
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
 * 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class No32cPrintTreesInZigzag {

    private static void mySolution(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zig = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode v = queue.poll();
                if (zig) {
                    sb.append(v.value).append(" ");
                } else {
                    sb.insert(0, " " + v.value);
                }
                if (v.left != null) {
                    queue.offer(v.left);
                }
                if (v.right != null) {
                    queue.offer(v.right);
                }
            }
            zig = !zig;
            System.out.println(sb.toString().trim());
        }
    }

    /**
     * 修改自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test61.java
     * <p>
     * 思路和书上的一样
     */
    private static void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> current = new Stack<>();
        Stack<BinaryTreeNode> reverse = new Stack<>();
        current.add(root);
        boolean zig = true;
        while (!current.empty()) {
            BinaryTreeNode v = current.pop();
            System.out.print(v.value + " ");

            BinaryTreeNode first = zig ? v.left : v.right;
            BinaryTreeNode second = zig ? v.right : v.left;
            if (first != null) {
                reverse.push(first);
            }
            if (second != null) {
                reverse.push(second);
            }

            if (current.empty()) {
                zig = !zig;
                Stack<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }

    /* ---------------- 依赖 -------------- */
    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode() {
        }

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test23.java
     */
    public static void main(String[] args) {

        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;
        print(root);

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        System.out.println();
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 1;
        root2.left = new BinaryTreeNode();
        root2.left.value = 3;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.value = 5;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.value = 9;
        print(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        System.out.println();
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.value = 0;
        root3.right = new BinaryTreeNode();
        root3.right.value = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.value = 4;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.value = 8;
        print(root3);

        // 1
        System.out.println();
        BinaryTreeNode root4 = new BinaryTreeNode();
        root4.value = 1;
        print(root4);

        // null
        System.out.println();
        print(null);

        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //   / \
        //  8   9
        System.out.println();
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        print(n1);
    }
}
