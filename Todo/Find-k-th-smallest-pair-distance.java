import java.util.Arrays;

class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        // Sort the array to use binary search
        Arrays.sort(nums);
        int n = nums.length;

        // Initialize binary search bounds
        int low = 0;
        int high = nums[n - 1] - nums[0];

        // Perform binary search
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0, left = 0;

            // Use a sliding window to count pairs with a distance <= mid
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            // Adjust binary search based on the count
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
