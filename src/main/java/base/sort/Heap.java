package base.sort;


import java.util.Arrays;

/**
 * @Author: Jeremy
 * @Date: 2019/11/27 10:44
 */
public class Heap {
    private int[] data;
    private int max;
    private int count;

    public Heap(int n) {
        data = new int[n + 1];
        max = n;
        count = 0;
    }

    public Heap(int[] array, int n) {
        data = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            data[i] = array[i - 1];
        }
        build(data, n);
        max = n;
        count = n;
    }

    public void insert(int value) {
        // 堆满了
        if (count >= max) return;
        ++count;
        data[count] = value;
        int i = count;
        // 自下而上插入，不断比较节点与父节点的大小，如果子节点>父节点，则交换父子节点。
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    public void removeMax() {
        // 堆中没有数据
        if (count == 0) return;
        // 将最后一个元素设置为堆顶元素
        data[1] = data[count];
        count--;
        // 调整成堆，即堆化
        heapify(data, count, 1);
    }

    public void build(int[] array, int len) {
        for (int i = len / 2; i >= 1; i--) {
            heapify(array, len, i);
        }
    }

    public void heapify(int[] array, int len, int i) {
        while (true) {
            // 找到父子节点中最大值所在位置
            int maxPos = i;
            if (i * 2 <= len && array[i] < array[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= len && array[maxPos] < array[i * 2 + 1]) maxPos = i * 2 + 1;
            // 没有交换，则退出循环，堆化结束
            if (maxPos == i) break;
            swap(maxPos, i);
            i = maxPos;
        }
    }

    public void sort() {
        int n = count;
        while (n > 1) {
            swap(n, 1);
            n--;
            heapify(data, n, 1);
        }
    }

    public void printHeap() {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 3, 5};
        Heap heap = new Heap(array, array.length);
        heap.sort();
        heap.printHeap();

        Heap heap1 = new Heap(4);
        for (int value : array) {
            heap1.insert(value);
        }
        heap1.printHeap();
    }
}
