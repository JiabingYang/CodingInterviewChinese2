package com.yjb.cic.array;

/**
 * 面试题3（二）：不修改数组找出重复的数字
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * 输出是重复的数字2或者3。
 * <p>
 * 二分查找（重复数字可能范围）
 * 时间nlogn 空间1
 * <p>
 * 其他方法：
 * 1. 遍历，依次复制到新数组中，比较 时间n空间n
 */
public class No3bDuplicationInArrayNoEdit {

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2, 3, 5, 4, 3, 2, 6, 7}));//2,3
        System.out.println(duplicate(new int[]{3, 2, 1, 4, 4, 5, 6, 7}));//4
        System.out.println(duplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 1, 8}));//1
        System.out.println(duplicate(new int[]{1, 7, 3, 4, 5, 6, 8, 2, 8}));//8
        System.out.println(duplicate(new int[]{1, 1}));//1
        System.out.println(duplicate(new int[]{3, 2, 1, 3, 4, 5, 6, 7}));//3
        System.out.println(duplicate(new int[]{1, 2, 2, 6, 4, 5, 6}));//2,6
        System.out.println(duplicate(new int[]{1, 2, 2, 6, 4, 5, 2}));//2
        System.out.println(duplicate(new int[]{1, 2, 6, 4, 5, 3}));//null
        System.out.println(duplicate(null));//null
    }

    private static Integer duplicate(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int end = numbers.length - 1;
        int start = 1;
        while (end >= start) {
            int mid = (end - start) / 2 + start;
            int count = countRange(numbers, start, mid);
            if (end == start) {
                if (count > 1) {
                    return end;
                }
                return null;
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    private static Integer countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int number : numbers) {
            if (number <= end && number >= start) {
                count++;
            }
        }
        return count;
    }
}
