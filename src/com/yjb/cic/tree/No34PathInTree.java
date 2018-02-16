package com.yjb.cic.tree;

import java.util.LinkedList;

/**
 * 面试题34：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 注：本题中树的路径与《数据结构与算法分析：C语言描述》中树的路径的定义不一样
 */
public class No34PathInTree {

    private static void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }
        findPath(root, expectedSum, new LinkedList<>(), 0);
    }

    private static void findPath(BinaryTreeNode root, int expectedSum, LinkedList<Integer> path, int currentSum) {
        path.add(root.value);
        currentSum += root.value;
        if (root.left == null && root.right == null) {
            if (currentSum == expectedSum) {
                for (int value : path) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            path.removeLast();
            return;
        }
        if (root.left != null) {
            findPath(root.left, expectedSum, path, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, expectedSum, path, currentSum);
        }
        path.removeLast();
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
        System.out.println("--------- root ---------");
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 10;
        root.left = new BinaryTreeNode();
        root.left.value = 5;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 4;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 12;

        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);

        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);

        System.out.println("--------- root2 ---------");
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 5;
        root2.left = new BinaryTreeNode();
        root2.left.value = 4;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.value = 3;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.value = 2;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.value = 1;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root2, 16);");
        findPath(root2, 16);

        System.out.println("--------- root3 ---------");
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.value = 1;
        root3.right = new BinaryTreeNode();
        root3.right.value = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.value = 3;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.value = 4;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.value = 5;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);

        System.out.println("--------- root4 ---------");
        // 1
        // 树中只有1个结点
        BinaryTreeNode root4 = new BinaryTreeNode();
        root4.value = 1;
        // 有一条路径上面的结点和为1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);

        // 没有路径上面的结点和为2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);

        System.out.println("--------- null ---------");
        // null
        // 树中没有结点
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }
}
