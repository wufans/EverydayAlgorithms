/**
 * @Author: WuFan
 * @Date: 2019/3/6 21:34
 */

package offer;
/*
* 序列化二叉树
* 请实现两个函数，分别用来序列化和反序列化二叉树
*
* 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。

    序列化可以基于 先序、中序、后序、按层 的二叉树遍历方式来进行修改。原理都是一样的（即遍历顺序不同而已，对每个结点的处理都是一样的），
    序列化的结果是一个字符串，序列化时通过  某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
* */
public class Solution37 {

    private String deserializeStr;
    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }
    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }


    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.
                substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring
                (index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}
