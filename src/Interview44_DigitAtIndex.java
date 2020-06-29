/**
 * @Author: TJC
 * @Date: 2020/6/28 14:55
 * @description:
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 *  
 * 限制：
 * 0 <= n < 2^31
 *
 * 思路: 将所有数字根据位数计算区间, 从而定位要求的数字所在的区间, 然后根据其在区间内的偏移(/)定位到具体的某个数, 再根据其
 *       在某个数中的偏移(%)计算得到具体的数字
 */
public class Interview44_DigitAtIndex {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        long nums = 10;
        int bit = 1;
        while (n >= nums) {
            n -= nums;
            bit++;
            nums = bit * 9 * powerBase10(bit);
        }
        long target = powerBase10(bit) + n / bit;   // 定位到具体的数
        int location = n % bit;                     // 计算这个数中的偏移
        return (String.valueOf(target).charAt(location) - '0');
    }

    private long powerBase10(int n) {
        long res = 1;
        while (n > 1) {
            res *= 10;
            n--;
        }
        return res;
    }
}
