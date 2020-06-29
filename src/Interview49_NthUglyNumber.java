import java.util.ArrayList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/6/28 17:25
 * @description:
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 *
 * 思路: 初始化时将第一个丑数 1 , 放入数组中, 后面的每一个丑数都是由前面的丑数 *2, *3 或者 *5 得到, 因此初始化三个index
 *       每当加入一个丑数后, 更新三种情况的下一个数. 最后返回加入的最后一个丑数
 */
public class Interview49_NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0;
        int next2 = 2;
        int index3 = 0;
        int next3 = 3;
        int index5 = 0;
        int next5 = 5;
        int min = 1;
        for (int i = 1; i < n; i++) {
            min = Math.min(next2, Math.min(next3, next5));
            nums[i] = min;
            while (next2 <= min) {
                next2 = 2 * nums[++index2];
            }
            while (next3 <= min) {
                next3 = 3 * nums[++index3];
            }
            while (next5 <= min) {
                next5 = 5 * nums[++index5];
            }
        }
        return min;
    }
}
