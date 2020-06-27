import java.util.HashSet;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/6/26 15:09
 * @description:
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 两种思路:
 * 1. 可以修改原数组 -> 下标对齐
 * 2. 不能修改 -> HashSet或者类似二分法递归查找
 */
public class Interview03_FindRepeatNumber {

    public int findRepeatNumber1(int[] nums) {
        int index = 0;
        int length = nums.length;
        while (index < length) {
            if (nums[index] != index) {
                int tmp = nums[index];
                if (nums[index] == nums[tmp]) {
                    return nums[index];
                }
                nums[index] = nums[index] ^ nums[tmp];
                nums[tmp] = nums[index] ^ nums[tmp];
                nums[index] = nums[index] ^ nums[tmp];
            } else {
                index++;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

}
