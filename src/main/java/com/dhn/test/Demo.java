package com.dhn.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/13 17:41
 */
public class Demo {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                Integer value = map.get(arr[i])+1;
                map.put(arr[i],value);
            }else{
                map.put(arr[i],1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(set.contains(entry.getValue())){
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        Demo demo = new Demo();
        demo.uniqueOccurrences(arr);
    }
}
