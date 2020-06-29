import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/28 15:57
 * @description:
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 *
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 思路: 本质上是需要对原数组重新排序, 只是需要重新定义一个排序的规则, 即
 *          x concat y 与 y concat x 进行大小比较, 然后把小的放在前面
 *       因此可以直接调用 Arrays.sort() 方法进行排序, 需要再传入一个 Comparator, 可以直接用 Lambda 表达式表示:
 *          (x, y) -> (x + y).compareTo(y + x)
 *       熟练使用内置的方法!!!!!!自己写的快排效率还是太差!!!!!而且面试的时候哪有这么多时间来写快排!!!!!!!!
 */
public class Interview45_MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
//        QuickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        /*while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }*/
        return sb.toString();
    }

    /**
     * 用自己写的排序效果不忍直视!!!!
     * 13ms v.s. 6ms
     */
    private void QuickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int pivot = partition(nums, begin, end);
            QuickSort(nums, begin, pivot - 1);
            QuickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int begin, int end) {
        int index = begin + 1;
        for (int i = begin; i <= end; i++) {
            if (lessThan(nums[i], nums[begin])) {
                swap(nums, index++, i);
            }
        }
        swap(nums, begin, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }

    private boolean lessThan(int x, int y) {
        String strX = "" + x + y;
        String strY = "" + y + x;
        return strX.compareTo(strY) < 0;
    }
}
