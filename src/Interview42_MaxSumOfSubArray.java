/**
 * @Author: TJC
 * @Date: 2020/6/28 14:15
 * @description:
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 思路: 没啥好说的, 这道题都不会怎么找工作??????
 */
public class Interview42_MaxSumOfSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        int pre = nums[0];
        int max = pre;

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
