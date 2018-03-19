package com.yjb.cic.stackqueue;

import java.util.Stack;

/**
 * 面试题9：用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class No09aQueueWithTwoStacks {

    public static void main(String[] args) {
        StackQueueSolution3<Integer> mListSolution = new StackQueueSolution3<>();
        for (int i = 0; i < 4; i++) {
            mListSolution.appendTail(i);
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(mListSolution.deleteHead());
        }
    }

    /**
     * 最直接的写法
     */
    public static class StackQueueSolution1<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T t) {
            stack1.push(t);
        }

        public T deleteHead() {
            if (stack1.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            T result = stack2.pop();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /**
     * 最直接的写法中不把栈1的底部元素导到栈2中再从栈2弹出而是直接弹出（需要使用size）
     */
    public static class StackQueueSolution2<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        void appendTail(T t) {
            stack1.push(t);
        }

        T deleteHead() {
            if (stack1.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            int size = stack1.size();
            for (int i = 0; i < size - 1; i++) {
                stack2.push(stack1.pop());
            }
            T result = stack1.pop();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /**
     * 最好的写法（不用size）
     */
    public static class StackQueueSolution3<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        void appendTail(T t) {
            stack1.push(t);
        }

        T deleteHead() {
            if (!stack2.empty()) {
                return stack2.pop();
            }
            if (stack1.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * 最好的写法（用size）
     */
    public static class StackQueueSolution4<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        void appendTail(T t) {
            stack1.push(t);
        }

        T deleteHead() {
            if (!stack2.empty()) {
                return stack2.pop();
            }
            if (stack1.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            int size = stack1.size();
            for (int i = 0; i < size - 1; i++) {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
    }
}
