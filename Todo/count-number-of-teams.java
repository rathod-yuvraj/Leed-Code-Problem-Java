class Solution {
    public int numTeams(int[] rating) {
        
        int count = 0; // Variable to store the number of valid teams
        int n = rating.length; // Get the length of the rating array

        // Loop through each soldier as the middle element of a potential team
        for (int mid = 1; mid < n - 1; mid++) {
            int leftSmallerCount = 0; // Count of soldiers to the left of 'mid' with a smaller rating
            for (int i = 0; i < mid; i++) {
                if (rating[i] < rating[mid]) {
                    leftSmallerCount++;
                }
            }

            int rightGreaterCount = 0; // Count of soldiers to the right of 'mid' with a greater rating
            for (int i = mid + 1; i < n; i++) {
                if (rating[i] > rating[mid]) {
                    rightGreaterCount++;
                }
            }

            // Increment count by the product of leftSmallerCount and rightGreaterCount
            // This accounts for the number of valid increasing teams
            count += leftSmallerCount * rightGreaterCount;

            int leftGreaterCount = mid - leftSmallerCount; // Count of soldiers to the left of 'mid' with a greater rating
            int rightSmallerCount = n - mid - 1 - rightGreaterCount; // Count of soldiers to the right of 'mid' with a smaller rating

            // Increment count by the product of leftGreaterCount and rightSmallerCount
            // This accounts for the number of valid decreasing teams
            count += leftGreaterCount * rightSmallerCount;
        }

        return count; // Return the total count of valid teams
    }
}
