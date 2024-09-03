class Solution {
  
    // Function to convert a string into a "lucky" number based on the specified rules and transformations.
    public int getLucky(String s, int k) {
        // StringBuilder to create the initial numerical string representation
        StringBuilder numericalRepresentation = new StringBuilder();
      
        // Convert each character in the string to its corresponding numerical value ('a' -> 1, 'b' -> 2, etc.)
        for (char c : s.toCharArray()) {
            // Append the numerical string equivalent of character to the StringBuilder
            numericalRepresentation.append(c - 'a' + 1);
        }
      
        // Store the numerical string representation to s for further manipulation
        s = numericalRepresentation.toString();
      
        // Perform transformation k times
        while (k-- > 0) {
            int sum = 0; // Initialize sum to accumulate the digits
          
            // Sum the digits of the string
            for (char c : s.toCharArray()) {
                sum += c - '0'; // Convert char digit to integer and add to sum
            }
          
            // Convert the calculated sum back to string for the next iteration
            s = String.valueOf(sum);
        }
      
        // Convert the final string back to an integer and return it as the "lucky" number
        return Integer.parseInt(s);
    }
}
