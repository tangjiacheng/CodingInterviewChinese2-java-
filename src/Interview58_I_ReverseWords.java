/**
 * @Author: TJC
 * @Date: 2020/6/29 11:25
 * @description:
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 思路: 先整体反转, 再局部反转每一个单词
 *       python一行代码就搞定 气死个人!!!!
 *
 *       return ' '.join(s.strip().split()[::-1])
 */
public class Interview58_I_ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == ' ' && flag) {
                sb.append(c);
                flag = false;
            }
            if (c != ' ') {
                sb.append(c);
                flag = true;
            }
        }
        if (sb.length() == 0) return "";
        if (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
        char[] res = sb.toString().toCharArray();
        int length = res.length;
        int index = 0;
        while (index < length) {
            int endOfWord = index;
            while (endOfWord + 1 < length && res[endOfWord + 1] != ' ') {
                endOfWord++;
            }
            reversePart(res, index, endOfWord);
            index = endOfWord + 2;
        }
        return String.valueOf(res);
    }

    private void reversePart(char[] chars, int begin, int end) {
        while (begin < end) {
            char ch = chars[begin];
            chars[begin] = chars[end];
            chars[end] = ch;
            begin++;
            end--;
        }
    }
}
