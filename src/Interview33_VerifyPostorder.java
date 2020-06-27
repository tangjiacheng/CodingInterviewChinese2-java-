/**
 * @Author: TJC
 * @Date: 2020/6/27 17:25
 * @description:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 *
 * 提示：
 * 数组长度 <= 1000
 *
 * 思路: 后序遍历中, 最后一个值为根节点的值, 根据根节点的值可以将遍历结果分为两部分, 然后递归的调用, 如果某个序列中不能
 *       根据大小划分成两部分, 则返回false. 注意边界条件!!!
 */
public class Interview33_VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verifyPostorder(postorder, 0, postorder.length - 1, postorder[postorder.length - 1]);
    }

    private boolean verifyPostorder(int[] postorder, int begin, int end, int root) {
        if (end - begin < 2) return true;

        int index = begin;
        while (index < end && postorder[index] < root) {
            index++;
        }
        int mid = index - 1;
        while (index < end) {
            if (postorder[index] < root)
                return false;
            index++;
        }
        boolean result = true;
        if (mid >= begin)
            result = verifyPostorder(postorder, begin, mid, postorder[mid]);
        if (mid < end)
            result = result && verifyPostorder(postorder, mid + 1, end - 1, postorder[end - 1]);
        return result;
    }
}
