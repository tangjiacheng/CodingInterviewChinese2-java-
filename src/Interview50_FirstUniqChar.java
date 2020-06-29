/**
 * @Author: TJC
 * @Date: 2020/6/28 19:04
 * @description:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 思路: 用一个HashMap存储每个字符出现的次数, 然后再次遍历所有字符, 找到第一个次数为1的字符
 *       由于字符只包含小写字母, 可以用一个长度为26的数组代替hashMap
 */
public class Interview50_FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (map[c - 'a'] == 1)
                return c;
        }
        return ' ';
    }
}
