import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/28 19:15
 * @description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * 思路: 基于归并排序, 一边进行排序, 一边统计逆序对的数量
 */
public class Interview51_ReversePairs {
    private int count = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        mergeSort(nums, 0, nums.length);
        return count;
    }

    private int[] mergeSort(int[] nums, int begin, int end) {
        if (end - begin < 2) return Arrays.copyOfRange(nums, begin, end);
        if (end - begin == 2) {
            int[] res = Arrays.copyOfRange(nums, begin, end);
            if (res[0] > res[1]) {
                count++;
                swap(res, 0, 1);
            }
            return res;
        }
        int mid = (begin + end) >> 1;
        int[] left = mergeSort(nums, begin, mid);
        int[] right = mergeSort(nums, mid, end);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftIndex = left.length - 1;
        int rightIndex = right.length - 1;
        int[] res = new int[leftIndex + rightIndex + 2];
        while (leftIndex >= 0 && rightIndex >= 0) {
            if (left[leftIndex] <= right[rightIndex]){
                res[leftIndex + rightIndex + 1] = right[rightIndex];
                rightIndex--;
            } else {
                count += rightIndex + 1;
                res[leftIndex + rightIndex + 1] = left[leftIndex];
                leftIndex--;
            }
        }
        while (leftIndex >= 0) {
            res[leftIndex] = left[leftIndex];
            leftIndex--;
        }
        while (rightIndex >= 0) {
            res[rightIndex] = right[rightIndex];
            rightIndex--;
        }
        return res;
    }

    private void swap(int[] res, int x, int y) {
        res[x] = res[x] ^ res[y];
        res[y] = res[x] ^ res[y];
        res[x] = res[x] ^ res[y];
    }
}
