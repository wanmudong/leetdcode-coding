package 慢慢刷.二叉树.验证二叉树的前序序列化;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
      int n = preorder.length();
      int i = 0;
      int num = 1;
      while (i<n){
          if (num == 0){
              return false;
          }
          if (',' == preorder.charAt(i)){
              i++;
          }else if ('#' == preorder.charAt(i)){
              i++;
              num--;
          }else {
              while (i<n && ',' != preorder.charAt(i)){
                  i++;
              }
              num++;
          }
      }
      return num == 0;
    }
}
