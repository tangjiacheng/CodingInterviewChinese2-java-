/**
 * @Author: TJC
 * @Date: 2020/6/27 13:13
 * @description:
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示
 * 数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * 思路: 将其看成是字符串的匹配, 模式为 A[.[B]][e|EC], 其中A, C为可以带符号的整数, B为无符号整数, 并考虑A不存在以 .B 开始
 * 的情况
 */
public class Interview20_isNumeric {
    private int index = 0;
    private int length;

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        length = s.length();
        boolean numeric = scanInteger(s);
        if (index < length && s.charAt(index) == '.') {
            index++;
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if (index < length && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            numeric = numeric && scanInteger(s);
        }
        return numeric && index == length;

    }

    private boolean scanInteger(String s) {
        if (index < length && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            index++;
        }
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int before = index;
        while (index < length && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            index++;
        }
        return index > before;
    }
}
