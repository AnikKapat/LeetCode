class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // Approach -1 --> Returs TLE
        // int size = Integer.MAX_VALUE;

        // for(int i =0; i< nums.length; i++){
        //     int sum = 0;
        //     for(int j = i; j<nums.length; j++){
        //         sum = sum + nums[j];

        //         if(sum >= target){
        //             size = Math.min(size, j-i+1);
        //             break;
        //         }
        //     }
        // }
        // return size == Integer.MAX_VALUE ? 0 : size;

        
        int size = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0,
            j = 0;

        while(j<nums.length){
            // expand window
            sum = sum + nums[j];

            while(sum >= target){
                size = Math.min(size, j-i+1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }
}