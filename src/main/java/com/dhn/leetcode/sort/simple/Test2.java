package com.dhn.leetcode.sort.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/26 11:10
 */
public class Test2 {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }
        ArrayList<Integer> arr = new ArrayList<>();

        for(int num : nums2)
        {
            if(set.contains(num))
            {
                arr.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++){
            res[i] = arr.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        int[] arr = test2.intersection(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }
}
