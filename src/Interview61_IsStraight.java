import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/29 13:41
 * @description:
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5 
 * 数组的数取值为 [0, 13] .
 *
 * 思路: 将数组排序, 然后统计0的数量 和 后面非0牌的相邻的差, 如果差值大于0的数量, 则返回false
 */
public class Interview61_IsStraight {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        Arrays.sort(nums);
        int zero = 0;
        while (nums[zero] == 0) zero++;
        // 我就不太懂为什么一副牌里面可以出现 3 个王????? 加了一张广告牌????
        if (zero > 2) return false;
        int idx = zero + 1;
        int miss = 0;
        while (idx < 5) {
            if (nums[idx] == nums[idx - 1]) return false;
            miss += nums[idx] - nums[idx - 1] - 1;
            idx++;
        }
        return miss <= zero;
    }
}
