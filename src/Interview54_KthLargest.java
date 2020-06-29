import utils.TreeNode;

import java.util.ArrayList;

/**
 * @Author: TJC
 * @Date: 2020/6/28 21:08
 * @description:
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 思路: 根据题目的设定, 我们只需要找到中序遍历中的倒数第K个节点
 *       注意:
 *          这道题和书上的题有区别, 书上是找第k小的节点, 所以直接在一次中序遍历中找就可以了, 而这道题是找第k大,
 *          因此需要把所有节点都遍历出来, 或者修改中序遍历为先右子树, 再左子树
 */
public class Interview54_KthLargest {
    /*private final ArrayList<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        lnr(root);
        return list.get(list.size() - k);
    }

    private void lnr(TreeNode root) {
        if (root.left != null) {
            lnr(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            lnr(root.right);
        }
    }*/

    private TreeNode node = null;
    private int count;
    private int res = 0;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        lnr(root);
        return res;
    }

    private void lnr(TreeNode root) {
        if (root.right != null) {
            lnr(root.right);
        }
        if (node == null) {
            if (count == 1) {
                node = root;
                res = root.val;
            }
            count--;
        }
        if (node == null && root.left != null) {
            lnr(root.left);
        }
    }
}
