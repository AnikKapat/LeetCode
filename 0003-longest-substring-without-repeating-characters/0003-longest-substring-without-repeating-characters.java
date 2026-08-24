class Solution {
    public int lengthOfLongestSubstring(String s) {
 // Approach - 1;
        // int max = 0;

        // for(int i = 0; i<s.length(); i++){
        //     Set <Character> set = new HashSet<>();

        //     for(int j = i ; j< s.length(); j++){
        //         char c = s.charAt(j); 

        //         if(set.contains(c)){
        //             break;
        //         }
        //         set.add(c);
        //         max = Math.max(max, j-i+1);
        //     }
        // }
        // return max;

        // Approach - 2;
        int i = 0,
            j = 0;
        int max = 0;
        
        Set <Character> set = new HashSet<>();

        while(j<s.length()){
            char c = s.charAt(j);

            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}