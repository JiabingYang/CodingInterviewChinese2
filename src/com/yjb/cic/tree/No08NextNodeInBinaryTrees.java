package com.yjb.cic.tree;

/**
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * <p>
 * 1、有右子树的，那么下个结点就是右子树最左边的点；（eg：D，B，E，A，C，G）
 * 2、没有右子树的，也可以分成两类：
 * a)是父节点左孩子（eg：N，I，L） ，那么父节点就是下一个节点 ；
 * b)是父节点的右孩子（eg：H，J，K，M）找他的父节点的父节点的父节点…直到当前结点是其父节点的左孩子位置。如果没有，那么他就是尾节点。
 */
public class No08NextNodeInBinaryTrees {

    public static void main(String[] args) {
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.parent = root;
        root.right = new BinaryTreeNode(3);
        root.right.parent = root;
        root.left.left = new BinaryTreeNode(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTreeNode(5);
        root.left.right.parent = root.left;

        System.out.println(getNext(root.left.left)); // 2
        System.out.println(getNext(root.left)); // 5
        System.out.println(getNext(root.left.right)); // 1
        System.out.println(getNext(root)); // 3
        System.out.println(getNext(root.right)); // null
    }

    private static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    private static class BinaryTreeNode {
        int element;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        BinaryTreeNode(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element + "";
        }
    }
}
