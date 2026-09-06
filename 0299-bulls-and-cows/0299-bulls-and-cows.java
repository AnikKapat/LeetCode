class Solution {
    public String getHint(String secret, String guess) {

        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        int bulls = 0;

        // Find Bulls
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
        }

        // Count characters that are NOT Bulls
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {

                char s = secret.charAt(i);
                char g = guess.charAt(i);

                secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
                guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
            }
        }

        // Find Cows
        int cows = 0;

        for (char c : guessMap.keySet()) {
            if (secretMap.containsKey(c)) {
                cows += Math.min(secretMap.get(c), guessMap.get(c));
            }
        }

        return bulls + "A" + cows + "B";
    }
}