package com.yjb.cic.tree;

import java.util.Stack;

/**
 * 面试题28：对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * 它的镜像一样，那么它是对称的。
 */
public class No28SymmetricalBinaryTree {

    /* ---------------- 递归 -------------- */

    /**
     * http://blog.csdn.net/u012162613/article/details/41213149
     * <p>
     * 递归
     */
    private static boolean isSymmetrical1(BinaryTreeNode root) {
        return isSymmetrical1(root, root);
    }

    private static boolean isSymmetrical1(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSymmetrical1(root1.left, root2.right) && isSymmetrical1(root1.right, root2.left);
    }

    /* ---------------- 栈 -------------- */

    /**
     * http://blog.csdn.net/u012162613/article/details/41213149
     * <p>
     * 栈
     */
    private static boolean isSymmetrical2(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            BinaryTreeNode p = stack.pop();
            BinaryTreeNode q = stack.pop();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            stack.push(p.left);
            stack.push(q.right);
            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }

    /* ---------------- 依赖 -------------- */
    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test59.java
     */
    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void assemble(BinaryTreeNode node,
                                 BinaryTreeNode left,
                                 BinaryTreeNode right) {
        node.left = left;
        node.right = right;
    }

    //                            1
    //                  2                   2
    //             4         6          6          4
    //          8     9   10   11   11     10   9     8
    private static void test01() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(2);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(6);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n12 = new BinaryTreeNode(11);
        BinaryTreeNode n13 = new BinaryTreeNode(10);
        BinaryTreeNode n14 = new BinaryTreeNode(9);
        BinaryTreeNode n15 = new BinaryTreeNode(8);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);

        System.out.println(isSymmetrical2(n1));

    }


    //                            1
    //                  2                   2
    //             4         5          6          4
    //          8     9   10   11   11     10   9     8
    private static void test02() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(2);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n12 = new BinaryTreeNode(11);
        BinaryTreeNode n13 = new BinaryTreeNode(10);
        BinaryTreeNode n14 = new BinaryTreeNode(9);
        BinaryTreeNode n15 = new BinaryTreeNode(8);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);

        System.out.println(isSymmetrical2(n1));

    }
}
