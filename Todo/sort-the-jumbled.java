import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // List to store pairs of mapped value and original index.
        List<Pair> storePairs = new ArrayList<>();
        
        // Process each number in nums.
        for (int i = 0; i < nums.length; ++i) {
            // Convert number to its mapped version.
            StringBuilder formed = new StringBuilder();
            String number = Integer.toString(nums[i]);
            
            for (char c : number.toCharArray()) {
                formed.append(mapping[c - '0']);
            }
            
            // Convert formed string back to integer.
            int mappedValue = Integer.parseInt(formed.toString());
            
            // Add pair of mapped value and original index to the list.
            storePairs.add(new Pair(mappedValue, i));
        }
        
        // Sort pairs based on mapped values.
        Collections.sort(storePairs, (a, b) -> Integer.compare(a.mappedValue, b.mappedValue));
        
        // Create result array.
        int[] result = new int[nums.length];
        for (int i = 0; i < storePairs.size(); ++i) {
            result[i] = nums[storePairs.get(i).originalIndex];
        }
        
        return result;
    }
}

// Helper class to store pairs of mapped value and original index.
class Pair {
    int mappedValue;
    int originalIndex;

    Pair(int mappedValue, int originalIndex) {
        this.mappedValue = mappedValue;
        this.originalIndex = originalIndex;
    }
}
