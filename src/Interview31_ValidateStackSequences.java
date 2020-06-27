import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: TJC
 * @Date: 2020/6/27 16:06
 * @description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能
 * 是该压栈序列的弹出序列。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 提示：
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * 思路: 用一个栈来模拟出栈入栈的情况, 用 index1 和 index2 来表示 pushed 和 popped 当前的位置, 如果当前栈顶为空或者栈顶
 *       元素与 popped 当前元素不相等, 则将 pushed 当前的元素压栈. 如果循环结束时 popped数组没有完成遍历, 则返回false
 */
public class Interview31_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || popped.length == 0) return true;
        if (pushed == null || pushed.length == 0) return false;
        int index1 = 0;
        int index2 = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (index1 < pushed.length || index2 < popped.length) {
            if (index1 < pushed.length && (stack.isEmpty() || stack.peek() != popped[index2])) {
                stack.push(pushed[index1++]);
            }else if (!stack.isEmpty() && stack.peek() == popped[index2]) {
                stack.pop();
                index2++;
            }else break;
        }
        return index2 == popped.length;
    }
}
