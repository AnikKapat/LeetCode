class Solution {
    public int singleNumber(int[] nums) {
        HashSet <Integer> set = new HashSet<>();

        int sum = 0,
            sumSet = 0;

        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
                sumSet += num;
            }
            sum += num;
        }

        return 2 * sumSet - sum;
    }
}