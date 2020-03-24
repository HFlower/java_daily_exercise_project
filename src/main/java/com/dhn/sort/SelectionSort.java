package com.dhn.sort;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: Dong HuaNan
 * @date: 2020/3/23 16:02
 */
public class SelectionSort {

    /**
     * 把待排数组分为已排序区间和未排序区间。每次从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     * 1.时间复杂度O(n^2)
     * 2.空间复杂度O(1)，所以为原地排序算法
     * 3.不稳定 如[3,6,3,1,5]
     * @param arr
     */
    public static void selectSort(int[] arr){

        //最开始除第一个元素外为未排序区间
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            //遍历未排序区间，注意j的初始值，j比i大1
            for (int j = min + 1; j < arr.length; j++) {
                //找出未排序区间的最小值的下标
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            //最小值下标不等于i,交换元素位置
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,2,6,1,4};
        SelectionSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
