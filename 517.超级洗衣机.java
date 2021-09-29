/*
 * @lc app=leetcode.cn id=517 lang=java
 *
 * [517] 超级洗衣机
 */

// @lc code=start
class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        // 求数组和
        int sum = Arrays.stream(machines).sum();
        // 不能平均就直接返回
        if(sum % n != 0) return -1;
        int ans = 0;
        // 求调整后的的大小
        int avg = sum / n;
        // 记录前面n个
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += machines[i];
            // 衣服最多的洗衣机最多需要移动max-avg次，前i个洗衣机需要移动sum-avg*i次
            // 前面n个需要转移的数量和最大值到平均值的差值取最大
            ans = Math.max(ans,Math.max(Math.abs(preSum-(i+1)*avg),machines[i] - avg));
        }
        return ans;
    }
}
// @lc code=end

