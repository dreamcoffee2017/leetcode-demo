package leetcode.easy;

import node.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (50.86%)
 * Likes:    389
 * Dislikes: 0
 * Total Accepted:    119.3K
 * Total Submissions: 234.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 
 */
class HasPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new HasPathSum().new Solution().hasPathSum(root, 1));
    }

    // @lc code=start
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return next(root, 0, sum);
        }

        private boolean next(TreeNode cur, int h, int sum) {
            if (cur != null) {
                h += cur.val;
                if (cur.left == null && cur.right == null) {
                    return h == sum;
                } else {
                    return next(cur.left, h, sum) || next(cur.right, h, sum);
                }
            }
            return false;
        }
    }
    // @lc code=end
}
