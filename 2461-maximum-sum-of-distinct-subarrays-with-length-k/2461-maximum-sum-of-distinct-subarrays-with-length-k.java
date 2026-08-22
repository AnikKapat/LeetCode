class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        // This approach shows TLE error, but is morally correct!
        // long max = 0;
        // int n = nums.length;
        
        // for(int i = 0; i <= n - k; i++){
        //     long sum = 0;

        //     Set<Integer> set = new HashSet<>();
        //     boolean isDup = false;

        //     for(int j = i; j<=i+k-1; j++){
        //         if(set.contains(nums[j])){
        //             isDup = true;
        //             break;
        //         }
        //         set.add(nums[j]);
        //         sum = sum + nums[j];
        //     }
        //     if(!isDup){
        //         max = Math.max(max, sum);
        //     }
        // }
        // return max;


        // Approach 2
        long sum = 0,
            max = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int dups = 0;                                                                                                                                                           

        for(int i = 0; i<k ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);

            sum = sum + nums[i];

            if(map.get(nums[i]) > 1){
                dups++;
            }
        }

        if(dups == 0){
            max = Math.max(max, sum);
        }

        for(int i = k; i< nums.length; i++){
            int numToAdd = nums[i],
                numToRemove = nums[i-k];

            if(!map.containsKey(nums[i])){
                map.put(numToAdd, 0);
            }
            map.put(numToAdd, map.get(numToAdd) + 1);

            if(map.get(numToAdd) > 1){
                dups++;
            }

            sum = sum + numToAdd;

            if(map.get(numToRemove) > 1){
                dups--;
            }

            map.put(numToRemove, map.get(numToRemove) - 1);

            sum = sum - numToRemove;

            if(dups == 0){
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}