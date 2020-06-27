/**
 * @Author: TJC
 * @Date: 2020/6/26 15:19
 * @description:
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 思路: 由于矩阵已经排序, 可以从右上角开始判断, 如果大于target, 则向左移动, 当遇到第一个小于target的数后, 向下判断, 直到找到一个大于等于target的数
 *       然后就可以开始遍历所有剩下的数字
 */
public class Interview04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0;
        int y = cols - 1;
        while (y >= 0 && matrix[x][y] > target) {
            y--;
        }
        if (y < 0) return false;
        while (x < rows && matrix[x][y] < target) {
            x++;
        }
        if (x >= rows) return false;
        for (int i = x; i < rows; i++) {
            for (int j = y; j >= 0; j--) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}
