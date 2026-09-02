class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < nums2.length; i = i + 1) {
            while (true) {

                if (stack.isEmpty()) {
                    stack.push(i);
                    break;
                }

                int idx = stack.peek();

                if (nums2[i] > nums2[idx]) {
                    map.put(nums2[idx], nums2[i]);
                    stack.pop();
                } else {
                    stack.push(i);
                    break;
                }
            }
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}