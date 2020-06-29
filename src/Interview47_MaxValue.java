import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/28 16:46
 * @description:
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次 向右 或者 向下 移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 *
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * 思路: 简单的动态规划, 逐行更新每个位置能得到的最大价值, 初始化一个长度为 column + 1的全零数组, 转移方程为
 *              dp[j + 1] = Math.max(dp[j], dp[j + 1]) + grid[i][j]
 */
public class Interview47_MaxValue {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols + 1];
        Arrays.fill(dp, 0);
        for (int[] ints : grid) {
            for (int j = 0; j < cols; j++) {
                dp[j + 1] = Math.max(dp[j], dp[j + 1]) + ints[j];
            }
        }
        return dp[cols];
    }
}
