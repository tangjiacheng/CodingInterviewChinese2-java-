/**
 * @Author: TJC
 * @Date: 2020/6/29 10:09
 * @description:
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 思路: 1. 用一个hashMap来存储数字出现的次数, 然后再次遍历数组, 找到只出现一次的两个数字
 *       2. 对所有数字求异或 ^ , 然后根据第一个不为一的位将所有数字划分成两部分, 分别求异或, 从而得到两个数字
 */
public class Interview56_I_SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int index = 1;
        while ((xor & index) == 0) {
            index <<= 1;
        }
        for (int num : nums) {
            if ((num & index) == 0) {
                res[1] ^= num;
            } else {
                res[0] ^= num;
            }
        }
        return res;
    }
}
