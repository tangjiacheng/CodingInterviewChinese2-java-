import utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/29 15:22
 * @description:
 * 给定一个 *二叉搜索树*, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 思路: 由于是二叉搜索树, 因此我们只需要寻找一个节点使得 root.val => p.val && root.val <= q.val 的情况, 此时直接输出root.
 */
public class Interview68_I_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        // 定义 p 为较小的一个, q为较大的一个
        if (q.val < p.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root.val < p.val && root.right != null)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > q.val && root.left != null)
            return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}
