package 代码随想录.动态规划.不同的二叉搜索树;

/**
 * @author chenjiehao
 * @create 2022-03-10
 */
public class Solution {
    /**
     * 二叉搜索树：节点大于左子节点，小于右子节点，中序遍历得到一个升序数组
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int [] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j  =1;j<=i;j++){
                g[i] +=g[j-1]*g[i-j];
            }
        }
        return g[n];
    }
}
