//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class ValidParenthesesTest {

    public static void main(String[] args) {
        Solution solution = new ValidParenthesesTest().new Solution();
        String[] str = {
                ""
                , "(){"
                , "()[]{}"
                , "([{}])"
                , "[]{}([{}])[]{[]}{}"
                , "(("
        };
        for (String s : str) {
            System.out.println(s + "=>" + solution.isValid(s));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] CHARS1 = {'(', '[', '{'};
        char[] CHARS2 = {')', ']', '}'};

        public boolean isValid(String s) {
            if (s.isEmpty()) return true;
            int len = s.length();
            if (len % 2 == 1) return false;
            char[] chars = s.toCharArray();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                char c1 = chars[i];
                if (!stack.empty()) {
                    int index = Arrays.binarySearch(CHARS2, c1);
                    if (index == stack.peek()) {
                        stack.pop();
                        continue;
                    } else if (index > -1) {
                        return false;
                    }
                }
                int index = Arrays.binarySearch(CHARS1, c1);
                if (index < 0 || i == len - 1) return false;
                char c2 = chars[i + 1];
                if (c2 == CHARS2[index]) {
                    i++;
                } else {
                    stack.add(index);
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}