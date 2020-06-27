import utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: TJC
 * @Date: 2020/6/26 15:51
 * @description:
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 思路: 1. 使用栈将遍历到的节点的值存储起来, 再依次出线
 *       2. 递归的先输出该节点之后的节点, 再输出自身 (但这种方法问题在于如果链表非常长, 可能会造成函数调用栈溢出)
 */
public class Interview06_ReversePrint {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addLast(head.val);
            head = head.next;
        }
        int n = deque.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = deque.removeLast();
        }
        return res;
    }
}
