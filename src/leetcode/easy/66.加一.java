package leetcode.easy;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (44.77%)
 * Likes:    505
 * Dislikes: 0
 * Total Accepted:    179K
 * Total Submissions: 399.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class 加一 {
    // @lc code=start
    class Solution {
        public int[] plusOne(int[] digits) {
            int next = 0, cur = 0;
            int len = digits.length;
            for (int i = len - 1; i >= 0; i--) {
                if (i == len - 1) {
                    cur = digits[i] + 1 + next;
                } else {
                    cur = digits[i] + next;
                }
                if (cur >= 10) {
                    cur = cur - 10;
                    next = 1;
                } else {
                    next = 0;
                }
                digits[i] = cur;
            }
            if (next == 0) {
                return digits;
            } else {
                int[] copy = new int[len + 1];
                copy[0] = next;
                System.arraycopy(digits, 0, copy, 1, len);
                return copy;
            }
        }
    }
    // @lc code=end
}
