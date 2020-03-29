package com.dhn.leetcode.hash.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/27 9:42
 */
public class Test1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:给定 nums = [2, 7, 11, 15], target = 9.因为 nums[0] + nums[1] = 2 + 7 = 9.所以返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target){
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//            }
//        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("不存在");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        Test1 test1 = new Test1();
        System.out.println(Arrays.toString(test1.twoSum(nums,target)));
    }
}
