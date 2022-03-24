package 代码随想录.数组.螺旋矩阵二;

/**
 * @author chenjiehao
 * @create 2022-03-21
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateMatrix(4);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int a = -1;
        int b = -1;
        int sub = n;
        for (int i = 1; i <= n * n; ) {
            a = a+1;
            b = b+1;
            if (sub == 1) {
                res[a][b] = i;
                break;
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < sub - 1; k++) {
                    int i1 = k + i;
                    if (j == 0) {
                        res[a][b++] = i1;
                    }
                    if (j == 1) {
                        res[a++][b] = i1;
                    }
                    if (j == 2) {
                        res[a][b--] = i1;
                    }
                    if (j == 3) {
                        res[a--][b] = i1;
                    }

                }
                i = i + sub - 1;
            }
            sub-=2;
        }

        return res;
    }
}
