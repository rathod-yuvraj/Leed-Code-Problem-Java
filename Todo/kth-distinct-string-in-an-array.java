import java.util.*;

class Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each string in the array
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        // List to store distinct strings
        List<String> distinctStrings = new ArrayList<>();

        // Iterate through the array to find distinct strings
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }

        // Check if there are enough distinct strings
        if (distinctStrings.size() < k) {
            return "";
        }

        // Return the k-th distinct string
        return distinctStrings.get(k - 1);
    }
}
