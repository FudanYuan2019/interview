package base.binarysearch;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * <p>
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * <p>
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 *
 * @Author: Jeremy
 * @Date: 2019/6/1 14:51
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        int res = n;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                if (mid < res) {
                    res = mid;
                }
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeftMostAppearance leftMostAppearance = new LeftMostAppearance();
        int[] arr = new int[]{1, 2, 3, 3, 4};
        int num = 3;
        System.out.println(leftMostAppearance.findPos(arr, arr.length, num));
    }
}
