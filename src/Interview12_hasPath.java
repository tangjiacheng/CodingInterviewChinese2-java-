/**
 * @Author: TJC
 * @Date: 2020/6/26 17:07
 * @description:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 思路: 回溯, 用一个boolean矩阵标记访问过的坐标, 当遍历到某个位置的值等于字符串的一个位置, 则将当前位置标记, 并递归的查看
 *       当前位置的上下左右是否与字符串的下一位置匹配, 如果都不能匹配, 则将当前位置的标记取消, 并返回false;
 */
public class Interview12_hasPath {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int index = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (hasPath(board, word, visited, index, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] board, String word, boolean[][] visited, int index, int x, int y) {
        if (index >= word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y > board[0].length) return false;
        if (visited[x][y] || board[x][y] != word.charAt(index)) return false;
        visited[x][y] = true;
        /*boolean flag = hasPath(board, word, visited, index + 1, x - 1, y)
                || hasPath(board, word, visited, index + 1, x + 1, y)
                || hasPath(board, word, visited, index + 1, x, y - 1)
                || hasPath(board, word, visited, index + 1, x, y + 1);*/
        if (hasPath(board, word, visited, index + 1, x - 1, y)
                || hasPath(board, word, visited, index + 1, x + 1, y)
                || hasPath(board, word, visited, index + 1, x, y - 1)
                || hasPath(board, word, visited, index + 1, x, y + 1)) {
            return true;
        }else {
            visited[x][y] = false;
            return false;
        }
        /*if (x > 0) {
            if (!visited[x - 1][y] && board[x - 1][y] == word.charAt(index)) {
                visited[x - 1][y] = true;
                boolean flag = hasPath(board, word, visited, index + 1, x - 1, y);
                if (flag) return true;
                visited[x - 1][y] = false;
            }
        }
        if (x < board.length - 1) {
            if (!visited[x + 1][y] && board[x + 1][y] == word.charAt(index)) {
                visited[x + 1][y] = true;
                boolean flag = hasPath(board, word, visited, index + 1, x + 1, y);
                if (flag) return true;
                visited[x + 1][y] = false;
            }
        }
        if (y > 0) {
            if (!visited[x][y - 1] && board[x][y - 1] == word.charAt(index)) {
                visited[x][y - 1] = true;
                boolean flag = hasPath(board, word, visited, index + 1, x, y - 1);
                if (flag) return true;
                visited[x][y - 1] = false;
            }
        }
        if (y < board[0].length - 1) {
            if (!visited[x][y + 1] && board[x][y + 1] == word.charAt(index)) {
                visited[x][y + 1] = true;
                boolean flag = hasPath(board, word, visited, index + 1, x, y + 1);
                if (flag) return true;
                visited[x][y + 1] = false;
            }
        }
        return false;*/
    }
}
