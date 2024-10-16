class Solution {

    public boolean canArrange(int[] arr, int k) {
        // Create an array to store counts of modulo results
        int[] count = new int[k];

        // Loop through each number in the input array
        for (int number : arr) {
            // Increment the count at the index equal to the number's modulo k,
            // taking into account negative numbers by adding k before modding
            count[(number % k + k) % k]++;
        }

        // Check pairs for each possible modulo result except for 0
        for (int i = 1; i < k; ++i) {
            // For a valid pair, count of modulo i should be equal to count of modulo (k - i)
            if (count[i] != count[k - i]) {
                // If they are not equal, the condition is not met, so return false
                return false;
            }
        }

        // Check that count of numbers that are exactly divisible by k (modulo result is 0)
        // is an even number since they need to be paired among themselves
        return count[0] % 2 == 0;
    }
}
