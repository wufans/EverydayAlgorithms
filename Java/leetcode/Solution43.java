package leetcode;

/**
 * @Author: wufan
 * @Date: 2019/1/25 9:25
 * @Version 1.0
 */

/*
* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/
public class Solution43 {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    //solution2
    public String multiply2(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = len1 + len2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = product.length - 1; i > 0; i--) {
            if (stringBuilder.length() == 0 && product[i] == 0)
                continue;
            stringBuilder.append(product[i]);
        }
        stringBuilder.append(product[0]);
        return stringBuilder.toString();
    }
    //fastest solution
    public String multiply3(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int[] temp = new int[a.length+b.length+1];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j<b.length;j++){
                int aCur = a[a.length-1-i]-'0';
                int bCur = b[b.length-1-j]-'0';
                int product = aCur*bCur;
                temp[i+j] += product;
            }
        }
        StringBuilder sb = new StringBuilder();
        int lastNonZero = -1;
        for(int i = temp.length-1; i >= 0;i--){
            if(temp[i] > 0){
                lastNonZero = i;
                break;
            }
        }
        if(lastNonZero == -1) return "0";
        int carry = 0;
        for(int i = 0; i < temp.length; i++){
            if(i >= lastNonZero && temp[i] == 0 && carry == 0) break;
            int sum = temp[i] + carry;
            int cur = sum%10;
            carry = sum/10;
            sb.insert(0,(char)('0'+cur));
        }
        return sb.toString();
    }
}
