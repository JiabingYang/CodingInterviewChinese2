package com.yjb.cic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题54：二叉搜索树的第k个结点
 * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 */
public class No54KthNodeInBST {

    private static BinaryTreeNode mySolution(BinaryTreeNode root, int k) {
        return dfs(root, new int[]{0}, k);
    }

    private static BinaryTreeNode dfs(BinaryTreeNode root, int[] count, int k) {
        if (root == null || count[0] > k) {
            return null;
        }
        BinaryTreeNode right = dfs(root.right, count, k);
        if (right != null) {
            return right;
        }
        count[0]++;
        if (count[0] == k) {
            return root;
        }
        return dfs(root.left, count, k);
    }

    /* ---------------- 依赖 -------------- */
    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    /* ---------------- test -------------- */
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        //            8
        //        6      10
        //       5 7    9  11
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(9);
        BinaryTreeNode n7 = new BinaryTreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        test(n1);
    }

    private static void test2() {
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        BinaryTreeNode n2 = new BinaryTreeNode(4);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(2);
        BinaryTreeNode n5 = new BinaryTreeNode(1);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;

        test(n1);
    }

    private static void test3() {
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;

        test(n1);
    }

    private static void test(BinaryTreeNode root) {
        System.out.println("-----------------------");
        List<BinaryTreeNode> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        System.out.println(inorderList);

        List<BinaryTreeNode> result = new ArrayList<>();
        for (int i = 1; i <= inorderList.size(); i++) {
            result.add(mySolution(root, i));
        }
        System.out.println(mySolution(root, 0));
        System.out.println(result);
        System.out.println(mySolution(root, inorderList.size() + 1));
    }

    private static void inorder(BinaryTreeNode root, List<BinaryTreeNode> list) {
        if (root != null) {
            inorder(root.right, list);
            list.add(root);
            inorder(root.left, list);
        }
    }
}
