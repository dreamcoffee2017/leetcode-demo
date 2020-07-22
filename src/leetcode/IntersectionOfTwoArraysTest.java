//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArraysTest {

    public static void main(String[] args) {
        int[][][] t = {
                {{1, 2, 2, 1}, {2, 2}}
                , {{4, 9, 5}, {9, 4, 9, 8, 4}}
        };
        Solution solution = new IntersectionOfTwoArraysTest().new Solution();
        for (int[][] a : t) {
            System.out.println(Arrays.toString(solution.intersection(a[0], a[1])));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Object o = new Object();
            HashMap<Integer, Object> map = new HashMap<>();
            for (int a : nums1) {
                map.put(a, o);
            }
            HashSet<Integer> set = new HashSet<>();
            for (int a : nums2) {
                if (map.containsKey(a)) {
                    set.add(a);
                }
            }
            int[] y = new int[set.size()];
            Iterator<Integer> it = set.iterator();
            int i = 0;
            while (it.hasNext()) {
                y[i++] = it.next();
            }
            return y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}