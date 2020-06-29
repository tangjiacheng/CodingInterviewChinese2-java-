/**
 * @Author: TJC
 * @Date: 2020/6/28 16:35
 * @description:
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 * 0 <= num < 2^31
 *
 * 思路: 简单的动态规划, 如果当前位于i的数字和前一个数字可以组成x, where 10 <= x < 26, 则dp[i] = dp[i - 2] + dp[i - 1]
 *       否则 dp[i] = d[i - 1]
 */
public class Interview46_TranslateNum {
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        if (nums.length() == 1) return 1;
        int pre = 1;
        int cur = 1;
        int res = 0;
        for (int i = 1; i < nums.length(); i++) {
            int combine = Integer.parseInt(nums.substring(i - 1, i + 1));
            if (combine > 9 && combine < 26) {
                res = pre + cur;
            } else
                res = cur;
            pre = cur;
            cur = res;
        }
        return res;
    }
}
