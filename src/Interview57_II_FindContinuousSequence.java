import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/6/29 10:50
 * @description:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 * 1 <= target <= 10^5
 *
 * 思路: 双指针, 初始化指向 0, 1, 并求其sum, 如果sum小于target, 则right++, 并且sum加上新加的数; 如果sum大于target,
 *       则left++, 并且sum减去移除的数. 循环结束的条件是当left == right
 */
public class Interview57_II_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        if (target == 1) return new int[][] {{1}};
        List<int[]> list = new LinkedList<>();
        int left = 1;
        int right = 2;
        int sum = 3;
        while (left < right) {
            if (sum < target) {
                right++;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                list.add(generateArray(left, right));
                sum -= left;
                left++;
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] generateArray(int begin, int end) {
        int[] array = new int[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            array[i - begin] = i;
        }
        return array;
    }
}
