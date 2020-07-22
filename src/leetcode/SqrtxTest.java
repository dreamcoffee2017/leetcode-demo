//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 447 👎 0


package leetcode;

public class SqrtxTest {

    public static void main(String[] args) {
        System.out.println(new SqrtxTest().new Solution().mySqrt(36));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            return (int) two(1, x, x);
        }

        private long two(long l, long h, int x) {
            long m = (l + h) / 2;
            long pow = (long) Math.pow(m, 2);
            if (pow > x) {
                h = m;
                return two(l, h, x);
            } else if (pow < x && l < m) {
                l = m;
                return two(l, h, x);
            }
            return m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}