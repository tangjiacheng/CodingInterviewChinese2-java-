import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/6/28 16:56
 * @description:
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * 提示：
 * s.length <= 40000
 *
 * 思路: 动态规划. 用一个HashMap来保存每个字符最后出现的位置, 如果最后出现的位置与当前字符的距离小于等于以上一个字符为
 *       终点的最大长度, 则将当前字符的最大长度设为该距离, 反之则当前最大长度为上一个的长度 +1
 *       转移方程:
 *                  dp[i] = distance <= dp[i - 1] ? distance : dp[i - 1] + 1
 */
public class Interview48_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> locations = new HashMap<>();
        int len = 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int distance = i - locations.getOrDefault(ch, -1);
            if (distance <= len) {
                len = distance;
            } else {
                len = len + 1;
            }
            locations.put(ch, i);
            max = Math.max(max, len);
        }
        return max;
    }
}
