package leetcode.easy;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (38.47%)
 * Likes:    1175
 * Dislikes: 0
 * Total Accepted:    316.1K
 * Total Submissions: 821.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len > 0) {
            String f = strs[0];
            int end = 0;
            for (int i = 0; i < f.length(); i++) {
                for (int j = 1; j < len; j++) {
                    String s = strs[j];
                    if (i == s.length() || s.charAt(i) != f.charAt(i)) {
                        return f.substring(0, end);
                    }
                }
                end++;
            }
            return f.substring(0, end);
        }
        return "";
    }
}
// @lc code=end
