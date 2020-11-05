package com.xinzhe.contest.weekly.season05.weekly213;

/**
 * @author Xin
 * @date 2020/11/01
 * Title : 1643. 第 K 条最小指令
 * Description : Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。
 *              指令 用字符串表示，其中每个字符：'H' ，意味着水平向右移动'V' ，意味着竖直向下移动
 *              能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
 *              然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k 的编号 从 1 开始 。
 *              给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地destination 导航的 按字典序排列后的第 k 条最小指令 。
 * link : https://leetcode-cn.com/problems/kth-smallest-instructions
 * Level : Hard
 */
//todo too hard to solve
public class Leetcode_weekly_21304 {
    public static void main(String[] args) {
        Leetcode_weekly_21304 lc = new Leetcode_weekly_21304();
        int[] arr = {2,3};
        System.out.println(lc.kthSmallestPath(arr, 1));
        System.out.println("11".substring(1,1));
    }
    int[][] nCr;
    public String kthSmallestPath(int[] destination, int k) {
        nCr = new int[30][16];
        return dfs(destination[1], destination[0], k);
    }

    private String dfs(int H, int V, int k) {
        if (H == 0 && V == 0) return "";
        else if (H == 0) {
            return 'V'+ dfs(H, V - 1, k);
        } else if (V == 0) {
            return 'H' + dfs(H - 1, V, k);
        } else {
            int threshold = nCr(H - 1 + V, V);
            if (k <= threshold) {
               return 'H'+ dfs(H - 1, V, k);
            } else {
                return 'V' + dfs(H, V - 1, k - threshold);
            }
        }
    }

    private int nCr(int n, int r) {
        if (r == 0 || r == n) return 1;
        if (nCr[n][r] > 0) return nCr[n][r];
        return nCr[n][r] = nCr(n - 1, r) + nCr(n - 1, r - 1);
    }
}
