package leetcode.easy;

/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (48.31%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    69.7K
 * Total Submissions: 144.2K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */
class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().new Solution().isPowerOfTwo(-16));
    }

    // @lc code=start
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0)
                return false;
            if (n == 1)
                return true;
            while (n / 2 > 0) {
                if (n % 2 > 0) {
                    return false;
                }
                n = n / 2;
                if (n == 1)
                    return true;
            }
            return n % 2 == 0;
        }
    }
    // @lc code=end
}
