class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        //exclude first house
        int case1 = f(1, n-1, nums, dp1);

        //exclude last house
        int case2 = f(0, n-2, nums, dp2);

        return Math.max(case1, case2);
    }

    private int f(int start, int end, int[] nums, int[] dp) {
        if(start > end) return 0;
        if(dp[start] != -1) return dp[start];

        int pick = nums[start] + f(start + 2, end, nums, dp);
        int notpick = 0 + f(start + 1, end, nums, dp);

        return dp[start] = Math.max(pick, notpick);
    }
}