package com.dhn.sort;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: Dong HuaNan
 * @date: 2020/3/2 17:01
 */
public abstract class insertSort {

    /**
     * 1.从第二个元素开始遍历，称为未排序元素
     * 2.从未排序元素往前依次比较
     * 3.如果未排序元素<已排序元素
     * 4.已排序元素后移一位，未排序元素占据原来已排序元素的位置
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){

        //第一个算是已经排好序的，从第二个开始比较
        for (int i = 1;i<arr.length;i++){
            //当前数字
            int currentNum = arr[i];
            //从当前数字的上一个数字开始比较
            int j = i - 1;
            //如果当前数字<上一个数字
            while(j>=0 && currentNum < arr[j]){
                //上一个数字后移一位
                arr[j+1] = arr[j];
                //再比较上上一个数字
                j--;
            }
            //当前数字>上一个数字,上一个数字不动，上一个数字的下一个数字为当前数字
            arr[j+1] = currentNum;
        }

        return arr;

    }

    public static void main(String[] args) {
        int[] arr ={3,6,1,9,4,2,7,0};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));

    }
}
