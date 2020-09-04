package base.binaryTree;

/**
 * @Author: Jeremy
 * @Date: 2018/10/8 21:37
 */

import java.util.*;

public class Printer {

    /**
     * 二叉树数据结构
     */
    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
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

        System.out.println("前序遍历，递归：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历，递归：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历，递归：");
        postOrderTraverse(root);
        System.out.println();

        System.out.println("前序遍历，非递归：");
        preOrderTraverseNoRecursion(root);

        System.out.println("中序遍历，非递归：");
        inOrderTraverseNoRecursion(root);

        System.out.println("后序遍历，非递归：");
        postOrderTraverseNoRecursion(root);

        System.out.println("层次遍历：");
        levelTraverse(root);

        System.out.println("按行打印：");
        printTreeByRow(root);

        printByRow(root);
    }

    /**
     * 先序遍历二叉树，递归
     * @param root
     */
    public static void preOrderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    /**
     * 中序遍历二叉树，递归
     * @param root
     */
    public static void inOrderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraverse(root.left);
        System.out.print(root.val + " ");
        inOrderTraverse(root.right);
    }

    /**
     * 后序遍历二叉树，递归
     * @param root
     */
    public static void postOrderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 先序遍历二叉树，非递归
     * @param root
     */
    public static void preOrderTraverseNoRecursion(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            if (currentNode.right != null){
                stack.push(currentNode.right);
            }
            if (currentNode.left != null){
                stack.push(currentNode.left);
            }
        }

        System.out.print("\n");
    }

    /**
     * 中序遍历二叉树，非递归
     * @param root
     */
    public static void inOrderTraverseNoRecursion(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()){
            // 一直循环到二叉树最左端的叶子结点（currentNode是null）
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
        System.out.print("\n");
    }

    /**
     * 后序遍历二叉树，非递归
     * @param root
     */
    public static void postOrderTraverseNoRecursion(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        TreeNode rightNode = null;
        while (currentNode != null || !stack.isEmpty()){
            // 一直循环到二叉树最左端的叶子结点（currentNode是null）
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            while (currentNode.right == null || currentNode.right == rightNode){
                System.out.print(currentNode.val + " ");
                rightNode = currentNode;
                if (stack.isEmpty()){
                    System.out.println();
                    return;
                }
                currentNode = stack.pop();
            }

            stack.push(currentNode);
            currentNode = currentNode.right;
        }
    }

    /**
     * 普通层次遍历
     * @param root
     */
    public static void levelTraverse(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.val + " ");
            if (currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        System.out.println();
    }

    /**
     * 层次遍历二叉树
     * 按行打印二叉树
     * 算法描述：
     * 1. 初始化：将根节点传入队列，last、nlast指针均指向根节点，其中，last指针指向当前行最右侧的元素，nlast指针指向下一行最右侧的元素
     * 2. 循环判断队列是否为空，如果不为空，则：
     *    2.1: 获取队列头元素p（将其在队列内删除）并打印
     *    2.2: 将该节点的左右子树分别压入队列，并更新nlast指针
     *    2.3: 判断last指针与p是否相等，如果相等，则换行，并且更新last = nlast
     * @param root
     * @return
     */
    public static int[][] printTreeByRow(TreeNode root){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode last = root;
        TreeNode nLast = null;
        ArrayList<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.print(p.val + " ");
            temp.add(p.val);

            if (p.left != null){
                queue.add(p.left);
                nLast = p.left;
            }
            if (p.right != null){
                queue.add(p.right);
                nLast = p.right;
            }

            if(last == p){
                ret.add(temp);
                last = nLast;
                temp = new ArrayList<>();
                System.out.print("\n");
            }
        }

        int[][] res = new int[ret.size()][];
        for (int i=0; i<ret.size(); i++){
            res[i] = new int[ret.get(i).size()];
            for (int j=0; j<ret.get(i).size(); j++){
                res[i][j] = ret.get(i).get(j);
            }
        }
        return res;
    }

    public static void printByRow(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        TreeNode last = root;
        TreeNode nLast = null;

        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.print(p.val + " ");

            if (p.left != null){
                queue.add(p.left);
                nLast = p.left;
            }
            if (p.right != null){
                queue.add(p.right);
                nLast = p.right;
            }

            // 当last == p时代表该换行了
            if(last == p){
                last = nLast;
                System.out.print("\n");
            }
        }
    }
}

