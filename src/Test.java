/**
 * @Author: TJC
 * @Date: 2020/6/26 16:21
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
        /*int[] preorder = new int[] {3, 9, 20, 15, 7};
        int[] inorder = new int[] {9, 3, 15, 20, 7};
        Interview07_BuildTree buildTree = new Interview07_BuildTree();
        buildTree.buildTree(preorder, inorder);*/

        /*Interview12_hasPath hasPath = new Interview12_hasPath();
        char[][] board = new char[][] {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        hasPath.exist(board, word);*/

        /*int mod = 1000000007;
        int x = (1000000005 * 1000000005) % mod;
        System.out.println(x);*/

        String s = "bbbba";
        String p = ".*a*a";
        Interview19_RegexMatch regexMatch = new Interview19_RegexMatch();
        regexMatch.isMatch(s, p);
    }
}
