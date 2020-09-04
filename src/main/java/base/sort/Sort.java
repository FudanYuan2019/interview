package base.sort;

import java.util.Arrays;

/**
 * @Author: Jeremy
 * @Date: 2019/11/8 21:55
 */
public class Sort {
    /**
     * 冒泡排序，时间复杂度O(n2)，空间复杂度O(1)，原地排序，稳定排序
     *
     * @param array
     * @return
     */
    public int[] bubble(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int n = array.length;
        for(int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++){
                if (array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
        return array;
    }

    /**
     * 插入排序，时间复杂度O(n2)，空间复杂度O(1)，原地排序，稳定排序
     *
     * @param array
     * @return
     */
    public int[] insert(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int n = array.length;
        for (int i = 0; i < n; i++){
            int value = array[i];
            int j = i;
            for (; j > 0; j--){
                // 向后移动元素
                if (value < array[j - 1]){
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = value;
        }
        return array;
    }

    /**
     * 选择排序 时间复杂度O(n2)，空间复杂度O(1)，原地排序，不稳定排序
     *
     * @param array
     * @return
     */
    public int[] select(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int n = array.length;
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = i + 1; j < n; j++){
                if (array[min] > array[j]){
                    min = j;
                }
            }
            swap(array, min, i);
        }
        return array;
    }

    /**
     * 归并排序，时间复杂度O(nlogn)，空间复杂度O(n)，非原地排序，稳定排序
     *
     * @return
     */
    public int[] merge(int[] array) {
        if (array.length < 2) {
            return array;
        }
        // 终止条件
        if (array.length == 2) {
            if (array[0] > array[1]) {
                swap(array, 0, 1);
            }
            return array;
        }

        int min = 0;
        int max = array.length;
        int mid = min + ((max - min) >> 1);
        int[] left = new int[mid];
        int[] right = new int[max - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < max - mid; i++) {
            right[i] = array[mid + i];
        }
        array = mergeArray(merge(left), merge(right));
        return array;
    }


    /**
     * 合并两有序数组
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] mergeArray(int[] array1, int[] array2) {
        if (array1.length == 0) return array2;
        if (array2.length == 0) return array1;
        int i = 0;
        int j = 0;
        int n1 = array1.length;
        int n2 = array2.length;
        int[] merge = new int[n1 + n2];
        int counter = 0;
        while(i < n1 && j < n2){
            if (array1[i] < array2[j]){
                merge[counter++] = array1[i++];
            } else {
                merge[counter++] = array2[j++];
            }
        }
        while(i < n1){
            merge[counter++] = array1[i++];
        }
        while (j < n2){
            merge[counter++] = array2[j++];
        }
        return merge;
    }

    /**
     * 快速排序，时间复杂度O(nlogn)，空间复杂度O(1)，原地排序，不稳定排序
     *
     * @param array
     * @return
     */
    public int[] quick(int[] array) {
        if (array.length < 2) {
            return array;
        }
        partition(array, 0, array.length - 1);
        return array;
    }

    /**
     * 分区函数
     *
     * @param array
     * @param left
     * @param right
     */
    public void partition(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = array[left];
        int i = left;
        int j = right;
        while(i < j) {
            while (array[j] >= pivot && i < j){
                j--;
            }
            if (i < j){
                array[i] = array[j];
            }

            while (array[i] <= pivot && i < j){
                i++;
            }
            if (i < j){
                array[j] = array[i];
            }
        }
        array[i] = pivot;

        partition(array, left, i - 1);
        partition(array, i + 1, right);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序，时间复杂度O(nlogn)，空间复杂度O(1)，原地排序，不稳定排序
     *
     * @param array
     * @return
     */
    public int[] heap(int[] array) {
        int n = array.length;
        // 建堆
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(array, n - 1, i);
        }
        // 排序
        int k = n - 1;
        while (k > 0) {
            swap(array, k, 0);
            heapify(array, --k, 0);
        }
        return array;
    }


    /**
     * 堆化
     *
     * @param array
     * @param n
     * @param i
     */
    public void heapify(int[] array, int n, int i) {
        while(true){
            int maxPos = i;
            if (i * 2 + 1 <= n && array[i * 2 + 1] > array[i]) maxPos = i * 2 + 1;
            if (i * 2 + 2 <= n && array[i * 2 + 2] > array[maxPos]) maxPos = i * 2 + 2;
            if (maxPos == i){
                break;
            }
            swap(array, i, maxPos);
            i = maxPos;
        }
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] res;

        int[] array1 = {3, 1, 34, 5, 2, 0};
        res = sort.bubble(array1);
        System.out.println(Arrays.toString(res));

        int[] array3 = {1, 34, 3, 5, 2, 0};
        res = sort.insert(array3);
        System.out.println(Arrays.toString(res));

        int[] array2 = {1, 34, 3, 5, 2, 0};
        res = sort.select(array2);
        System.out.println(Arrays.toString(res));

        int[] array4 = {1, 34, 3, 5, 2, 0};
        res = sort.merge(array4);
        System.out.println(Arrays.toString(res));

        int[] array5 = {1, 34, 3, 5, 2, 0};
        res = sort.quick(array5);
        System.out.println(Arrays.toString(res));

        int[] array6 = {1, 3, 5, 2, 34, 0};
        res = sort.heap(array6);
        System.out.println(Arrays.toString(res));
    }
}
