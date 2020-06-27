import utils.ListNode;

/**
 * @Author: TJC
 * @Date: 2020/6/27 14:05
 * @description:
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 思路: 通过循环来实现, 保存三个节点, pre cur 和 next, 初始化 pre 为 null, cur 为第一个节点, next 为第二个节点, 每次将
 *       cur.next 保存在 next 中, 然后让 cur 指向 pre , 再令 pre = cur, cur = next , 重复这个过程, 直到 next == null ,
 *       这时返回 pre 即可
 */
public class Interview24_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
