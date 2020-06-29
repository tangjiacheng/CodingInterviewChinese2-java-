/**
 * @Author: TJC
 * @Date: 2020/6/28 10:34
 * @description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 * 思路: 1. 通过快速排序中的 partition 函数来找排序后最中心的元素. 由于存在一个数字超过了一半, 因此在排序之后必然出现在len/2的位置
 *       2. 抵消法: 保存第一个数字, 如果下一个数字与其相同, 则数量 + 1, 如果不同, 则数量 - 1, 如果数量为0, 则保存下一个数字,
 *          这样最终保存的数字则为超过一半的那个
 */
public class Interview39_MajorityElement {

    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else {
                if (num == res)
                    count++;
                else
                    count--;
            }
        }
        return res;
    }

    /*private int length;

    public int majorityElement(int[] nums) {
        length = nums.length;
        int middle = findMiddle(nums, 0, length);
        return nums[middle];
    }

    private int findMiddle(int[] nums, int begin, int end) {
        if (end - begin < 2) return begin;
        int index = partition(nums, begin, end);
        if (index < length >> 1)
            return findMiddle(nums, index + 1, end);
        else if (index > length >> 1)
            return findMiddle(nums, begin, index);
        else return index;
    }

    private int partition(int[] nums, int begin, int end) {
        int index = begin + 1;
        for (int i = begin + 1; i < end; i++) {
            if (nums[i] < nums[begin]) {
                swap(nums, index++, i);
            }
        }
        swap(nums, begin, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int x, int y) {
        if (x != y) {
            nums[x] = nums[x] ^ nums[y];
            nums[y] = nums[x] ^ nums[y];
            nums[x] = nums[x] ^ nums[y];
        }
    }*/
}
