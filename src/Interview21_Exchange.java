/**
 * @Author: TJC
 * @Date: 2020/6/27 13:32
 * @description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 思路: 设置两个指针 left 和 right 分别指向数组的头部和尾部, left 向后扫描直到遇到偶数, right向前扫描直到遇到奇数, 如果
 *       此时 left < right , 则交换nums中对应位置的两个数. 时间复杂度 O(n), 空间复杂度O(1)
 */
public class Interview21_Exchange {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && (nums[left] & 1) == 1) {
                left++;
            }
            while (right >= 0 && (nums[right] & 1) == 0) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
            }
        }
        return nums;
    }
}
