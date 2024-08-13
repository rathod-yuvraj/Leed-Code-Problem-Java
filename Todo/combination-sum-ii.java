class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>(); // Use ArrayList for better performance
        Arrays.sort(candidates); // Sort candidates array to handle duplicates easily
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(
        List<List<Integer>> answer,
        List<Integer> tempList,
        int[] candidates,
        int totalLeft,
        int index
    ) {
        if (totalLeft == 0) { // Add to the answer array if the sum is equal to target
            answer.add(new ArrayList<>(tempList));
            return; // Early return since we found a valid combination
        } 
        
        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates in the sorted array
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            
            if (totalLeft < candidates[i]) break; // No need to continue if the candidate exceeds totalLeft
            
            tempList.add(candidates[i]); // Add candidate to tempList
            
            // Move to the next element in the array with reduced totalLeft
            backtrack(answer, tempList, candidates, totalLeft - candidates[i], i + 1);
            
            tempList.remove(tempList.size() - 1); // Backtrack by removing the last added element
        }
    }
}
