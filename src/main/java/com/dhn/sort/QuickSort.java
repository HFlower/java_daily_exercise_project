package com.dhn.sort;
import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: Dong HuaNan
 * @date: 2020/3/23 9:33
 */
public class QuickSort {

    /**
     * 快速排序1
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort1(int[] arr, int low, int high) {
        int i , j ,pivot;
        if (low >= high){
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
        quickSort1(arr,low,i-1);
        quickSort1(arr,i+1,high);
    }


    /**
     * 快速排序2
     * 1.最好情况时间复杂度为O(nlogn)，最坏情况时间复杂度为O(n^2)，平均时间复杂度为O(nlogn)
     * 2.没有额外申请内存空间，空间复杂度为O(1),是原地排序算法
     * 3.不是稳定的排序算法，比如[1, 9, 1, 8, 9, 3, 7]，当j指向元素3时，i指向第一个9，此时i和j交换，第一个9会换到第二个9的后面，前后位置改变了
     *  （稳定性：一组数中相同的两个数，排序完成后前后位置保持不变）
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort2(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        //选取最右边的点为基准点
        int pivot = arr[high];
        //从左往右遍历
        int i = low;
        int j = low;
        while (j <= high){
            //当指针j位置的值比基准点小时，交换arr[i]和arr[j]
            if (arr[j] < pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        //j>high跳出循环，此时基准点仍处于最右侧，i的左边是比基准点小的元素，i及i右边是是除了基准点外都比基准点大的元素，交换基准点和i位置的元素，此时i左面都比基准点小，右面都比基准点大
        arr[high] = arr[i];
        arr[i] = pivot;
        ////递归，再分区基准点左边及右边
        quickSort2(arr,low,i-1);
        quickSort2(arr,i+1,high);
    }

    public static void main(String[] args) {
        int[] arr = {2,8,13,4,0,1,3,21,9,7,5,6};
//        QuickSort.quickSort1(arr,0,arr.length-1);
        QuickSort.quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
