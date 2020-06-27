import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * @Author: TJC
 * @Date: 2020/6/27 15:34
 * @description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * 思路: 用一个辅助栈存放当前栈的最小元素, 每当 push 一个元素进栈时, 比较其与辅助栈栈顶的大小, 如果比当前栈顶小, 则将其压栈,
 *       否则将辅助栈栈顶再次压栈; pop 栈顶元素时, 直接将两个栈都pop即可
 */
public class Interview30_MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    /** initialize your data structure here. */
    public Interview30_MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(x < minStack.peek() ? x : minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return 0;
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }
}
