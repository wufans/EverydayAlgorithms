/**
 * @Author: WuFan
 * @Date: 2019/4/9 14:29
 */

package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
* Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"*/
public class Solution71 {
    public static void main(String[] args) {
        simplifyPath("/a//b////c/d//././/..");
        System.out.println((simplifyPath("/../")));
    }
    public static String simplifyPath(String path) {
        Stack<String> res = new Stack<>();
        String[] s = path.split("/");
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].replace(" ","");
            if(!s[i].equals("")){
                if(s[i].equals("..")){
                    if(!res.isEmpty()){
                        res.pop();
                    }
                }else if(s[i].equals(".")){
                }else{
                    res.push(s[i]);
                }
            }
        }
        String r = "";
        while(!res.isEmpty()){
            r ="/"+ res.pop()+r;
        }

        return r.equals("")?"/":r;
    }
    /**
     characters: `/`, `////`, `.`, `..`
     edge case:
     1. /../../ == /
     2. ending / need to be removed
     3. `...` need to be preserved
     4. `/..hidden` need to be preserved
     **/
    //beats 100% solution
    public String simplifyPath2(String path) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<path.length();) {
            char c = path.charAt(i);
            if (c == '/') {
                if (sb.length() == 0 || sb.charAt(sb.length()-1) != '/') sb.append(c); // ignore duplicate '/'
                i++;
            } else if (c == '.') {
                int count = 0;
                while (i < path.length() && path.charAt(i) == '.') {
                    count++;
                    i++;
                }
                if (i == path.length() || path.charAt(i) == '/') {
                    if (count == 1) continue;
                    else if (count == 2) back(sb);
                    else
                        for (int k=0; k<count; k++) sb.append('.');
                } else {
                    for (int k=0; k<count; k++) sb.append('.');
                }
            } else {
                sb.append(c);
                i++;
            }
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private void back(StringBuilder sb) {
        if (sb.length() <= 1) return; // keep first char '/'

        do {
            sb.deleteCharAt(sb.length() - 1);
        } while (sb.length() > 1 && sb.charAt(sb.length() - 1) != '/');
    }
}
