class Solution {
    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();

        // Count frequency of every character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int length = 0;
        boolean odd = false;

        // Use the frequencies
        for (int count : map.values()) {

            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                odd = true;
            }
        }

        // One odd character can sit in the center
        if (odd) {
            length++;
        }

        return length;
    }
}