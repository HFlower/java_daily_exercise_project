package com.dhn.search;

import java.util.Arrays;

/**
 * @description: 二分查找
 * @author: Dong HuaNan
 * @date: 2020/3/18 15:04
 */
public class binarySearch {
    /**
     *1.寻找一个数（基本的二分查找）
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int low = 0;
        //搜索区间为[low,high]
        int high = nums.length - 1;
        //注意：为什么用low<=high？
        // while(left <= right)的终止条件是 left == right + 1，即区间为 [right + 1, right]，如 [3, 2]，这时候搜索区间为空，所以这时候 while 循环终止是正确的，直接返回 -1 即可。
        //while(left < right)的终止条件是 left == right，即区间为 [right, right]，如  [2, 2]，这时候搜索区间非空，但此时 while 循环终止了。索引 2 没有被搜索，如果这时候直接返回 -1 就可能出现错误。
        while (low <= high){
            int mid = (low + high)/2;
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 2.寻找左侧边界的二分搜索
     * 「左侧边界」可以理解为nums中小于target的元素有几个
     * @param nums
     * @param target
     * @return
     */
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target){
                //「搜索区间」是 [left, right),所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)。
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }
        }
        // target 比所有数都大
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 3.寻找右侧边界
     * @param nums
     * @param target
     * @return
     */
    public int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        //不存在target
        if (left == 0){
            return -1;
        }
        return nums[left-1] == target ? (left-1) : -1;
    }

    public static void main(String[] args) {
        int[] a = {0,1,3,5,6,8,9,12};
        binarySearch binarySearch = new binarySearch();
//        int result = binarySearch.binarySearch(a,2);
        int result = binarySearch.left_bound(a,8);
        System.out.println("target在数组中的位置：" + result);

    }
}
