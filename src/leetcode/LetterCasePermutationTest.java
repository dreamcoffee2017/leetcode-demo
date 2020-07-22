//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
// 
//
// 注意： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationTest {

    public static void main(String[] args) {
//        System.out.println((char)('A'^32));
        Solution solution = new LetterCasePermutationTest().new Solution();
        System.out.println(solution.letterCasePermutation("ab"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String S) {
            List<String> res = new ArrayList<>();
            char[] chars = S.toCharArray();
            dfs(chars, 0, res);
            return res;
        }

        private void dfs(char[] chars, int u, List<String> res) {
            if (u == chars.length) {
                res.add(new String(chars));
                return;
            }
            dfs(chars, u + 1, res);
            if (chars[u] >= 'A') {
                chars[u] ^= 32;
                dfs(chars, u + 1, res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}