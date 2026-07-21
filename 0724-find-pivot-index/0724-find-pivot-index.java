class Solution {
    public int pivotIndex(int[] nums) {
        int ls = 0;
        int rs = 0;

        for(int i=0; i<=nums.length -1 ; i++){
            rs += nums[i];
        }

        for(int i=0 ;i<=nums.length-1; i++){
            if(ls == rs - nums[i]){
                return i;
            }

            ls += nums[i];
            rs -= nums[i];
        }
        return -1;
    }
}