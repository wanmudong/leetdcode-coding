package 宫水三叶.经典面试.搜索旋转排序数组;

/**
 * @author chenjiehao
 * @create 2022-01-29
 */
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{4,5,6,7,8,1,2,3};
        Solution s = new Solution();
        System.out.println(s.search(arr,4));
        System.out.println(s.search(arr,5));
        System.out.println(s.search(arr,6));
        System.out.println(s.search(arr,7));
        System.out.println(s.search(arr,8));
        System.out.println(s.search(arr,1));
        System.out.println(s.search(arr,2));
        System.out.println(s.search(arr,3));
        System.out.println(s.search(arr,10));
        System.out.println(s.search(arr,-1));


        int [] arr1 = new int[]{4,5,6,7,0,1,2};
        System.out.println(s.search(arr1,4));
        System.out.println(s.search(arr1,5));
        System.out.println(s.search(arr1,6));
        System.out.println(s.search(arr1,7));
        System.out.println(s.search(arr1,0));
        System.out.println(s.search(arr1,1));
        System.out.println(s.search(arr1,2));
        System.out.println(s.search(arr1,10));
        System.out.println(s.search(arr1,-1));
    }
    public int search(int[] nums, int target) {
        int i = -1;
        // 最简单的方式,遍历
        i =  traverse(nums, target);

        // 从二分法的角度思考,反转后依旧是有序的两段.判断目标值与mid对应的值之间是否有序,有序则二分,无需则继续寻找有序的一段

        //

        i = binarySearch(nums, target);

        return i;
    }

    private int binarySearch(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while (left <= right){


            int mid = (left + right)/2;



            // 当前比目标值大
            if (nums[mid] > target){

                if (target >= nums[left] && nums[mid] >  nums[left] ){
                    right = mid - 1;
                    continue;
                }else if(target < nums[left] && nums[mid] <  nums[left] ){
                    right = mid - 1;
                    continue;
                }else {
                    left= mid + 1;
                    continue;
                }

            }

            // 当前比目标值小
            if (nums[mid] < target){

                if (target > nums[left] && nums[mid] >=  nums[left] ){
                    left = mid + 1;
                    continue;
                }else if(target < nums[left] && nums[mid] <  nums[left] ){
                    left = mid + 1;
                    continue;
                }else {
                    right = mid - 1;
                    continue;
                }
            }

            // 当前与目标值相同
            if (nums[mid] == target){
                return mid;
            }

        }

        return -1;
    }

    private int traverse(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }

        return -1;
    }


}