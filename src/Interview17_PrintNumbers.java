/**
 * @Author: TJC
 * @Date: 2020/6/26 21:16
 * @description:
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 思路: 考虑超过int类型范围的问题, 用String来存储数字
 *
 * leetcode里面这道题真sb
 */
public class Interview17_PrintNumbers {
    public int[] printNumbers(int n) {
        if (n < 1) return null;
        int num = 1;
        while (n > 0) {
            num *= 10;
            n -= 1;
        }
        int[] res = new int[num - 1];
        for (int i = 0; i < num - 1; i++) {
            res[i] = i;
        }
        return res;
    }
}
