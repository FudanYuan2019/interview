package base.binaryTree;

/**
 * 首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，初始时str等于空字符串。
 * 先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，
 * “#”表示这个节点为空，节点值不存在，当然你也可以用其他的特殊字符，
 * “!”表示一个值的结束。如果遇到不为空的节点，假设节点值为3，
 * 就在str的末尾加上“3!”。现在请你实现树的先序序列化。
 *
 * 给定树的根结点root，请返回二叉树序列化后的字符串。
 *
 * 测试样例：
 *
 * @Author: Jeremy
 * @Date: 2019/6/5 18:09
 */
public class TreeToString {
    public String toString(TreeNode root) {
        // write code here
        StringBuffer str = new StringBuffer();
        serialize(root, str);
        return str.toString();
    }

    public void serialize(TreeNode root, StringBuffer string){
        if (root == null){
            string.append("#!");
            return;
        }
        string.append(String.valueOf(root.val)+"!");
        serialize(root.left, string);
        serialize(root.right, string);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(3);
        TreeNode left_21 = new TreeNode(4);
        TreeNode left_22 = new TreeNode(5);
        TreeNode right_22 = new TreeNode(6);

        root.left = left_1;
        root.right = right_1;

        left_1.left = left_21;

        right_1.left = left_22;
        right_1.right = right_22;

        TreeToString treeToString = new TreeToString();
        String res = treeToString.toString(root);
        System.out.println(res);
    }
}
