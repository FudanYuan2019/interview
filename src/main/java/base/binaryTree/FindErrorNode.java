package base.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
 * 保证二叉树中结点的值各不相同。
 * <p>
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 *
 * @Author: Jeremy
 * @Date: 2019/6/8 16:04
 *
 * 解题思路：中序遍历树，结果中第一次降序错的是大数,；第二次降序错的是小数；
 */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                list.add(top.val);
                cur = top.right;
            }
        }

        int[] res = new int[list.size()];
        int miss1 = 0;
        int miss2 = 0;
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        for (int i = 1; i < res.length - 1; i++) {
            if(res[i] < res[i-1]){
                miss1 = res[i-1];
                break;
            }
        }
        for (int i = res.length - 1; i > 0; i--) {
            if(res[i] < res[i-1]){
                miss2 = res[i];
                break;
            }
        }
        int[] result = new int[2];
        result[0] = miss2;
        result[1] = miss1;
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode left_1 = new TreeNode(3);
        TreeNode right_1 = new TreeNode(6);
        TreeNode left_21 = new TreeNode(2);
        TreeNode left_22 = new TreeNode(5);
        TreeNode right_22 = new TreeNode(7);

        root.left = left_1;
        root.right = right_1;

        left_1.left = left_21;

        right_1.left = left_22;
        right_1.right = right_22;

        FindErrorNode findErrorNode = new FindErrorNode();
        int[] res = findErrorNode.findError(root);
        System.out.println(Arrays.toString(res));
    }
}
