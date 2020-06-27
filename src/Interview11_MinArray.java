/**
 * @Author: TJC
 * @Date: 2020/6/26 16:45
 * @description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 思路: 借用二分查找的思想, 每次分别比较 mid 位置的值与 left 和 right 的大小, 如果 mid 处的值大于等于 left 处, 则说明最小值在
 *       [mid + 1, right]中(闭区间); 如果 mid 处的值小于等于 right 的值, 则说明最小值在 [left, mid]中.
 *       注意一种特殊情况是如果 mid left right 对应的值都相等, 则无法判断最小值所在的区间, 只能通过线性查找判断
 */
public class Interview11_MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] < numbers[right]) return numbers[left];
            int mid = (left + right) >> 1;
            if (numbers[left] == numbers[right] && numbers[left] == numbers[mid]) {
                return linearSearch(numbers, left, right);
            }
            else if (numbers[mid] >= numbers[left]) {
                left = mid + 1;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[left];
    }

    private int linearSearch(int[] numbers, int left, int right) {
        int min = numbers[left];
        for (int i = left + 1; i <= right; i++) {
            min = Math.min(min, numbers[i]);
        }
        return min;
    }
}
