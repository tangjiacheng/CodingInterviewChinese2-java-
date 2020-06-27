/**
 * @Author: TJC
 * @Date: 2020/6/27 14:47
 * @description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 思路: 将矩阵拆分为一个个的环, 环的起点为 matrix[i][i] , 在每个环中每次按照 右 -> 下 -> 左 -> 上 的顺序依次打印环内
 *       的元素. 要注意执行这四步打印需要满足的条件:
 *          第一步: 无论什么情况都执行
 *          第二步: 只有当 最大的行 > 起始坐标 才执行
 *          第三步: 在第二步的基础上, 当 最大的列 > 起始坐标 才执行
 *          第四步: 在第三步的基础上, 当 最大的行 - 1 > 起始坐标 才执行
 */
public class Interview29_PrintMatrixClockwisely {
    private int[] res;
    private int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[0];
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        res = new int[row * column];
        while (column > 2 * start && row > 2 * start) {
            printCycle(matrix, row, column, start);
            start++;
        }
        return res;
    }

    private void printCycle(int[][] matrix, int row, int column, int start) {
        int maxRow = row - start - 1;
        int maxColumn = column - start - 1;
        for (int i = start; i <= maxColumn; i++) {
            res[index++] = matrix[start][i];
        }
        if (start < maxRow) {
            for (int i = start + 1; i <= maxRow; i++) {
                res[index++] = matrix[i][maxColumn];
            }
            if (start < maxColumn) {
                for (int i = maxColumn - 1; i >= start; i--) {
                    res[index++] = matrix[maxRow][i];
                }
                if (start < maxRow - 1) {
                    for (int i = maxRow - 1; i > start; i--) {
                        res[index++] = matrix[i][start];
                    }
                }
            }
        }
    }

    /*public int[] spiralOrder(int[][] matrix) {

        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int column = matrix[0].length;
        if (column == 0) {
            return new int[0];
        }
        int[] res = new int[row * column];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] flags = new boolean[row][column];
        int direction = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < column * row; i++) {
            res[i] = matrix[x][y];
            flags[x][y] = true;
            int nextX = x + directions[direction][0];
            int nextY = y + directions[direction][1];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= column || flags[nextX][nextY]) {
                direction = (direction + 1) % 4;
            }
            x = x + directions[direction][0];
            y = y + directions[direction][1];
        }
        return res;
    }*/
}
