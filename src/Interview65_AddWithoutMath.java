/**
 * @Author: TJC
 * @Date: 2020/6/29 14:26
 * @description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 思路: 用两个数分别记录 a b 的不进位加法的结果 sum 和进位 carry, 然后转化为求sum 与 carry的加法直到 carry == 0
 */
public class Interview65_AddWithoutMath {
    public int add(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int _sum = a ^ b;
            int _carry = a & b;
            a = _sum;
            b = _carry << 1;
        }
        return a;
    }
}
