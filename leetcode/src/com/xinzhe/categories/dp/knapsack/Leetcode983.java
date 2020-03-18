package com.xinzhe.categories.dp.knapsack;

/**
 * @Author Xin
 * @create 2020/3/18 18:21
 * Title : 983. 最低票价
 * Description : 你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *          火车票有三种不同的销售方式：
 *              一张为期一天的通行证售价为 costs[0] 美元；
 *              一张为期七天的通行证售价为 costs[1] 美元；
 *              一张为期三十天的通行证售价为 costs[2] 美元。
 *              通行证允许数天无限制的旅行。
 *          例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
 *              第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *      返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * link : https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * Level : Medium
 */
public class Leetcode983 {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length < 1|| costs.length < 1) return 0;
        int[] dp = new int[days[days.length-1] + 1];
        for (int i : days) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            if(dp[i] == 0){
                dp[i] = dp[i-1];
                continue;
            }
            int num1 = dp[i-1] + costs[0];
            int num7 = i > 7 ? dp[i-7] + costs[1] :costs[1];
            int num30 = i > 30 ? dp[i-30] + costs[2] :costs[2];
            dp[i] = Math.min(num1, Math.min(num7, num30));
        }
        return dp[dp.length-1];
    }
}
