package hot100;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePath {
    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        uniquePath.uniquePaths(7,3);
    }

    /**
     * 传统dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i<=0 || j <= 0){
                    dp[i][j]  = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 优化dp
     *
     * 当前坐标的值只和左边与上面的值有关，和其他的无关，这样二维数组造成大量的空间浪费，所以我们可以把它改为一维数组
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int [] dp = new int [n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= 0){
                    dp[j]  = 1;
                }else {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

    /**
     * 排列组合
     *
     * 我们要想到达终点，需要往下走n-1步，往右走m-1步，总共需要走n+m-2步。
     * 他无论往右走还是往下走他的总的步数是不会变的。也就相当于总共要走n+m-2步，
     * 往右走m-1步总共有多少种走法，
     * 很明显这就是一个排列组合问题
     * C(m-1,m+n-2)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
