/**
 * @Author: WuFan
 * @Date: 2019/3/2 17:59
 */

package offer;
/*
* 正则表达式匹配
* 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一
个字符，而 '*' 表示它前面的字符可以出现任意次（ 包含 0 次） 。
    在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式
"a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。*/
public class Solution19 {

    /*
    * 设匹配递归函数 match(str, pattern)。
    如果模式匹配字符的下一个字符是‘*’:
    •如果pttern当前字符和str的当前字符匹配，：有以下三种可能情况
    （1）pttern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2)
    （2）pttern当前字符能匹配 str 中的 1 个字符：match(str+1, pattern+2)
    （3）pttern当前字符能匹配 str 中的 多 个字符：match(str+1, pattern)
     如果pttern当前字符和和str的当前字符不匹配
    pttern当前字符能匹配 str 中的 0 个字符：(str, pattern+2)
    如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
    对于 ‘.’ 的情况比较简单，’.’ 和一个字符匹配 match(str+1, pattern+1)
    另外需要注意的是：空字符串”” 和 “.*” 是匹配的
    public boolean match(char[] str, char[] pattern)
    {
              if(str==null||pattern==null) return false;

		return matchCore(str,0,pattern,0);
    }

	public boolean matchCore(char[] str,int s, char[] pattern,int p) {
		if(str.length<=s&&pattern.length<=p)
			return true;//都匹配完了
		if(str.length>s&&pattern.length<=p)
			return false;//模式完了，字符串还有
		//模式串a*a没结束，匹配串可结束可不结束

		if(p+1<pattern.length&&pattern[p+1]=='*'){//当前pattern的下一个是*号时

			//字符串完了
			if(s>=str.length) return matchCore(str, s, pattern, p+2);
			else{

			if(pattern[p]==str[s]||pattern[p]=='.'){
				//当前位置匹配完成，移动到下一个模式串
				return matchCore(str,s+1, pattern,p+2)
						||matchCore(str,s+1, pattern,p)
						||matchCore(str,s, pattern,p+2);
			}else
				return matchCore(str, s, pattern, p+2);
			}
		}
		//当前pattern的下一个不是*时候
		if(s>=str.length) return false;
		else{
		if(str[s]==pattern[p]||pattern[p]=='.')
			return matchCore(str, s+1, pattern, p+1);
		}
		return false;

*/

    //或者用动态规划的方法
    public boolean match(char[] str, char[] pattern){
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2]; // a* only countsas empty
        return dp[m][n];
    }
}
