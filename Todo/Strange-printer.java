class Solution {

    public int strangePrinter(String s) {
        // Remove consecutive duplicate characters to simplify the problem
        s = removeDuplicates(s);
        int n = s.length();
        // Memoization array to store subproblem results
        Integer[][] memo = new Integer[n][n];
        // Start the recursion from the first to the last character
        return minimumTurns(0, n - 1, s, memo);
    }

    private int minimumTurns(int start, int end, String s, Integer[][] memo) {
        // Base case: if start exceeds end, no characters are left to print
        if (start > end) {
            return 0;
        }

        // Check if this subproblem has already been solved
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        // The worst-case scenario: print s[start] separately, then handle the rest
        int minTurns = 1 + minimumTurns(start + 1, end, s, memo);

        // Try to merge the same characters to minimize the number of turns
        for (int k = start + 1; k <= end; k++) {
            if (s.charAt(k) == s.charAt(start)) {
                // Instead of printing separately, merge with the matching character
                // Split the problem into two parts: before and after the match
                int turnsWithMatch = minimumTurns(start, k - 1, s, memo) +
                                     minimumTurns(k + 1, end, s, memo);
                // Choose the minimum number of turns between the current and merged scenarios
                minTurns = Math.min(minTurns, turnsWithMatch);
            }
        }

        // Store the result in memo array and return it
        memo[start][end] = minTurns;
        return minTurns;
    }

    // Helper method to remove consecutive duplicate characters from the string
    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            // Skip all consecutive duplicates of the current character
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}
