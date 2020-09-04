package base.binarysearch;

/**
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * <p>
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，
 * 只需返回arr中任意一个局部最小出现的位置即可。
 *
 * @Author: Jeremy
 * @Date: 2019/6/1 14:27
 */
public class FindLocalMin {
    public int getLessIndex(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FindLocalMin findLocalMin = new FindLocalMin();
        int[] arr = new int[]{3,2,9,2,1,4,0,10,9,0,8,3,5,6,7,1,9,2,4,0,7};
        System.out.println(arr[9]);
        System.out.println(findLocalMin.getLessIndex(arr));
    }
}
