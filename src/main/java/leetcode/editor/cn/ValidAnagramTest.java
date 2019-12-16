//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package leetcode.editor.cn;

public class ValidAnagramTest {

    public static void main(String[] args) {
        String[][] t = {
                {"anagram", "nagaram"}
                , {"rat", "car"}
        };
        Solution solution = new ValidAnagramTest().new Solution();
        for (String[] a : t) {
            System.out.println(solution.isAnagram(a[0], a[1]));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] S = new int[128];
            int[] T = new int[128];
            for (char c : s.toCharArray()) {
                S[c]++;
            }
            for (char c : t.toCharArray()) {
                T[c]++;
            }
            for (int i = 0; i < 128; i++) {
                if (S[i] != T[i])
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}