/**
 * @Author: TJC
 * @Date: 2020/6/28 20:14
 * @description:
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 思路: 采用二分查找, 寻找数字的两个端点
 */
public class Interview53_I_Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = findFirst(nums, target);
        if (left == -1)
            return 0;
        int right = findLast(nums, target);
        return right - left + 1;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                else left = mid + 1;
            }
        }
        if (nums[right] == target)
            return right;
        else
            return -1;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target)
                    return mid;
                else right = mid - 1;
            }
        }
        if (nums[left] == target)
            return left;
        else
            return -1;
    }
}
