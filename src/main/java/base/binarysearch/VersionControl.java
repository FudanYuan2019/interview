package base.binarysearch;

/**
 * @Author: Jeremy
 * @Date: 2019/11/17 11:39
 */
public class VersionControl {
    public int[] flag = new int[]{0, 0, 1, 1, 1};

    public boolean isBadVersion(int n) {
        return flag[n] == 1;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        System.out.println(new VersionControl().firstBadVersion(5));
    }
}
