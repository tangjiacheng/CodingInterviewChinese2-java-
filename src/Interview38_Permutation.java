import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/6/28 10:08
 * @description:
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 思路: 将字符串看成 第一个字符 + 后面的字符串, 固定第一个字符后, 将后面的字符串又可以看成相同的情况, 从而通过递归解决
 */
public class Interview38_Permutation {
    private int length;
    private final Set<String> strings = new HashSet<>();


    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        length = s.length();
        char[] chars = s.toCharArray();
        arrangement(chars, 0);

        return strings.toArray(new String[0]);
    }

    private void arrangement(char[] chars, int start) {
        if (start == length - 1) strings.add(String.valueOf(chars));
        else {
            for (int i = start; i < length; i++) {
                swap(chars, start, i);
                arrangement(chars, start + 1);
                swap(chars, start, i);
            }
        }
    }

    private void swap(char[] chars, int begin, int end) {
        if (begin != end) {
            char ch = chars[begin];
            chars[begin] = chars[end];
            chars[end] = ch;
        }
    }
}
