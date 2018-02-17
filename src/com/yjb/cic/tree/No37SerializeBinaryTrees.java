package com.yjb.cic.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题37：序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class No37SerializeBinaryTrees {

    /* ---------------- mySolution -------------- */

    /**
     * 思路按照书本上的思路
     * 使用前序遍历序列（,分隔 $表示null）
     */
    private static String serialize1(BinaryTreeNode root) {
        return serialize1(root, null);
    }

    private static String serialize1(BinaryTreeNode root, String current) {
        if (root == null) {
            return current + ",$";
        }
        String result = current == null ? String.valueOf(root.val) : current + "," + root.val;
        result = serialize1(root.left, result);
        result = serialize1(root.right, result);
        return result;
    }

    private static BinaryTreeNode deserialize1(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return deserialize1(str, new int[]{-1});
    }

    private static BinaryTreeNode deserialize1(String str, int[] start) {
        start[0]++;
        if (start[0] >= str.length()) {
            return null;
        }
        if (str.charAt(start[0]) == '$') {
            start[0]++;
            return null;
        }
        int left = start[0];
        while (start[0] < str.length() && str.charAt(start[0]) != ',') {
            start[0]++;
        }
        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(str.substring(left, start[0])));
        root.left = deserialize1(str, start);
        root.right = deserialize1(str, start);
        return root;
    }

    /* ---------------- solution2 -------------- */

    /**
     * 修改自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test62.java
     * <p>
     * 使用BFS输出序列（包含null）
     * 类似于数组存二叉堆那样
     */
    private static List<Integer> serialize2(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        serialize2(root, result);
        return result;
    }

    private static void serialize2(BinaryTreeNode root, List<Integer> result) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode v = queue.remove();
            if (v == null) {
                result.add(null);
            } else {
                result.add(v.val);
                queue.add(v.left);
                queue.add(v.right);
            }
        }
    }

    private static BinaryTreeNode deserialize2(List<Integer> list) {
        return deserialize2(list, 0);
    }

    private static BinaryTreeNode deserialize2(List<Integer> result, int idx) {
        if (result.size() < 1 || idx < 0 || result.size() <= idx || result.get(idx) == null) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(result.get(idx));
        root.left = deserialize2(result, idx * 2 + 1);
        root.right = deserialize2(result, idx * 2 + 2);
        return root;
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

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test62.java
     */
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //   / \
        //  8   9
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

        // test mySolution
        System.out.println("test mySolution");
        System.out.print("original: ");
        print(n1);
        System.out.println();
        String result = serialize1(n1);
        System.out.println("serialized: " + result);
        System.out.print("deserialized: ");
        print(deserialize1(result));
        System.out.println();

        System.out.println("-------------------");

        // test solution2
        System.out.println("test solution2");
        System.out.print("original: ");
        print(n1);
        System.out.println();
        List<Integer> result2 = serialize2(n1);
        System.out.println("serialized: " + result2);
        System.out.print("deserialized: ");
        print(deserialize2(result2));
    }

    private static void print(BinaryTreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }
}
