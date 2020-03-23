package com.dhn.sort;
import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: Dong HuaNan
 * @date: 2020/3/23 9:33
 */
public class QuickSort {
    /**
     * 快速排序
     * 1.最好情况时间复杂度为O(nlogn)，最坏情况时间复杂度为O(n^2)，平均时间复杂度为O(nlogn)
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i , j ,pivot;
        if (low > high){
            return;
        }
        i = low;
        j = high;
        //选取最左边的点为基准点
        pivot = arr[low];
        while (i < j){
            //先从右往左遍历，j下标对应的值>基准点对应的值，则j继续往左走
            while (i < j && arr[j] > pivot){
                j--;
            }
            //j下标对应的值<基准点对应的值，则把此时j下标对应的值赋给i处的值，i再后移一位
            if (i < j){
                arr[i++] = arr[j];
            }
            //再从左往右遍历，i下标对应的值<基准点对应的值，则i继续往右走
            while (i < j && arr[i] < pivot){
                i++;
            }
            //i下标对应的值>基准点对应的值，则把此时i下标对应的值赋给j处的值，j再前移一位
            if (i < j){
                arr[j--] = arr[i];
            }
        }
        //当i==j时，跳出循环，把基准点归到i处，此时一次分区完成
        arr[i] = pivot;
        //递归，再分区基准点左边及右边
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }

    public static void main(String[] args) {
        int[] arr = {2,8,1,4,13,6,3,21,9,7,5,0};
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }


}
