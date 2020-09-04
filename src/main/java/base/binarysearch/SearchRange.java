package base.binarysearch;

import java.util.Arrays;

/**
 * @Author: Jeremy
 * @Date: 2019/11/17 10:52
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int low = 0;
        int high = nums.length - 1;
        // 先找第一个元素
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            }
        }

        low = 0;
        high = nums.length - 1;
        // 再找最后一个元素
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    res[1] = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3};
        int target = 3;
        int[] res = new SearchRange().searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
