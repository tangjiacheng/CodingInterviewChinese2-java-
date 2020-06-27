import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/6/27 16:23
 * @description:
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 * 节点总数 <= 1000
 *
 * 思路: 用队列来模拟树的层次遍历, 首先将根节点入队
 *       循环: 如果队列非空, 则将队首节点的两个儿子(not null)入队, 并将队首出队
 */
public class Interview32_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        int index = 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (index < list.size()) {
            if (list.get(index).left != null)
                list.add(list.get(index).left);
            if (list.get(index).right != null)
                list.add(list.get(index).right);
            index++;
        }
        int[] res = new int[index - 1];
        for (int i = 0; i < index - 1; i++) {
            res[i] = list.get(i).val;
        }
        return res;
    }
}
