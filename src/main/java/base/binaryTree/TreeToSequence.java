package base.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * <p>
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 *
 * @Author: Jeremy
 * @Date: 2019/6/5 15:57
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }

        int[][] res = new int[3][];
        res[0] = preOrderTraverseNoRecursion(root);
        res[1] = inOrderTraverseNoRecursion(root);
        res[2] = postOrderTraverseNoRecursion(root);
        res[2] = postOrderTraverseNoRecursion2(root);
        return res;
    }

    public int[][] convert2(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        preOrderTraverse(root, list1);
        System.out.println(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        inOrderTraverse(root, list2);
        System.out.println(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        postOrderTraverse(root, list3);
        System.out.println(list3);

        int[][] res = new int[3][list1.size()];
        for (int j = 0; j < list1.size(); j++) {
            res[0][j] = list1.get(j);
        }
        for (int j = 0; j < list1.size(); j++) {
            res[1][j] = list2.get(j);
        }
        for (int j = 0; j < list1.size(); j++) {
            res[2][j] = list3.get(j);
        }
        return res;
    }

    /**
     * 1. 将头结点入栈
     * 2. 每次弹出栈顶结点current，存储current结点的值；
     * 3. 如果current右孩子不为空，将其入栈；
     * 4. 然后如果current左孩子不为空，将其入栈；
     * 5. 不断重复2-4直到stack为空
     *
     * @param root
     */
    public int[] preOrderTraverseNoRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            list.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 1. 先把current结点入栈，对以current结点为头的整个子树来说，依次把整棵树的左边界入栈，
     * 即不断地使current=current.left,然后重复步骤1;
     * 2. 重复步骤1，如果current为空，则从stack中弹出一个结点node，保存node的值，并让current = node.right，
     * 重复步骤1；
     * 3. 当栈为空并且current也为空，整个过程结束；
     * @param root
     */
    public int[] inOrderTraverseNoRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else{
                TreeNode top = stack.pop();
                list.add(top.val);
                cur = top.right;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 1. 先将头结点压入栈1。
     * 2. 弹出栈1的栈顶节点，并将该节点压入栈2，并且：
     * （1）如果该节点的左节点不为空，则将该节点的左节点压入栈1。
     * （2）如果该节点的右节点不为空，则将噶节点的右节点压入栈1。
     * 3. 一直重复步骤2，直到栈1为空，停止；
     * 4. 不断弹出栈2的栈顶节点保存至列表，直到栈2为空。
     * @param root
     */
    public int[] postOrderTraverseNoRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = root;
        stack1.push(cur);

        while (!stack1.isEmpty()) {
            TreeNode top = stack1.pop();
            stack2.push(top);
            if (top.left != null) {
                stack1.push(top.left);
            }
            if (top.right != null) {
                stack1.push(top.right);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 1. 先将头结点压入栈，设置变量h和c,h表示最近一次弹出并存储的结点，c表示当前栈的栈顶结点；
     * 初始时，h为头结点，c为null；
     * 2. 每次令c等于当前stack的栈顶结点，但是不从stack弹出结点，此时有三种情况：
     * （1）如果c的左孩子不为空，并且h不等于c的左孩子，也不等于c的右孩子，则把c的左孩子入栈；
     * （2）如果1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则把c的右孩子压入栈；
     * （3）如果1和2都不成立，那么从stack中弹出c并打印，然后令h等于c;
     * 3. 一直重复步骤2，直到stack为空，停止；
     * @param root
     */
    public int[] postOrderTraverseNoRecursion2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode h = root;
        TreeNode c = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right){
                stack.push(c.left);
            } else if (c.right != null && h != c.right){
                stack.push(c.right);
            } else {
                list.add(stack.pop().val);
                h = c;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void preOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrderTraverse(root.left, list);
        preOrderTraverse(root.right, list);
    }

    public void inOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

    public void postOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left, list);
        postOrderTraverse(root.right, list);
        list.add(root.val);
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

        TreeToSequence treeToSequence = new TreeToSequence();
        int[][] res = treeToSequence.convert(root);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

        System.out.println();

        int[][] res1 = treeToSequence.convert2(root);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(Arrays.toString(res1[i]));
        }
    }
}
