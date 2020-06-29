import utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/28 22:01
 * @description:
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 *
 * 思路: 和上一道题类似, dfs的同时记录深度, 并判断差有没有超过1, 如果超过就设置一个flag
 */
public class Interview55_II_IsBalanced {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (flag && root.right != null) {
            right = dfs(root.right);
        }
        if (left - right > 1 || right - left > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
