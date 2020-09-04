package base.dp;

/**
 * @Author: Jeremy
 * @Date: 2019/11/25 21:01
 */
public class Robber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len <= 2){
            return 0;
        }
        int[] dp1 = new int[len];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for(int i = 1; i < len - 1; i++){
            dp1[i + 1] = Math.max(dp1[i], dp1[i - 1] + nums[i]);
        }

        int[] dp2 = new int[len];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2; i < len; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[len-1], dp2[len-1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new Robber().rob(nums));
    }
}
