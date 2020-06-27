import utils.ListNode;

/**
 * @Author: TJC
 * @Date: 2020/6/27 13:45
 * @description:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 思路: 定义两个指针 front 和 behind , front指针先走 k 步, 然后让两个指针同时往前走, 当 front 走到链表末尾时, behind指针
 *       指向的节点则是倒数第k个
 */
public class Interview22_FindKthToTail {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode front = head;
        ListNode behind = head;
        while (k-- > 1 && front.next != null) {
            front = front.next;
        }
        while (front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        return behind;
    }
}
