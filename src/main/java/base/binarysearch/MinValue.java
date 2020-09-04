package base.binarysearch;

/**
 * 对于一个有序循环数组arr，返回arr中的最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * <p>
 * 给定数组arr及它的大小n，请返回最小值。
 * <p>
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 *
 * @Author: Jeremy
 * @Date: 2019/6/1 15:01
 */
public class MinValue {
    public int getMin(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            if (left + 1 == right) {
                break;
            }
            // 左端 <= 右端，代表数组有序，直接返回左端值
            if (arr[left] < arr[right]) {
                return arr[left];
            }

            mid = left + (right - left) / 2;
            // 左端 > 中间，最小值一定在左半部分
            if (arr[mid] < arr[left]) {
                right = mid;
                continue;
            }

            // 右端 > 中间，最小值一定在右半部分
            if (arr[mid] > arr[right]) {
                left = mid;
                continue;
            }

            // 左端 == 中间 == 右端
            while (left < mid) {
                if (arr[left] == arr[mid]) {
                    left++;
                }
                if (arr[left] < arr[mid]) {
                    return arr[left];
                } else {
                    right = mid;
                    break;
                }
            }
        }
        return Math.min(arr[left], arr[right]);
    }

    public static void main(String[] args) {
        MinValue minValue = new MinValue();
        int[] arr = new int[]{1, 2, 3, 3, 4};
        System.out.println(minValue.getMin(arr, arr.length));
        ;
    }
}
