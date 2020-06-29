import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/6/29 15:36
 * @description:
 * 给定一个 *二叉树*, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 思路: 深度优先(先序)遍历节点, 找到从根节点到两个节点的路径, 然后找到两条路径中的最后一个公共节点
 */
public class Interview68_II_LowestCommonAncestor {
    private final List<LinkedList<TreeNode>> list = new LinkedList<>();
    private final LinkedList<TreeNode> stack = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        nlr(root, p, q);
        int index = 0;
        while (index + 1 < list.get(0).size() && index < list.get(1).size() && list.get(0).get(index + 1) == list.get(1).get(index + 1)) {
            index++;
        }
        return list.get(0).get(index);
    }

    private void nlr(TreeNode root, TreeNode p, TreeNode q) {
        stack.addLast(root);
        if (root == p || root == q) {
            list.add(new LinkedList<>(stack));
        }
        if (list.size() != 2 && root.left != null) {
            nlr(root.left, p, q);
        }
        if (list.size() != 2 && root.right != null) {
            nlr(root.right, p, q);
        }
        stack.removeLast();
    }
}
