/**
 * @Author: TJC
 * @Date: 2020/6/29 14:35
 * @description:
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * length <= 100000
 *
 * 思路: 定义数组int[] left; int[] right. 其中, left[i]表示所有小于 i 的元素的乘积, right[i]表示所有大于 i 的元素的乘积
 *       因此只需要遍历 i 并求出 left[i] * right[i]
 */
public class Interview66_ConstructArr {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        int length = a.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length];
        int mul = 1;
        for (int i = 0; i < length; i++) {
            left[i] = mul;
            mul *= a[i];
        }
        mul = 1;
        for (int i = length - 1; i >= 0; i--) {
            right[i] = mul;
            mul *= a[i];
        }
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
