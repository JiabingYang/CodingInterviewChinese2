package com.yjb.cic.array;

/**
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 * <p>
 * 遍历 + 交换
 * 时间n 空间1
 * <p>
 * 其他方法：
 * 1. 先排序，然后遍历 时间nlogn 空间1
 * 2. 散列表 时间n 空间n
 */
public class No03aDuplicationInArray {

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2, 1, 3, 1, 4})); // 1
        System.out.println(duplicate(new int[]{2, 4, 3, 1, 4})); // 4
        System.out.println(duplicate(new int[]{2, 4, 2, 1, 4})); // 2,4
        System.out.println(duplicate(new int[]{2, 1, 3, 0, 4})); //  null
//        System.out.println(duplicate(new int[]{ 2, 1, 3, 5, 4 })); //throw IllegalArgumentException
//        System.out.println(duplicate(null)); // throw NullPointerException
    }

    private static Integer duplicate(int[] numbers) {
        if (numbers == null) {
            throw new NullPointerException();
        }
        for (int number : numbers) {
            if (number < 0 || number >= numbers.length) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                int m = numbers[i];
                int n = numbers[m];
                if (n == m) {
                    return m;
                }
                numbers[m] = m;
                numbers[i] = n;
            }
        }
        return null;
    }
}
