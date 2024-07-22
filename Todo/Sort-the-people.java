class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;

        // Initialize index array with values 0 to n-1
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on heights in descending order
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        // Create the result array
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }

        return res;
    }
}
