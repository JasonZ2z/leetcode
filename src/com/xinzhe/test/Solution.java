package com.xinzhe.test;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2};
        Solution so = new Solution();
        System.out.println(so.shortestSubarray(arr, 2));
    }
    public int shortestSubarray(int[] arr, int K) {
        int pre = 0;
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            pre = pre + arr[i];
            Map.Entry<Integer, Integer> entry = map.floorEntry(pre - K);
            if(entry != null ) {
                min = Math.min(min, i - entry.getValue());
            }
            while (map.size() > 0 && map.lastKey() > pre) map.pollLastEntry();
            map.put(pre, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
