//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2038 👎 0


package leetcode.editor.cn;

public class ReverseIntegerTest {

    public static void main(String[] args) {
        System.out.println(new ReverseIntegerTest().new Solution().reverse(123));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long l = 0;
            int symbol = 1;
            if (x < 0) {
                symbol = -1;
                x = -x;
            }
            char[] chars = String.valueOf(x).toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                l = l * 10 + (chars[chars.length - 1 - i] - '0');
                chars[chars.length - 1 - i] = chars[i];
            }
            for (int i = chars.length / 2; i < chars.length; i++) {
                l = l * 10 + (chars[chars.length - 1 - i] - '0');
            }
            l = l * symbol;
            if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}