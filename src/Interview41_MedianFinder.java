import java.util.ArrayList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/6/28 11:49
 * @description:
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 *
 * 限制：
 *
 * 最多会对 addNum、findMedia进行 50000 次调用。
 *
 * 思路: 将数据分为两部分, 小的一半构造一个大顶堆, 大的一半构造一个小顶堆, 当需要求中位数时,
 *          如果此时总数为奇数, 则取大顶堆的头部
 *          如果此时总数为偶数, 则取两个堆的头部的平均
 *       java中可以用优先队列来替代堆的操作, 优先队列默认按照数据从小到大排列
 *       Queue<Integer> right = new PriorityQueue<>();
 *       Queue<Integer> left = new PriorityQueue<>((x, y) -> (y - x));
 *       用优先队列实现比自己写个堆速度快了很多很多~~~~~
 */
public class Interview41_MedianFinder {

    private final ArrayList<Integer> left; // 大顶堆
    private final ArrayList<Integer> right; // 小顶堆
    private boolean flag = true;

    /** initialize your data structure here. */
    public Interview41_MedianFinder() {
        left = new ArrayList<>();
        right = new ArrayList<>();
    }

    public void addNum(int num) {
        if (flag) {
            if (right.size() > 0 && num > right.get(0)) { // 如果插入到左边的数 大于小顶堆的最小值, 则将其插入到右边, 并将右边的最小值插入到左边
                left.add(right.get(0));
                right.set(0, num);
                buildMinHeap();
            } else {
                left.add(num);
            }
            swap(left, 0, left.size() - 1);
            buildMaxHeap();
        } else {
            if (left.size() > 0 && num < left.get(0)) { // 如果插入到右边的数 小于小顶堆的最大值, 则将其插入到左边, 并将左边的最大值插入到右边
                right.add(left.get(0));
                left.set(0, num);
                buildMaxHeap();
            } else {
                right.add(num);
            }
            swap(right, 0, right.size() - 1);
            buildMinHeap();
        }
        flag = !flag;
    }

    public double findMedian() {
        if (flag) {
            if (left.isEmpty() || right.isEmpty()) {
                return 0;
            }
            else {
                return ((double) (left.get(0) + right.get(0))) / 2;
            }
        } else {
            if (left.isEmpty()) {
                return 0;
            }
            else {
                return left.get(0);
            }
        }
    }

    private void swap(List<Integer> list, int x, int y) {
        if (x != y) {
            int tmp = list.get(x);
            list.set(x, list.get(y));
            list.set(y, tmp);
        }
    }

    private void buildMinHeap() {
        for (int i = (right.size() >> 1); i >= 0; i--) {
            minHeap(i);
        }
    }

    private void buildMaxHeap() {
        for (int i = (left.size() >> 1); i >= 0; i--) {
            maxHeap(i);
        }
    }

    private void minHeap(int i) {
        int leftSon = 2 * i + 1;
        int rightSon = 2 * i + 2;
        int index = i;
        if (leftSon < right.size() && right.get(index) > right.get(leftSon)) {
            index = leftSon;
        }
        if (rightSon < right.size() && right.get(index) > right.get(rightSon)) {
            index = rightSon;
        }
        if (index != i) {
            swap(right, index, i);
            minHeap(index);
        }
    }

    private void maxHeap(int i) {
        int leftSon = 2 * i + 1;
        int rightSon = 2 * i + 2;
        int index = i;
        if (leftSon < left.size() && left.get(index) < left.get(leftSon)) {
            index = leftSon;
        }
        if (rightSon < left.size() && left.get(index) < left.get(rightSon)) {
            index = rightSon;
        }
        if (index != i) {
            swap(left, index, i);
            maxHeap(index);
        }
    }
}
