/**
 * @Author: TJC
 * @Date: 2020/6/26 19:42
 * @description:
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为
 * k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把
 * 它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * 2 <= n <= 58
 *
 * 思路: 1. 基于动态规划, 设dp[i]表示长度为i的绳子后得到的最大乘积, 然后利用转移方程
 *                          dp[i] = max(dp[j] * (i - j))
 *          遍历所有的j < i
 *       2. 经过计算后发现当每段长度为3时, 得到的乘积最大, 因此不断将绳子剪成每段为3的长度
 */
public class Interview14_CuttingRope {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int count = 0;
        int mul = 0;
        if (n % 3 == 0) {
            count = n / 3;
            mul = 1;
        } else if (n % 3 == 1) {
            count = n / 3 - 1;
            mul = 4;
        } else {
            count = n / 3;
            mul = 2;
        }
        return (int) Math.pow(3, count) * mul;
    }
}

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到
 * 的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 提示：
 *
 * 2 <= n <= 1000
 *
 * 思路: 由于此时m的最大值变为了1000, 指数运算时可能出现 3 ^ 333, 根据题目要求, 需要在每次运算后对结果取模
 *       而取模有两种方法, 一种是线性的将结果每次乘3, 然后取模, 时间复杂度为O(n), 或者每次对指数的一半取模, 然后求平方并
 *       取模. 这时时间复杂度变为了O(logn)
 *
 *       注意 : 由于int类型的精度不够, 需要使用long类型进行操作, [取模] 后再转换为int类型!!!!!
 */
class Interview14_CuttingRope_II {
    private final int mod = 1000000007;

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int count = 0;
        int mul = 0;
        if (n % 3 == 0) {
            count = n / 3;
            mul = 1;
        } else if (n % 3 == 1) {
            count = n / 3 - 1;
            mul = 4;
        } else {
            count = n / 3;
            mul = 2;
        }
        return (int)(mul * pow(3, count) % mod);
    }

    private long pow(long base, int num){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }
}
