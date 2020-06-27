import utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/27 19:58
 * @description:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，
 * 第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
 * 还需要返回链表中的第一个节点的指针。
 *
 * 思路: 解法1: 通过中序遍历将所有的节点保存在一个List中, 然后遍历List并修改每个节点的left和right指针;
 *       解法2: 在中序遍历的同时进行修改
 *              lnr 的输入为当前的根节点和最左边的节点, 输出为当前根节点对应的最右边的节点
 *              对于根节点而言, 其 left 指针指向以其左儿子调用lnr的输出, 而根节点本身为其右儿子调用lnr的输入
 *
 */
public class Interview36_TreeToDoublyList {
    TreeNode lastNode = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return root;
        TreeNode head = root;
        lnr(root, lastNode);
        while (head.left != null) {
            head = head.left;
        }
        head.left = lastNode;
        lastNode.right = head;
        return head;
    }

    private void lnr(TreeNode root, TreeNode left) {
        if (root.left != null) {
            lnr(root.left, left);
        }
        root.left = lastNode;
        if (lastNode != null) {
            lastNode.right = root;
        }
        lastNode = root;
        if (root.right != null) {
            lnr(root.right, lastNode);
        }
    }

    /*List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node head = new Node();
        lnr(root);
        head = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).left = list.get(list.size() - 1);
            }else {
                list.get(i).left = list.get(i - 1);
            }
            if (i == list.size() - 1) {
                list.get(i).right = list.get(0);
            }else {
                list.get(i).right = list.get(i + 1);
            }
        }
        return head;
    }

    public void lnr(Node root) {
        if (root.left != null) {
            lnr(root.left);
        }
        list.add(root);
        if (root.right != null) {
            lnr(root.right);
        }
    }*/
}
