import utils.Node;

/**
 * @Author: TJC
 * @Date: 2020/6/27 19:20
 * @description:
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * 思路: 1. 在原链表中, 将每个节点的复制分别插入到其后面
 *       2. 依次遍历链表中的每一个老节点, 将其 random 指向的节点的 next 赋给其复制出的新节点, 即
 *                      node.next.random = node.random.next;
 *       3. 调整链表中的 next指针, 使链表复原, 从而得到一个新的复制的链表
 *       *注意*: 第二步和第三步不能合并, 因为如果在改变了next指针后, 后面的节点的 random 指针可能会指向原链表中的节点
 */
public class Interview35_CloneNodes {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        node = head;
        Node res = head.next;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            Node nextNode = node.next.next;
            if (nextNode != null)
                node.next.next = nextNode.next;
            node.next = nextNode;
            node = nextNode;
        }
        return res;
    }
}
