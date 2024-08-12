import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KthLargest {

    // List to store the stream of numbers
    List<Integer> stream;
    
    // The k value, to track the k-th largest element
    int k;

    // Constructor to initialize the KthLargest object
    public KthLargest(int k, int[] nums) {
        // Initialize the stream list with the same size as nums array
        stream = new ArrayList<>(nums.length);
        
        // Set the k-th largest number we're interested in
        this.k = k;

        // Add each number from the initial array to the stream list
        for (int num : nums) {
            stream.add(num);
        }

        // Sort the stream list so that it is in ascending order
        Collections.sort(stream);
    }

    // Method to add a new value to the stream and return the k-th largest element
    public int add(int val) {
        // Find the correct index to insert the new value (val) using binary search
        int index = getIndex(val);
        
        // Insert the new value at the correct position to maintain the sorted order
        stream.add(index, val);
        
        // Return the k-th largest element, which is at position stream.size() - k
        return stream.get(stream.size() - k);
    }

    // Helper method to find the correct insertion index for a new value using binary search
    private int getIndex(int val) {
        int left = 0;
        int right = stream.size() - 1;
        
        // Perform binary search
        while (left <= right) {
            // Find the middle index
            int mid = (left + right) / 2;
            
            // Get the element at the middle index
            int midElement = stream.get(mid);
            
            // If the middle element is equal to the value, return mid (found the correct position)
            if (midElement == val) return mid;
            
            // If the middle element is greater than the value,
            // search in the left half (narrow down the search space to the left)
            if (midElement > val) {
                right = mid - 1;
            } 
            // If the middle element is less than the value,
            // search in the right half (narrow down the search space to the right)
            else {
                left = mid + 1;
            }
        }
        
        // Return the left index which is the correct insertion point for the value
        return left;
    }
}
