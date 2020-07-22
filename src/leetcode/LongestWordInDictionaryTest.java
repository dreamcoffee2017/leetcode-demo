//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入: 
//words = ["w","wo","wor","worl", "world"]
//输出: "world"
//解释: 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2: 
//
// 
//输入: 
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出: "apple"
//解释: 
//"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
// 
//
// 注意: 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表

package leetcode;

public class LongestWordInDictionaryTest {

    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryTest().new Solution();
        String[] t = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
        System.out.println(solution.longestWord(t));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        TrieNode node = new TrieNode();
        String y = "";

        public String longestWord(String[] words) {
            for (String s : words) {
                TrieNode cur = node;
                for (int i = 0; i < s.length(); i++) {
                    int pos = s.charAt(i) - 'a';
                    if (cur.children[pos] == null)
                        cur.children[pos] = new TrieNode();
                    cur = cur.children[pos];
                }
                cur.isWord = true;
                cur.str = s;
            }
            dfs(node);
            return y;
        }

        public void dfs(TrieNode cur) {
            if (cur.str.length() > y.length())
                y = cur.str;
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && cur.children[i].isWord)
                    dfs(cur.children[i]);
            }
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
            String str = "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}