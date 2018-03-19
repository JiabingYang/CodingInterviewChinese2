package com.yjb.cic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题68：树中两个结点的最低公共祖先
 * 题目：输入两个树结点，求它们的最低公共祖先。
 */
public class No68CommonParentInTree {

    /* ---------------- 二叉查找树 -------------- */

    /**
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     * <p>
     * 树是二叉查找树的最低公共祖先问题
     */
    private static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root.value > p.value && root.value > q.value) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.value < p.value && root.value < q.value) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /* ---------------- 树 -------------- */

    /**
     * 思路参考自：
     * http://blog.csdn.net/derrantcm/article/details/46811835
     */
    private static TreeNode mySolution(TreeNode root, TreeNode p1, TreeNode p2) {
        List<TreeNode> path1 = getNodePath(root, p1, new ArrayList<>());
        if (path1 == null) {
            return null;
        }
        List<TreeNode> path2 = getNodePath(root, p2, new ArrayList<>());
        if (path2 == null) {
            return null;
        }
        int len = Math.min(path1.size(), path2.size());
        for (int i = 1; i < len; i++) {
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }
        return path1.get(len - 1);
    }

    private static List<TreeNode> getNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == target) {
            path.add(root);
            return new ArrayList<>(path);
        }
        path.add(root);
        for (TreeNode node : root.children) {
            List<TreeNode> result = getNodePath(node, target, path);
            if (result != null) {
                return result;
            }
        }
        path.remove(path.size() - 1);
        return null;
    }

    /* ---------------- 依赖 -------------- */
    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    private static class TreeNode {
        int value;
        List<TreeNode> children = new LinkedList<>();

        TreeNode() {
        }

        TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    /* ---------------- test -------------- */

    public static void main(String[] args) {
        test01();
        System.out.println("==========");
        test02();
        System.out.println("==========");
        test03();
    }


    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    private static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n6);
        n4.children.add(n7);

        n3.children.add(n5);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(mySolution(n1, n8, n9));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(mySolution(n1, n4, n5));
    }

    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(mySolution(n1, n5, n5));
    }
}
