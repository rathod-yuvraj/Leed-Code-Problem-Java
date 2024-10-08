class Solution {
    public int minSwaps(String s) {
        int unmatch = 0;
        
        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                ++unmatch;  // Increment when there's an opening bracket
            } else if (unmatch > 0) {
                --unmatch;  // Decrement when there's a closing bracket if an opening one is unmatched
            }
        }
        
        // Return the number of swaps required
        return (unmatch + 1) / 2;
    }
}
