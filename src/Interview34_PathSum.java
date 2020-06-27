import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/6/27 18:59
 * @description:
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 * 节点总数 <= 10000
 *
 * 思路: 回溯, 遍历每条路径, 如果当前的和 > sum, 则回到父节点遍历其他路径, 如果 < sum, 则继续遍历其子节点直到到达叶子节点(DFS)
 *       可用递归或循环实现
 */
public class Interview34_PathSum {
    private final List<List<Integer>> res = new ArrayList<>();
    private final LinkedList<Integer> curList = new LinkedList<>();
    private int curSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        findPath(root, sum);
        return res;
    }

    public void findPath(TreeNode root, int sum) {
        curSum += root.val;
        curList.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (curSum == sum)
                res.add(new LinkedList<>(curList));
        } else {
            if (root.left != null)
                findPath(root.left, sum);
            if (root.right != null)
                findPath(root.right, sum);
        }
        curList.removeLast();
        curSum -= root.val;
    }
}
