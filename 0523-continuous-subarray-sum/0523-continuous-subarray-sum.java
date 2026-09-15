class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // remainder -> earliest index where we saw it
        Map<Integer, Integer> map = new HashMap<>();

        // Remainder 0 is considered to exist before
        // the array starts.
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Keep calculating the running Prefix Sum
            sum += nums[i];

            // Find the remainder of the Prefix Sum
            int remainder = sum % k;

            // Have we seen this remainder before?
            if (map.containsKey(remainder)) {

                // If the distance between the two indices
                // is at least 2, we found a valid subarray.
                if (map.containsKey(remainder)) {
                    int oldIndex = map.get(remainder);

                    if (i - oldIndex >= 2) {
                        return true;
                    }
                }
            }
            else {
                // Store ONLY the first/earliest index.
                // Earliest index gives us the longest possible
                // subarray for this remainder.
                map.put(remainder, i);
            }
        }

        return false;
    }
}