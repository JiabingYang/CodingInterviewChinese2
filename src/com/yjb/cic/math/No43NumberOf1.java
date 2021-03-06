package com.yjb.cic.math;

/**
 * 面试题43：从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
 * 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 */
public class No43NumberOf1 {

    /**
     * http://blog.csdn.net/xudli/article/details/46798619
     * <p>
     * 每10个数, 有一个个位是1, 每100个数, 有10个十位是1, 每1000个数, 有100个百位是1.
     * 做一个循环, 每次计算单个位上1的总个数(个位,十位, 百位).
     * <p>
     * 例子:
     * 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况:
     * case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
     * case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
     * case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.
     * 以上三种情况可以用 一个公式概括:
     * (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
     */
    private static int numberOf1Between1AndN(int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }
}
