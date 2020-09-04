package base.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 自平衡AVL树：AVL树实现
 *
 * @Author: Jeremy
 * @Date: 2019/6/27 11:29
 */

class AVLNode extends TreeNode {
    int val;
    AVLNode left = null;
    AVLNode right = null;
    int height;

    public AVLNode(int val, int height) {
        super(val);
        this.val = val;
        this.height = height;
    }

    public AVLNode(int val) {
        this(val, 1);
    }

}

public class AVLTree {
    /**
     * 获取树高度
     *
     * @param root
     * @return
     */
    public int height(AVLNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * AVL树查找元素
     *
     * @param root AVL树的根节点
     * @param val  需要查找的目标值
     * @return
     */
    public AVLNode search(AVLNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return search(root.left, val);
        } else if (val > root.val) {
            return search(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * RR型：左旋
     *
     * @param root
     * @return
     */
    private AVLNode leftRotate(AVLNode root) {
        AVLNode node = root.right;
        root.right = node.left;
        node.left = root;
        root.height = height(root);
        node.height = height(node);
        return node;
    }

    /**
     * LL型：右旋
     *
     * @param root
     * @return
     */
    private AVLNode rightRotate(AVLNode root) {
        AVLNode node = root.left;
        root.left = node.right;
        node.right = root;
        root.height = height(root);
        node.height = height(node);
        return node;
    }

    /**
     * RL型：右旋-左旋
     *
     * @param root
     * @return
     */
    private AVLNode rightLeftRotate(AVLNode root) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    /**
     * LR型：左旋-右旋
     *
     * @param root
     * @return
     */
    private AVLNode leftRightRotate(AVLNode root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    /**
     * 增加新节点
     *
     * @param root AVL树的根节点
     * @param val  需要增加的目标值
     * @return
     */
    public AVLNode insert(AVLNode root, int val) {
        if (root == null) {
            root = new AVLNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
            if (height(root.left) - height(root.right) == 2) {
                // LL型
                if (root.left.val == val) {
                    root = rightLeftRotate(root);
                } else {  // LR型
                    root = leftRightRotate(root);
                }
            }
        } else if (val > root.val) {
            root.right = insert(root.right, val);
            if (height(root.right) - height(root.left) == 2) {
                // RR型
                if (root.right.val == val) {
                    root = leftRightRotate(root);
                } else {  // RL型
                    root = rightLeftRotate(root);
                }
            }
        }
        // 重新计算节点高度
        root.height = height(root);
        return root;
    }

    /**
     * 删除元素
     *
     * @param root
     * @param val
     * @return
     */
    public AVLNode delete(AVLNode root, int val) {
        if (root == null) {
            return null;
        }

        // 左子树查找该元素
        if (val < root.val) {
            root.left = delete(root.left, val);
            // 检查是否平衡
            if (height(root.right) - height(root.left) == 2) {
                AVLNode currentNode = root.right;
                if (height(currentNode.left) > height(currentNode.right)){
                    // LL型
                    root = rightRotate(root);
                } else {
                    // LR型
                    root = leftRightRotate(root);
                }
            }
        } else if (val > root.val) {
            // 右子树查找该元素
            root.right = delete(root.right, val);
            if (height(root.left) - height(root.right) == 2){
                AVLNode currentNode = root.left;
                if (height(currentNode.right) > height(currentNode.left)){
                    // RR型
                    root = leftRotate(root);
                } else {
                    // RL型
                    root = rightLeftRotate(root);
                }
            }
        } else {  // 找到该元素
            if (root.left != null && root.right != null) {
                // 使用前继节点替换该节点
                root.val = predecessor(root).val;
                root.left = delete(root.left, root.val);
            } else {  // 仅有一个孩子节点或者只是叶子节点
                root = root.left != null ? root.left : root.right;
            }
        }

        if (root != null){
            // 重新计算节点高度
            root.height = height(root);
        }
        return root;
    }

    /**
     * 最小节点
     * @param root
     * @return
     */
    public AVLNode min(AVLNode root){
        if (root == null){
            return null;
        }
        AVLNode currentNode = root;
        while (currentNode.left !=null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    /**
     * 最大节点
     * @param root
     * @return
     */
    public AVLNode max(AVLNode root){
        if (root == null){
            return null;
        }
        AVLNode currentNode = root;
        while (currentNode.right !=null){
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    /**
     * 寻找后继节点
     * @param root
     * @return
     */
    public AVLNode successor(AVLNode root){
        return min(root.right);
    }

    /**
     * 寻找前继节点
     * @param root
     * @return
     */
    public AVLNode predecessor(AVLNode root){
        return max(root.left);
    }

    /**
     * 中序遍历二叉树，非递归
     *
     * @param root
     */
    public void inOrderTraverseNoRecursion(AVLNode root) {
        LinkedList<AVLNode> stack = new LinkedList<>();
        AVLNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            // 一直循环到二叉树最左端的叶子结点（currentNode是null）
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + "(" + currentNode.height + ") ");
            currentNode = currentNode.right;
        }
        System.out.print("\n");
    }

    /**
     * 按行遍历二叉树
     *
     * @param root
     * @return
     */
    public int[][] printTreeByRow(AVLNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<AVLNode> queue = new LinkedList();
        queue.push(root);

        List<Integer> tmp = new ArrayList<>();
        AVLNode last = root;
        AVLNode nLast = null;

        while (!queue.isEmpty()) {
            AVLNode top = queue.poll();
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
        AVLTree avlTree = new AVLTree();
        // 构建AVL树
        AVLNode root = null;
        root = avlTree.insert(root, 8);
        root = avlTree.insert(root, 3);
        root = avlTree.insert(root, 10);
        root = avlTree.insert(root, 1);
        root = avlTree.insert(root, 6);
        root = avlTree.insert(root, 9);
        root = avlTree.insert(root, 14);
        root = avlTree.insert(root, 4);
        root = avlTree.insert(root, 7);
        root = avlTree.insert(root, 13);

        // 计算高度
        int height = avlTree.height(root);
        System.out.println(height);

        // 中序遍历
        avlTree.inOrderTraverseNoRecursion(root);

        // 查找
        AVLNode node = avlTree.search(root, 13);
        System.out.println(node.val);
        System.out.println(avlTree.height(node));

        // 插入13
        root = avlTree.insert(root, 13);
        int[][] res = avlTree.printTreeByRow(root);
        for (int j = 0; j < res.length; j++) {
            System.out.println(Arrays.toString(res[j]));
        }

        // 最小节点
        AVLNode minNode = avlTree.min(root);
        System.out.println("最小节点值： " + minNode.val);

        // 最大节点
        AVLNode maxNode = avlTree.max(root);
        System.out.println("最大节点值： " + maxNode.val);

        // 直接后继
        AVLNode successorNode = avlTree.successor(root);
        System.out.println(root.val + "的直接后继： " + successorNode.val);


        // 直接前继
        AVLNode predecessorNode = avlTree.predecessor(root);
        System.out.println(root.val + "的直接前继： " + predecessorNode.val);

        root = avlTree.delete(root, 8);
        avlTree.inOrderTraverseNoRecursion(root);

        res = avlTree.printTreeByRow(root);
        for (int j = 0; j < res.length; j++) {
            System.out.println(Arrays.toString(res[j]));
        }
    }
}
