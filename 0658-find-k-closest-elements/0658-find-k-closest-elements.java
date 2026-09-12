class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length - 1;

        // Find the position where x is / should be
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                low = mid;
                break;
            }
            else if (arr[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        int left = low - 1;
        int right = low;

        List<Integer> ans = new ArrayList<>();

        while (k > 0) {

            if (left < 0) {
                ans.add(arr[right]);
                right++;
            }
            else if (right >= arr.length) {
                ans.add(arr[left]);
                left--;
            }
            else if (x - arr[left] <= arr[right] - x) {
                ans.add(arr[left]);
                left--;
            }
            else {
                ans.add(arr[right]);
                right++;
            }

            k--;
        }

        Collections.sort(ans);

        return ans;
    }
}