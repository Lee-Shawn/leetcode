/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        while (i <= j) {
            // 如果最轻的人和最重的人能坐一艘船，则他们同坐一艘船；如果不能，重的人独自坐一艘船
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            result++;
        }
        return result;
    }
}
// @lc code=end

