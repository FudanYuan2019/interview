package base.binarysearch;

/**
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。
 * <p>
 * 给定有序数组arr及它的大小n，请返回所求值。
 * <p>
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 *
 * @Author: Jeremy
 * @Date: 2019/6/1 16:17
 */
public class Find {
    public int findPos(int[] arr, int n) {
        if (n == 0 || arr[0] > n - 1 || arr[n - 1] < 0) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] > mid) {
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public int findFirstEquals(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findLastEquals(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findFirstGreaterThan(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) return mid;
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findLastLessThan(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] <= value) {
                if (mid == n - 1 || arr[mid + 1] > value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Find find = new Find();
        int[] arr = new int[]{0, 1, 5, 6, 10, 13, 17, 21, 22, 23, 25, 27, 31, 35, 38, 41};
        System.out.println(find.findPos(arr, arr.length));

        int[] arr1 = new int[]{1, 2, 2, 2, 3};
        System.out.println(find.findFirstEquals(arr1, 2));
        System.out.println(find.findLastEquals(arr1, 2));


        int[] arr2 = new int[]{1, 2, 4, 6, 7};
        System.out.println(arr2[find.findFirstGreaterThan(arr2, 8)]);
        System.out.println(arr2[find.findLastLessThan(arr2, 5)]);
    }
}
