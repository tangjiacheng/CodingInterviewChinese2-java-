import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/6/27 20:40
 * @description:
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 思路: 序列化过程为将二叉树层次遍历, 反序列化过程为将层次遍历的结果转化为二叉树
 *       层次遍历时, 对于中间的 null 需要保存起来, 而对于末尾的null则不保存
 */
public class Interview37_Serialize {
    LinkedList<TreeNode> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "";

        sb.append('[');
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int nullNum = 0;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(',');
                    if (node.left != null) {
                        addNull(nullNum);
                        nullNum = 0;
                        queue.addLast(node.left);
                    } else nullNum++;
                    if (node.right != null) {
                        addNull(nullNum);
                        nullNum = 0;
                        queue.addLast(node.right);
                    } else nullNum++;
                } else printNull();
            }
        }
        sb.setCharAt(sb.length(), ']');
        return sb.toString();
    }

    private void printNull() {
        sb.append("null,");
    }

    private void addNull(int nullNum) {
        while (nullNum > 0) {
            queue.addLast(null);
            nullNum--;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.length() == 2) return null;
        int index = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        TreeNode head = root;
        boolean isLeft = false;
        while (index < data.length() - 2) {
            String next = getNext(data, index);
            index += next.length() + 1;
            TreeNode node;
            if (!"null".equals(next)) {
                node = new TreeNode(Integer.parseInt(next));
                queue.addLast(node);
            }else node = null;
            if (isLeft) {
                root.left = node;
            }
            else {
                root.right = node;
                root = queue.removeFirst();
            }
            isLeft = !isLeft;
        }
        return head.right;
    }

    private String getNext(String data, int index) {
        index += 1;
        int offset = 0;
        while (offset + index < data.length()) {
            if (data.charAt(index + offset) == ',' || data.charAt(index + offset) == ']') break;
            offset++;
        }
        return data.substring(index, index + offset);
    }
}
