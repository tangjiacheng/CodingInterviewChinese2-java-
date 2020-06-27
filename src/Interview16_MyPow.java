/**
 * @Author: TJC
 * @Date: 2020/6/26 20:48
 * @description:
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 *  
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interview16_MyPow {
    public double myPow(double x, int n) {
        boolean flag = false;
        long num = n;
        if (n < 0) {
            flag = true;
            num = -n;
        }
        return flag ? 1 / pow(x, num) : pow(x, num);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double res = pow(x, n >> 1);
        res *= res;
        if ((n & 1) == 1) {
            res *= x;
        }
        return res;
    }
}
