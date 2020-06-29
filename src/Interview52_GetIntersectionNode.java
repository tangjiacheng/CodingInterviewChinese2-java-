import utils.ListNode;

/**
 * @Author: TJC
 * @Date: 2020/6/28 19:43
 * @description:
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 思路: 用两个指针同时从两个节点开始向前遍历, 设为A 和 B, 假设 A 先到达终点 则将 A 指向 headB, 继续向前直到 B到达终点
 *       当 B 到达终点后, 将B重新指向 headA, 然后与 A 同时向前遍历, 直到A B 相遇或走到终点, 如果没有相遇则最终返回null
 */
public class Interview52_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        if (b == null) {
            b = a;
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        a = headB;
        while (b != null) {
            b = b.next;
            a = a.next;
        }
        b = headA;
        while (b != null) {
            if (a.equals(b))
                return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
