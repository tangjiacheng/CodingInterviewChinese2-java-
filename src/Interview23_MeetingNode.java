import utils.ListNode;

/**
 * @Author: TJC
 * @Date: 2020/6/27 13:57
 * @description:
 * 对于一个有环的链表, 找到环的入口
 *
 * 思路: 通过快慢指针判断是否有环, 当两个指针相遇后, 慢指针再从起始节点开始往前走, 再次相遇的位置则是环的入口
 */
public class Interview23_MeetingNode {
    public ListNode meetingNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
