class Solution {

    public long dividePlayers(int[] skillLevels) {
        // Sort the skill levels array to organize players by their skill
        Arrays.sort(skillLevels);
      
        // Get the number of players
        int numOfPlayers = skillLevels.length;
      
        // Calculate the target sum based on the lowest and highest skill levels
        int targetSum = skillLevels[0] + skillLevels[numOfPlayers - 1];
      
        // Initialize the answer variable to store the sum of products
        long answer = 0;
      
        // Use two pointers to iterate from the beginning and end towards the center
        for (int left = 0, right = numOfPlayers - 1; left < right; ++left, --right) {
            // Check if the current pair of players does not meet the target sum
            if (skillLevels[left] + skillLevels[right] != targetSum) {
                return -1; // Return -1 if condition is not met, indicating invalid pairing
            }
          
            // Calculate the product of the skill levels of the two players and add it to the answer
            answer += (long) skillLevels[left] * skillLevels[right];
        }
      
        // Return the final answer which is the sum of products of the pairs
        return answer;
    }
}
