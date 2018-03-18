package com.yjb.cic.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题57（二）：和为s的连续正数序列
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * 4～6和7～8。
 */
public class No57bContinuousSquenceWithSum {

    /**
     * 修改自：
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     */
    private static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int l = 1, r = 2;
        int s = 3;
        int mid = sum / 2;
        while (l <= mid && r < sum) {
            if (s > sum) {
                s -= l;
                l++;
            } else if (s < sum) {
                r++;
                s += r;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                result.add(list);
                r++;
                s += r;
            }
        }
        return result;
    }
}
