package com.dhn.leetcode.sort.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/26 14:30
 */
public class Test3 {
    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        //重写比较器
        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                String s1 = n1 + "" + n2;
                String s2 = n2 + "" + n1;
                return s2.compareTo(s1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(n[i]);
        }
        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }

    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        Test3 test3 = new Test3();
        System.out.println(test3.largestNumber(a));
    }
}
