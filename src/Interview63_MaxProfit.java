/**
 * @Author: TJC
 * @Date: 2020/6/29 14:02
 * @description:
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * 限制：
 * 0 <= 数组长度 <= 10^5
 *
 * 思路: 这道题做了也有10多次了吧, 不会还没有背下来吧, 不会吧不会吧?
 */
public class Interview63_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int min_price = prices[0];
        int max_profit = 0;

        for (int i = 1; i < prices.length; i++) {
            max_profit = Math.max(max_profit, prices[i] - min_price);
            min_price = Math.min(min_price, prices[i]);
        }

        return max_profit;
    }
}
