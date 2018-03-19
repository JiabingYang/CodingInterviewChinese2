package com.yjb.cic.stackqueue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 */
public class No09bStackWithTwoQueues {

    public static void main(String[] args) {
        MQueueStack<Integer> mQueueStack = new MQueueStack<>();
        for (int i = 0; i < 4; i++) {
            mQueueStack.push(i);
        }
        System.out.println(mQueueStack.pop());
        System.out.println(mQueueStack.pop());
        mQueueStack.push(4);
        System.out.println(mQueueStack.peek());
        while (!mQueueStack.empty()) {
            System.out.print(mQueueStack.pop());
        }
    }

    public static class MQueueStack<T> {
        private Queue<T> queue1 = new LinkedList<>();
        private Queue<T> queue2 = new LinkedList<>();

        public T push(T item) {
            if (queue1.peek() == null) {
                queue2.add(item);
            } else {
                queue1.add(item);
            }
            return item;
        }

        public T pop() {
            Queue<T> queuePoll;
            Queue<T> queueAdd;
            if (queue1.peek() == null) {
                queuePoll = queue2;
                queueAdd = queue1;
            } else {
                queuePoll = queue1;
                queueAdd = queue2;
            }
            while (true) {
                T element = queuePoll.poll();
                if (queuePoll.peek() == null) {
                    if (element == null) {
                        throw new EmptyStackException();
                    }
                    return element;
                }
                queueAdd.add(element);
            }
        }

        public synchronized T peek() {
            Queue<T> queuePoll;
            Queue<T> queueAdd;
            if (queue1.peek() == null) {
                queuePoll = queue2;
                queueAdd = queue1;
            } else {
                queuePoll = queue1;
                queueAdd = queue2;
            }
            while (true) {
                T element = queuePoll.poll();
                queueAdd.add(element);
                if (queuePoll.peek() == null) {
                    return element;
                }
            }
        }

        public boolean empty() {
            return queue1.peek() == null && queue2.peek() == null;
        }
    }
}
