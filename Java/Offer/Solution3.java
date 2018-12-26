public class Solution3 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /*
    要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。牛客网讨论区这一题的首票答案使用 nums[i] + length 来将元素标记，这么做会有加法溢出问题。

这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上。
    * */
    //
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <=0){
            return false;
        }
        for(int i = 0;i < length;i++){
            while(numbers[i] != i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
                for (int j = 0; j < numbers.length; j++) {
                    System.out.print(numbers[j]+" ");
                }
                System.out.println();
                //break;
            }
        }
        return false;
    }
//    public boolean duplicate(int[] nums, int length, int[] duplication) {
//        if (nums == null || length <= 0){
//            return false;
//        }
//        for (int i = 0; i < length; i++) {
//            while (nums[i] != i) {
//                if (nums[i] == nums[nums[i]]) {
//                    duplication[0] = nums[i];
//                    return true;
//                }
//                swap(nums, i, nums[i]);
//            }
//        }
//        return false;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] a = new int[2];
        System.out.println(duplicate(numbers,7,a));
}
}
