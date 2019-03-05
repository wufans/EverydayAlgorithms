/**
 * @Author: WuFan
 * @Date: 2019/3/5 21:37
 */

package offer;
/*
* 二叉搜索树的后序遍历序列
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/
public class Solution33 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        if(sequence.length <=2){
            return true;
        }
        int root = sequence[sequence.length-1];
        int mid_index = sequence.length-1;
        for (int i = 0; i < sequence.length - 1; i++) {
            if(sequence[i]>root){
                mid_index = i;
                break;
            }
        }
        System.out.println(root);
        int [] left_sequence = new int[mid_index];
        int [] right_sequence = new int[sequence.length -1 -mid_index];
        for (int i = 0; i < sequence.length - 1; i++) {
            if(i<mid_index){
                left_sequence[i] = sequence[i];
            }
            else{
                if(sequence[i] < root)
                    return false;
                else
                    right_sequence[i-mid_index] = sequence[i];
            }
        }
        if(mid_index == sequence.length-1){
            return VerifySquenceOfBST(left_sequence);
        }else if(mid_index == 0){
            return VerifySquenceOfBST(right_sequence);
        }else
            return VerifySquenceOfBST(left_sequence) && VerifySquenceOfBST(right_sequence);
    }
/*
* 借助帮助函数，可以更加简洁。因为考虑到只有第一次中的长度为0的序列不是后序遍历的结果*/
    public boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }
    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal)
            cutIndex++;
        for (int i = cutIndex + 1; i < last; i++)
            if (sequence[i] < rootVal)
                return false;
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
    public static void main(String[] args) {

        System.out.println(VerifySquenceOfBST(new int[]{1,2,3,4,5}));;
    }

}
