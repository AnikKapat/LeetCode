class Solution {
    public int findNumbers(int[] nums) {
        int count =0;
        
        for(int i=0; i<= nums.length -1 ; i++){
            int num = nums[i];
            int what =0;

            while(nums[i] != 0){
                nums[i] = nums[i]/10;
                what++;
            }
            if(what%2 == 0){
                count++;
            }
            // else{
            //     count =0;
            // }
        }
        return count;
    }
}