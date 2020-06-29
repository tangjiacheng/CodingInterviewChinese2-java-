import utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/28 21:52
 * @description:
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 思路: 这有啥思路好写呀, dfs一个递归就完事儿
 */
public class Interview55_I_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        if (root.left != null)
            depth = maxDepth(root.left);
        if (root.right != null)
            depth = Math.max(depth, maxDepth(root.right));
        return depth + 1;
    }
}
