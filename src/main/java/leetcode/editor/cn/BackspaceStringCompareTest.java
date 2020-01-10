//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
// Related Topics 栈 双指针

package leetcode.editor.cn;

public class BackspaceStringCompareTest {

    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompareTest().new Solution();
        String S = "ab##", T = "c#d#";
        System.out.println(solution.backspaceCompare(S, T));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '#') {
                    if (s.length() > 0)
                        s.deleteCharAt(s.length() - 1);
                } else {
                    s.append(c);
                }
            }
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < T.length(); i++) {
                char c = T.charAt(i);
                if (c == '#') {
                    if (t.length() > 0)
                        t.deleteCharAt(t.length() - 1);
                } else {
                    t.append(c);
                }
            }
            return s.toString().equals(t.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}