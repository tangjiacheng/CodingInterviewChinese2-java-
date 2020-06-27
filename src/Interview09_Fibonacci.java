/**
 * @Author: TJC
 * @Date: 2020/6/26 16:39
 * @description:
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class Interview09_Fibonacci {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = (pre + cur) % 1000000007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
