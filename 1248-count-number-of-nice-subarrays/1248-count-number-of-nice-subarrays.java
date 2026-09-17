import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // 0 odd numbers have occurred once
        map.put(0, 1);

        int oddCount = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            // Count odd numbers
            if (nums[i] % 2 != 0) {
                oddCount++;
            }

            // We need a previous prefix with:
            // previousOddCount = oddCount - k
            if (map.containsKey(oddCount - k)) {
                ans += map.get(oddCount - k);
            }

            // Store current oddCount
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return ans;
    }
}