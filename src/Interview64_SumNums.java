/**
 * @Author: TJC
 * @Date: 2020/6/29 14:05
 * @description:
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 *  
 * 限制：
 * 1 <= n <= 10000
 *
 * 思路: 递归可以不用乘除, 但是由于不能用条件判断, 因此使用 && 短路与运算, 如果判断n < 0 则不会执行后面的加法.
 */
public class Interview64_SumNums {
    public int sumNums(int n) {
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
