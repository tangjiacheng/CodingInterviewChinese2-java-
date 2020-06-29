import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/6/29 12:51
 * @description:
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 思路: 和上一道题类似, 维护一个单调不增的队列
 */
public class Interview59_II_MaxQueue {
    private final Deque<Integer> queue;
    private final Deque<Integer> maxQueue;


    public Interview59_II_MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        else return maxQueue.getFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < value)
            maxQueue.removeLast();
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int value = queue.removeFirst();
        if (maxQueue.getFirst() == value)
            maxQueue.removeFirst();
        return value;
    }
}
