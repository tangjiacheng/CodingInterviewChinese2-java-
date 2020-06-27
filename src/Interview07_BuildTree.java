import utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/26 16:01
 * @description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 思路: 根据前序遍历找到树的根节点, 然后在中序遍历中划分左右子树, 重复这个过程
 *
 */
public class Interview07_BuildTree {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(0, preorder.length, preorder, inorder);
    }

    private TreeNode buildSubTree(int start, int end, int[] preorder, int[] inorder) {
        if (start >= end) return null;
        if (end - start < 2) return new TreeNode(preorder[preIndex++]);

        int inIndex = findIndexInInorder(preorder[preIndex], start, end, inorder);
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = buildSubTree(start, inIndex, preorder, inorder);
        root.right = buildSubTree(inIndex + 1, end, preorder, inorder);
        return root;
    }

    private int findIndexInInorder(int value, int start, int end, int[] inorder) {
        for (int i = start; i < end; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}
