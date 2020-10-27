package com.xinzhe.categories.solutions.dp.hard;

/**
 * @author Xin
 * @date 2020/10/26
 * Title : 375. 猜数字大小 II
 * Description : 我们正在玩一个猜数游戏，游戏规则如下：我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 *               然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 * link : https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
 * Level : Medium
 */

//todo need to review
public class Leetcode375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        for(int i =n; i>= 1; i--) {
            for(int j=i; j<=n; j++) {
                if(i != j) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int x=i; x<=j; x++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][x-1], dp[x+1][j]) + x);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
