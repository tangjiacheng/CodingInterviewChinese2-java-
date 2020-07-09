import utils.TreeNode;

import java.util.*;

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int nullNum = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(',');
                    if (node.left != null) {
                        addNull(queue, nullNum);
                        nullNum = 0;
                        queue.addLast(node.left);
                    } else nullNum++;
                    if (node.right != null) {
                        addNull(queue, nullNum);
                        nullNum = 0;
                        queue.addLast(node.right);
                    } else nullNum++;
                } else printNull(sb);
            }
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    private void printNull(StringBuilder sb) {
        sb.append("null,");
    }

    private void addNull(LinkedList<TreeNode> queue, int nullNum) {
        while (nullNum > 0) {
            queue.addLast(null);
            nullNum--;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 3)
            return null;
        List<Integer> list = loadNums(data);
        return bfs(list);
    }

    private int index = 0;

    private TreeNode bfs(List<Integer> list) {
        if (index >= list.size())
            return null;
        LinkedList<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(index++));
        deque.addLast(root);
        while (!deque.isEmpty() && index < list.size()) {
            TreeNode node = deque.removeFirst();
            if (index < list.size()) {
                Integer left = list.get(index);
                if (left != null) {
                    TreeNode leftSon = new TreeNode(left);
                    node.left = leftSon;
                    deque.addLast(leftSon);
                }
            }
            index++;
            if (index < list.size()) {
                Integer right = list.get(index);
                if (right != null) {
                    TreeNode rightSon = new TreeNode(right);
                    node.right = rightSon;
                    deque.addLast(rightSon);
                }
            }
            index++;
        }
        return root;
    }

    private List<Integer> loadNums(String data) {
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (index < data.length()) {
            int j = index;
            while (data.charAt(j) != ',' && data.charAt(j) != ']') {
                j++;
            }
            if (j > index) {
                if ("null".equals(data.substring(index, j))) {
                    list.add(null);
                } else
                    list.add(Integer.parseInt(data.substring(index, j)));
            }
            index = j + 1;
        }
        return list;
    }


    private TreeNode bfs2(List<Integer> list, int index) {
        if (index >= list.size())
            return null;
        Integer i = list.get(index);
        if (i == null)
            return null;
        TreeNode node = new TreeNode(list.get(index));
        node.left = bfs2(list, 2 * index + 1);
        node.right = bfs2(list, 2 * index + 2);
        return node;
    }

    public static void main(String[] args) {
        Interview37_Serialize serialize = new Interview37_Serialize();
        String data = "[5,2,3,null,null,2,4,3,1]";
        TreeNode root = serialize.deserialize(data);
        System.out.println(serialize.serialize(root));
    }
}
