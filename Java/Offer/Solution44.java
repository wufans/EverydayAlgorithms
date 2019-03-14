/**
 * @Author: WuFan
 * @Date: 2019/3/14 10:14
 */

package offer;
/*
* 数字序列中的某一位数字
* 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符
串的第 index 位。*/
public class Solution44 {
    public static int getDigitAtIndex(int index){
        if(index<0){
            return -1;
        }
        if(index<=10){
            return index-1;
        }
        int temp_max_index = 10;
        int bit = 1;
        while(index>temp_max_index + 9*(int)Math.pow(10,bit)*(bit+1)){
            temp_max_index += 9*(int)Math.pow(10,bit++)*bit;
        }
        int dis = index - temp_max_index -1;
        int start = (int)Math.pow(10,bit++);
        int number_add = dis/bit;
        char res = String.valueOf(start+number_add).toCharArray()[dis%bit];
        return res-48;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            System.out.print(getDigitAtIndex(i));
        }

    }
//solution3
    public int getDigitAtIndex2(int index) {
        if (index < 0)
            return -1;
        int place = 1; // 1 表示个位，2 表示 十位...
        while (true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount * place;
            if (index < totalAmount)
                return getDigitAtIndex(index, place);
            index -= totalAmount;
            place++;
        }
    }
    private int getAmountOfPlace(int place) {
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }
}
