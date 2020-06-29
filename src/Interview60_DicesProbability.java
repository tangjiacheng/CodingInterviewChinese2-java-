import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/29 13:00
 * @description:
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 * 限制：
 * 1 <= n <= 11
 *
 * 思路: n 个骰子点数为 k 的概率 = n-1 个骰子点数为 k-6 ~ k-1 的概率之和 / 6, 因此可以用动态规划的方法, 求出 1 ~ n 个骰子
 *       所有点数出现可能的次数
 *
 *       简单题现在都这样了????
 */
public class Interview60_DicesProbability {
    public double[] twoSum(int n) {
        double[] prob = new double[5 * n + 1];
        int[] pre = new int[6 * n];
        int[] cur = new int[6 * n];
        for (int i = 0; i < 6; i++) {
            pre[i] = 1;
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            int begin = i - 1;
            int end = 6 * i - 1;
            for (int j = end; j >= begin; j--) {
                int idx = j - 1;
                while (idx >= 0 && idx >= j - 6) {
                    cur[j] += pre[idx--];
                }
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
            Arrays.fill(cur, 0);
        }
        for (int i = n - 1; i < 6 * n; i++) {
            count += pre[i];
        }
        for (int i = 0; i <= 5 * n; i++) {
            prob[i] = (double) pre[i + n - 1] / count;
        }
        return prob;
    }
}
