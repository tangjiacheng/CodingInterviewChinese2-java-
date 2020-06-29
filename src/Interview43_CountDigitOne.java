/**
 * @Author: TJC
 * @Date: 2020/6/28 14:18
 * @description:
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 *
 * 限制：
 * 1 <= n < 2^31
 *
 * 思路: 从左至右递归, 依次考虑每一位数为1的情况. 如果
 */
public class Interview43_CountDigitOne {
    public int countDigitOne(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        return countOne(sb);
    }

    private int countOne(StringBuilder sb) {
        if (sb == null || sb.length() == 0) return 0;
        int first = sb.charAt(0) - '0';
        sb.deleteCharAt(0);
        if (sb.length() == 0) return first == 0 ? 0 : 1;

        int result = 0;
        if (first > 1) {
            result += PowerBase10(sb.length());
        } else if (first == 1) {
            result += Integer.parseInt(sb.toString()) + 1;
        }
        result += first * sb.length() * PowerBase10(sb.length() - 1);
        result += countOne(sb);
        return result;
    }

    private int PowerBase10(int length) {
        int res = 1;
        while (length > 0) {
            res *= 10;
            length--;
        }
        return res;
    }
}
