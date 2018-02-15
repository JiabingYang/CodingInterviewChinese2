package com.yjb.cic.string;

/**
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 */
public class No20NumericStrings {

    /**
     * 参考自：
     * http://blog.csdn.net/derrantcm/article/details/46825671
     * <p>
     * 在数值之前可能有一个表示正负的’-‘或者’+’。
     * 接下来是若干个0到9的数位表示数值的整数部分（在某些小数里可能没有数值的整数部分）。
     * 如果数值是一个小数，那么在小数点后面可能会有若干个0到9的数位表示数值的小数部分。
     * 如果数值用科学计数法表示，接下来是一个’e’或者‘E’，以及紧跟着的一个整数（可以有正负号）表示指数。
     * <p>
     * 判断一个字符串是否符合上述模式时，首先看第一个字符是不是正负号。
     * 如果是，在字符串上移动一个字符，继续扫描剩余的字符串中0到9的数位。
     * 如果是一个小数，则将遇到小数点。
     * 另外，如果是用科学计数法表示的数值，在整数或者小数的后面还有可能遇到’e’或者’E’。
     */
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int i = 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            i++;
        }
        if (i >= str.length()) {
            // [+|-]
            return false;
        }
        i = skipDigits(str, i);
        if (i >= str.length()) {
            // [+|-][A]
            return true;
        }
        if (str.charAt(i) == '.') {
            i = skipDigits(str, ++i);
            if (i >= str.length()) {
                // [+|-][A].[B]
                return true;
            }
            // [+|-][A].[B][e|EC]
            return i < str.length() && (str.charAt(i) == 'e' || str.charAt(i) == 'E') && isInteger(str, ++i);
        }
        // [+|-][A][e|EC]
        return (str.charAt(i) == 'e' || str.charAt(i) == 'E') && isInteger(str, ++i);
    }

    private static boolean isInteger(String str, int i) {
        if (i >= str.length()) {
            return false;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            i++;
        }
        if (i >= str.length()) {
            return false;
        }
        i = skipDigits(str, i);
        return i >= str.length();
    }

    private static int skipDigits(String str, int i) {
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            i++;
        }
        return i;
    }

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test54.java
     */
    public static void main(String[] args) {
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(isNumeric("+500") + "[" + true + "]");
        System.out.println(isNumeric("5e2") + "[" + true + "]");
        System.out.println(isNumeric("3.1416") + "[" + true + "]");
        System.out.println(isNumeric("600.") + "[" + true + "]");
        System.out.println(isNumeric("-.123") + "[" + true + "]");
        System.out.println(isNumeric("-1E-16") + "[" + true + "]");
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("1.79769313486232E+308") + "[" + true + "]");
        System.out.println();
        System.out.println(isNumeric("12e") + "[" + false + "]");
        System.out.println(isNumeric("1a3.14") + "[" + false + "]");
        System.out.println(isNumeric("1+23") + "[" + false + "]");
        System.out.println(isNumeric("1.2.3") + "[" + false + "]");
        System.out.println(isNumeric("+-5") + "[" + false + "]");
        System.out.println(isNumeric("12e+5.4") + "[" + false + "]");
    }
}
