package com.yjb.cic.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题50（二）：字符流中第一个只出现一次的字符
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
 * 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
 * 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
public class No50bFirstCharacterInStream {

    /**
     * 修改自：
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     */
    private static class Solution {
        private int[] counts = new int[256];
        private Queue<Character> queue = new LinkedList<>();

        public void insert(char ch) {
            counts[ch]++;
            queue.add(ch);
            while (!queue.isEmpty() && counts[queue.peek()] > 1) {
                queue.poll();
            }
        }

        public Character firstAppearingOnce() {
            if (queue.isEmpty()) {
                return null;
            }
            return queue.peek();
        }
    }
}
