package com.yjb.cic.stack;

import java.util.Stack;

/**
 * 面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class No31StackPushPopOrder {

    /**
     * 相比于solution1和solution2去掉了当m==n时不必要的先入栈后出栈过程
     */
    private static boolean mySolution(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || push.length != pop.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        outer:
        for (int n : pop) {
            if (!stack.empty() && stack.peek() == n) {
                stack.pop();
                continue;
            }
            while (i < push.length) {
                int m = push[i++];
                if (m == n) {
                    continue outer;
                }
                stack.push(m);
            }
            return false;
        }
        return true;
    }

    /**
     * 修改自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test22.java
     */
    private static boolean solution1(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || push.length != pop.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int n : pop) {
            while (i < push.length && (stack.empty() || stack.peek() != n)) {
                stack.push(push[i++]);
            }
            if (stack.peek() != n) {
                return false;
            }
            stack.pop();
        }
        return true;
    }

    /**
     * 修改自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test22.java
     * <p>
     * 是书上的写法的思路
     */
    private static boolean solution2(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || push.length != pop.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int n : pop) {
            while (stack.isEmpty() || stack.peek() != n) {
                if (i == push.length) {
                    break;
                }
                stack.push(push[i++]);
            }
            if (stack.peek() != n) {
                break;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test22.java
     */
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + mySolution(push, pop1));
        System.out.println("true: " + mySolution(push, pop2));
        System.out.println("false: " + mySolution(push, pop3));
        System.out.println("false: " + mySolution(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + mySolution(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + mySolution(push6, pop6));

        System.out.println("false: " + mySolution(null, null));
    }
}
