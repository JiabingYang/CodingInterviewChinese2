package com.yjb.cic.string;

/**
 * 不同于No38aStringPermutation的是:
 * 排列结果无重复
 */
public class No38bStringPermutationNoDuplication {

    private static void permutationNoDuplication(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        permutationNoDuplication(chars, 0);
    }

    private static void permutationNoDuplication(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            System.out.print(new String(chars) + " ");
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            boolean swap = true;
            // 这里用遍历我觉得增加了时间复杂度，
            // 感觉还不如直接用HashSet存No38aStringPermutation的解法获取到的结果
            for (int j = begin; j < i; j++) {
                if (chars[j] == chars[i]) {
                    swap = false;
                    break;
                }
            }
            if (swap) {
                char tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
                permutationNoDuplication(chars, begin + 1);
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
            }
        }
    }

    /* ---------------- test -------------- */
    public static void main(String[] args) {
        permutationNoDuplication(new char[]{'a', 'a'});
        System.out.println();
        permutationNoDuplication(new char[]{'a', 'b', 'b'});
        System.out.println();
        permutationNoDuplication(new char[]{'a', 'b', 'b', 'd'});
    }
}
