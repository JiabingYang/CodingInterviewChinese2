package com.yjb.cic.stack;

import java.util.Stack;

/**
 * 面试题30：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
 * 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class No30MinInStack {

    private static class StackWithMin<T extends Comparable<T>> {
        private Stack<T[]> stack = new Stack<>();

        T pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("The stack is already empty");
            }
            return stack.pop()[0];
        }

        @SuppressWarnings("unchecked")
        void push(T t) {
            if (t == null) {
                throw new RuntimeException("Element can not be null");
            }
            if (stack.isEmpty()) {
                stack.push((T[]) new Comparable[]{t, t});
                return;
            }
            T min = stack.peek()[1];
            stack.push((T[]) new Comparable[]{t, t.compareTo(min) < 0 ? t : min});
        }

        T min() {
            if (stack.isEmpty()) {
                throw new RuntimeException("No element in stack");
            }
            return stack.peek()[1];
        }
    }

    /* ---------------- test -------------- */
    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test21.java
     */
    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        System.out.println(stack.pop() == 3);
        System.out.println(stack.min() == 2);
        System.out.println(stack.pop() == 2);
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
