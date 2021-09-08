/*
 * @lc app=leetcode.cn id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        // 升序排序
        // Collections.sort(list, (a,b)->a[0]-b[0]);
        list.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);
        int i = 0;
        while (k-- > 0) {
            // 每次决策前，将所有的启动资金不超过 w 的任务加入优先队列（根据利润排序的大根堆）
            while (i < n && list.get(i)[0] <= w) {
                queue.add(list.get(i++)[1]);
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
        }
        return w;
    }
}
// @lc code=end

