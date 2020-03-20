//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIiTest {

    public static void main(String[] args) {
        System.out.println(new IntersectionOfTwoArraysIiTest().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间复杂度 O(m+n) 空间复杂度 O(min(m,n)) 对较小的数组进行哈希映射使用的空间
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : nums1) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            int k = 0;
            for (int a : nums2) {
                int c = map.getOrDefault(a, 0);
                if (c > 0) {
                    map.put(a, c - 1);
                    nums1[k++] = a;
                }
            }
            return Arrays.copyOf(nums1, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}