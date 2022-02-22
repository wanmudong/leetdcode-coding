package 宫水三叶.经典面试.公平的糖果交换;

/**
 * @author chenjiehao
 * @create 2022-02-21
 */
public class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // 计算分别拥有的糖果数
        int sub = 0;
        int [] n = new int[100001];
        for (int i = 0; i < aliceSizes.length; i++) {
            sub += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            n[bobSizes[i]] = 1;
            sub -= bobSizes[i];
        }

        sub /= 2;
        int [] ans = new int[2];
        for (int i = 0; i < aliceSizes.length; i++) {
            int j = aliceSizes[i] - sub;
            if (j >= 1 && j <= 100000 &&n[j] ==1){
                ans[0] = aliceSizes[i];
                ans[1] = j;
                break;
            }
        }

        return ans;
    }
}
