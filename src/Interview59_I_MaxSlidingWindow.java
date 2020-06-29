import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/6/29 12:16
 * @description:
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 思路: 维护一个双头的队列, 并始终保持队列内为单调减, 当下一个数字小于等于队列尾部, 则直接加入队列, 否则将当前队列尾部弹出
 *       再进行比较. 出队时判断与当前队列头部是否相等, 如果相等则将头部出队. 最大值始终可以在队列头部找到
 */
public class Interview59_I_MaxSlidingWindow {
    private final Deque<Integer> queue = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        int length = nums.length - k + 1;
        int[] res = new int[length];
        int left = 0;
        int right = 0;
        while (right < k) {
            addNum(nums[right++]);
        }
        while (left < length - 1) {
            res[left] = getMax();
            removeNum(nums[left++]);
            addNum(nums[right++]);
        }
        res[left] = getMax();
        return res;
    }

    private void addNum(int num) {
        while (!queue.isEmpty() && queue.getLast() < num) {
            queue.removeLast();
        }
        queue.addLast(num);
    }

    private void removeNum(int num) {
        if (queue.getFirst() == num)
            queue.removeFirst();
    }

    private int getMax() {
        return queue.getFirst();
    }
}
