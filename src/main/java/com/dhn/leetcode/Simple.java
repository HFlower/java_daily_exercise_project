package com.dhn.leetcode;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/12 10:03
 */
public class Simple {
    /**
     * 17.04数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。在O(n)时间内完成
     * 示例 1:输入：[3,0,1] 输出：2
     * 示例 2：输入：[9,6,4,2,3,5,7,0,1] 输出：8
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        //运用异或 : 0^0=0; 0^1=1; 1^1=0; a^b^b=a;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            //先用0异或0~nums.length的下标
            res ^= i;
            //再异或元素，一个数字出现两次，异或后为0，而异或最终的结果值为出现一次的数，即为缺失的元素
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,6,4,2,3,5,7,0,1};
        Simple simple = new Simple();
        int num = simple.missingNumber(arr);

        System.out.println(num);
    }
}
