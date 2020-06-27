import utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/27 14:33
 * @description:
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * 思路: 递归的每次交换节点的两个子节点
 */
public class Interview27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        exchange(root);
        return root;
    }

    private void exchange(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            exchange(root.left);
            exchange(root.right);
        }
    }
}
