import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/28 11:10
 * @description:
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 思路: 还是基于 partition 函数寻找 index 为 k 的那个数
 */
public class Interview40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int begin = 0;
        int end = arr.length - 1;
        int index = partition(arr, begin, end);
        while (index != k) {
            if (index > k) {
                end = index - 1;
                index = partition(arr, begin, end);
            } else {
                begin = index + 1;
                index = partition(arr, begin, end);
            }
        }
        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr, int begin, int end) {
        if (begin == end) return begin;
        int index = begin + 1;
        for (int i = index; i <= end; i++) {
            if (arr[begin] > arr[i]) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, begin, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int x, int y) {
        if (x != y) {
            arr[x] = arr[x] ^ arr[y];
            arr[y] = arr[x] ^ arr[y];
            arr[x] = arr[x] ^ arr[y];
        }
    }
}
