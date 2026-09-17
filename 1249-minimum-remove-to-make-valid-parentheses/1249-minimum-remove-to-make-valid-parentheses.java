import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> remove = new HashSet<>();

        // Find invalid parentheses
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            }

            else if (ch == ')') {

                if (stack.isEmpty()) {
                    remove.add(i);
                }
                else {
                    stack.pop();
                }
            }
        }

        // Any '(' still remaining in stack is invalid
        while (!stack.isEmpty()) {
            remove.add(stack.pop());
        }

        // Build the final answer
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (!remove.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}