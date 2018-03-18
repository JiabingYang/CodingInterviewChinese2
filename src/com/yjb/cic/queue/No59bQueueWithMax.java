package com.yjb.cic.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题59（二）：队列的最大值
 * 题目：请定义一个队列并实现函数max得到队列里的最大值，
 * 要求函数max、pushBack、popFront的时间复杂度都是O(1)。
 */
public class No59bQueueWithMax {

    /**
     * 修改自：
     * https://github.com/zhedahht/CodingInterviewChinese2/blob/master/59_02_QueueWithMax/QueueWithMax.cpp
     */
    private static class QueueWithMax {
        private Deque<Element> mMaximums = new LinkedList<>();
        private Queue<Element> mQueue = new LinkedList<>();

        void pushBack(int number) {
            while (!mMaximums.isEmpty() && number >= mMaximums.getLast().number) {
                mMaximums.removeLast();
            }
            Element element = new Element(number);
            mMaximums.add(element);
            mQueue.add(element);
        }

        void popFront() {
            if (mMaximums.isEmpty())
                throw new RuntimeException("Queue is empty");
            if (mMaximums.peek() == mQueue.peek()) {
                mMaximums.remove();
            }
            mQueue.remove();
        }

        int max() {
            if (mMaximums.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return mMaximums.peek().number;
        }

        private static class Element {
            int number;

            Element(int number) {
                this.number = number;
            }
        }
    }

    /* ---------------- test -------------- */

    /**
     * 测试用例修改自：
     * https://github.com/zhedahht/CodingInterviewChinese2/blob/master/59_02_QueueWithMax/QueueWithMax.cpp
     */
    public static void main(String[] args) {
        QueueWithMax queue = new QueueWithMax();

        // {2}
        queue.pushBack(2);
        test("Test1", queue, 2);

        // {2, 3}
        queue.pushBack(3);
        test("Test2", queue, 3);

        // {2, 3, 4}
        queue.pushBack(4);
        test("Test3", queue, 4);

        // {2, 3, 4, 2}
        queue.pushBack(2);
        test("Test4", queue, 4);

        // {3, 4, 2}
        queue.popFront();
        test("Test5", queue, 4);

        // {4, 2}
        queue.popFront();
        test("Test6", queue, 4);

        // {2}
        queue.popFront();
        test("Test7", queue, 2);

        // {2, 6}
        queue.pushBack(6);
        test("Test8", queue, 6);

        // {2, 6, 2}
        queue.pushBack(2);
        test("Test9", queue, 6);

        // {2, 6, 2, 5}
        queue.pushBack(5);
        test("Test9", queue, 6);

        // {6, 2, 5}
        queue.popFront();
        test("Test10", queue, 6);

        // {2, 5}
        queue.popFront();
        test("Test11", queue, 5);

        // {5}
        queue.popFront();
        test("Test12", queue, 5);

        // {5, 1}
        queue.pushBack(1);
        test("Test13", queue, 5);
    }

    private static void test(String testName, QueueWithMax queue, int expected) {
        if (testName != null)
            System.out.printf("%s begins: ", testName);
        System.out.println(queue.max() == expected ? "Passed." : "FAILED.");
    }
}
