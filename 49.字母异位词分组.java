/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 将字符串转换成字符数组再排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 排序后再转换成字符串作为map的key
            String key = String.valueOf(chars);
            // 如果map中没有这个key，就新建一个list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将原来的key添加到value中
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

