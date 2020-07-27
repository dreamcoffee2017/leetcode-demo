package leetcode.easy;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (50.09%)
 * Likes:    1154
 * Dislikes: 0
 * Total Accepted:    248.4K
 * Total Submissions: 496K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */
class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().new Solution().climbStairs(44));
    }

    // @lc code=start
    class Solution {
        public int climbStairs(int n) {
            // 第一种全是1
            int sum = 1;
            // 2的个数
            int n2 = 0;
            while (n - 2 >= 0) {
                n = n - 2;
                n2++;
                int min = Math.min(n, n2);
                if (min == 0) {
                    sum++;
                } else {
                    // n个1，n2个2，排列组合 n*(n-1)...(n-m+1)/(m*(m-1)...1)
                    double x = 1, y = 1;
                    for (int i = 0; i < min; i++) {
                        x *= n + n2 - i;
                        y *= min - i;
                    }
                    sum += x / y;
                }
            }
            return sum;
        }
    }
    // @lc code=end
}
