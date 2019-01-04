/**
 * @Author: WuFan
 * @Date: 2019/1/4 22:22
 */

package offer;
/*
* 替换空格
*将一个字符串中的空格替换成 "%20"。

Input:
"We Are Happy"

Output:
"We%20Are%20Happy"

令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和
 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依
 次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
* */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 test = new Solution5();
        String a = test.replaceSpace(new StringBuffer("sjg dsklk jdlkg"));
        System.out.println(a);

    }
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() -1;
        for (int i = 0; i <= p1; i++) {
            // java中双引号表示的是String类型，而单引号表示的char类型
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() -1;
        while(p1>=0 && p2 >p1){
            char c = str.charAt(p1--);
            if(c==' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else{
                str.setCharAt(p2--,c);
            }
        }

        return str.toString();
    }
    public String replaceSpace2(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
