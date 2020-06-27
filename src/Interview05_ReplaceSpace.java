/**
 * @Author: TJC
 * @Date: 2020/6/26 15:38
 * @description:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 思路: 1. 使用StringBuilder类, 依次复制String中的字符, 遇到空格则复制一个"%20"
 *       2. 遍历一遍String, 得到字符数, 然后从后往前依次复制
 */
public class Interview05_ReplaceSpace {
    public String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                count++;
            }
        }
        char[] newArray = new char[s.length() + 2 * count];
        int index_old = s.length() - 1;
        int index_new = s.length() + 2 * count - 1;
        while (index_old >= 0) {
            if (s.charAt(index_old) == ' ') {
                newArray[index_new--] = '0';
                newArray[index_new--] = '2';
                newArray[index_new--] = '%';
            } else {
                newArray[index_new--] = s.charAt(index_old);
            }
            index_old--;
        }
        return String.valueOf(newArray);
    }
}
