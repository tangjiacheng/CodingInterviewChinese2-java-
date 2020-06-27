import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: TJC
 * @Date: 2020/6/26 16:29
 * @description:
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 思路: 使用两个栈 stack1, stack2, 当需要在队列中插入元素时, 直接加入到stack1中; 当需要删除元素时, 首先看stack2是否为空,
 *       如果不为空, 则直接把stack2的栈顶元素删除, 如果为空, 则将stack1中的所有元素加入到stack2中, 然后删除栈顶
 */
public class Interview08_CQueue {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public Interview08_CQueue() {
    }

    public void appendTail(int value) {
        this.stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty() && stack1.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
