package com.yjb.cic.tree;

/**
 * 面试题7：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 * 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * 图2.6所示的二叉树并输出它的头结点。
 * <p>
 * 前序遍历数组组成：根，左子数，右子树
 * 中序遍历数组组成；左子数，根，右子树
 * 通过前序遍历数组第一个元素找到根，再找到根在中序遍历数组中的位置
 * 然后知道中序遍历数组中的左子树和右子树数组，根据左子树数组长度确定前序遍历数组中的左子树数组和右子树数组
 * 递归
 */
public class No7ConstructBinaryTree {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = construct(preOrder, inOrder);
        printPre(tree);
        System.out.println();
        printIn(tree);
    }

    private static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
        return coreConstruct(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length);
    }

    private static BinaryTreeNode coreConstruct(int[] preOrder, int[] inOrder, int preStart,
                                                int preEnd, int inStart, int inEnd) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 ||
                inOrder.length == 0 || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preOrder[preStart]);
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root.element) {
                root.left = coreConstruct(preOrder, inOrder, preStart + 1, preStart + i - inStart, inStart, i - 1);
                root.right = coreConstruct(preOrder, inOrder, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
                return root;
            }
        }
        return root;
    }

    private static void printPre(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        System.out.print(binaryTreeNode.element);
        if (binaryTreeNode.left != null) {
            printPre(binaryTreeNode.left);
        }
        if (binaryTreeNode.right != null) {
            printPre(binaryTreeNode.right);
        }
    }

    private static void printIn(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        if (binaryTreeNode.left != null) {
            printIn(binaryTreeNode.left);
        }
        System.out.print(binaryTreeNode.element);
        if (binaryTreeNode.right != null) {
            printIn(binaryTreeNode.right);
        }
    }

    private static class BinaryTreeNode {
        int element;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int element) {
            this.element = element;
        }
    }
}
