//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package leetcode.editor.cn;

import java.util.HashMap;

public class MajorityElementTest {

    public static void main(String[] args) {
        Solution solution = new MajorityElementTest().new Solution();
        int[][] t = {
                {3, 2, 3}
                , {2, 2, 1, 1, 1, 2, 2}
                , {1}
        };
        for (int[] a : t) {
            System.out.println(solution.majorityElement(a));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // n>0, c>n/2
        /*    HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int a : nums) {
                Integer v = map.get(a);
                v = v == null ? 0 : v;
                if (v + 1 > nums.length / 2)
                    return a;
                map.put(a, v + 1);
            }
            return 0;*/
            int res = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == res) {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        count = 1;
                        res = nums[i];
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}