class Solution {
    public int findDuplicate(int[] nums) {
        // // Approach - 1; using hasing 
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;

        
    }
}