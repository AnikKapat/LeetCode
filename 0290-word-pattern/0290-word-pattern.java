class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> patternToS = new HashMap<>();
        Map<String, Character> StoPattern = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++){

            char a = pattern.charAt(i);
            String b = words[i];

            if(patternToS.containsKey(a) && !patternToS.get(a).equals(b)){
                return false;
            }

            if(StoPattern.containsKey(b) && StoPattern.get(b) != a){
                return false;
            }

            patternToS.put(a, b);
            StoPattern.put(b, a);
        }

        return true;
    }
}