/**
 * @Author: TJC
 * @Date: 2020/6/26 19:25
 * @description:
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、
 * 上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入
 * 方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 思路: 回溯法, 将访问过的位置保存在visited中, 如果某个位置可以访问到, 则判断其周围的四个位置
 */
public class Interview13_MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return moving(0, 0, m, n, k, visited);
    }

    private int moving(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) return 0;
        visited[x][y] = true;
        if (getSum(x, y, k)) {
            return 1 + moving(x - 1, y, m, n, k, visited)
                     + moving(x + 1, y, m, n, k, visited)
                     + moving(x, y - 1, m, n, k, visited)
                     + moving(x, y + 1, m, n, k, visited);
        } else return 0;
    }

    private boolean getSum(int x, int y, int k) {
        int sum = 0;
        // 使用字符串的操作不好, 因为会创建很多新的字符串
        /*String str = "" + x + y;
        for (char ch : str.toCharArray()) {
            sum += ch - '0';
        }*/
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
