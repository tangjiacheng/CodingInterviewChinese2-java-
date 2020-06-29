/**
 * @Author: TJC
 * @Date: 2020/6/29 10:26
 * @description:
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 思路: 1. hashMap
 *       2. 将所有数字的相同位置加起来, 得到一个int[32]的数组, 遍历这个数组, 如果某一位不能被3 整除, 则为1, 否则为0
 */
public class Interview56_II_SingleNumber {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                if ((num & bitMask) != 0)
                    bitSum[i]++;
                bitMask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= bitSum[i] % 3;
        }
        return result;
    }
}
