class Solution {
    public int subarraySum(int[] nums, int k) {

        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;

        // Choose the starting position
        for (int i = 0; i < nums.length; i++) {

            // Choose the ending position
            for (int j = i; j < nums.length; j++) {

                int sum;

                // If subarray starts at index 0
                if (i == 0) {
                    sum = prefixSum[j];
                }
                // Otherwise remove everything before i
                else {
                    sum = prefixSum[j] - prefixSum[i - 1];
                }

                // Check whether nums[i...j] sums to k
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}