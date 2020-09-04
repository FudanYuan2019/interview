package base.binaryTree;

import java.util.*;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * <top>
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，
 * 所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 *
 * @Author: Jeremy
 * @Date: 2019/6/5 17:04
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        List<Integer> tmp = new ArrayList<>();
        TreeNode last = root;
        TreeNode nLast = null;

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            tmp.add(top.val);
            if (top.left != null) {
                queue.add(top.left);
                nLast = top.left;
            }
            if (top.right != null) {
                queue.add(top.right);
                nLast = top.right;
            }

            // 当last == top时代表该换行了
            if (last == top) {
                last = nLast;
                list.add(tmp);
                tmp = new ArrayList<>();
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
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

        TreePrinter treePrinter = new TreePrinter();
        int[][] res = treePrinter.printTree(root);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
