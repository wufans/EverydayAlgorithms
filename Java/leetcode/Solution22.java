/**
 * @Author: WuFan
 * @Date: 2019/1/9 21:14
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
] */
public class Solution22 {
    //由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号3个，右括号3个，
    // 所以我们定义两个变量left和right分别表示剩余左右括号的个数，如果在某次递
    // 归时，左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于
    // 左括号的个数，即会出现')('这样的非法串，所以这种情况直接返回，不继续处理
    // 。如果left和right都为0，则说明此时生成的字符串已有3个左括号和3个右括号，
    // 且字符串合法，则存入结果中后返回。如果以上两种情况都不满足，若此时left大
    // 于0，则调用递归函数，注意参数的更新，若right大于0，则调用递归函数，同样要
    // 更新参数。代码如下：
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }
    void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
    }
    //这种方法是CareerCup书上给的方法，感觉也是满巧妙的一种方法，这种方法的
    // 思想是找左括号，每找到一个左括号，就在其后面加一个完整的括号，最后再在开头
    // 加一个()，就形成了所有的情况，需要注意的是，有时候会出现重复的情况，所以我
    // 们用set数据结构，好处是如果遇到重复项，不会加入到结果中，最后我们再把set转
    // 为vector即可

    public List<String> generateParenthesis2(int n) {
        Set<String> res = new HashSet<String>();
        if (n == 0) {
            res.add("");
        } else {
            List<String> pre = generateParenthesis(n - 1);
            for (String str : pre) {
                for (int i = 0; i < str.length(); ++i) {
                    if (str.charAt(i) == '(') {
                        str = str.substring(0, i + 1) + "()" + str.substring(i + 1, str.length());
                        res.add(str);
                        str = str.substring(0, i + 1) +  str.substring(i + 3, str.length());
                    }
                }
                res.add("()" + str);
            }
        }
        return new ArrayList(res);
    }
}
