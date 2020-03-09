package com.xinzhe.categories.dp;

/**
 * @Author Xin
 * @create 2020/3/9 21:23
 * Title : 53. 最大子序和
 * Description : 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * link : https://leetcode-cn.com/problems/maximum-subarray
 * Level : Easy
 */
public class Leetcode053 {
    public int maxSubArray(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i <n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
