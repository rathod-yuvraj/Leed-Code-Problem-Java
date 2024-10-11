class Solution {
  
    public int smallestChair(int[][] times, int targetFriend) {
      
        // Number of friends
        int numFriends = times.length;
      
        // Enhanced array to store arrival and leaving times along with friend's index
        int[][] events = new int[numFriends][3];
      
        // Priority queue to manage available chairs by smallest index
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
      
        // Priority queue to manage busy chairs. Orders by end time of usage.
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
      
        // Initialize available chairs and events array
        for (int i = 0; i < numFriends; ++i) {
            events[i] = new int[]{ times[i][0], times[i][1], i };
            availableChairs.offer(i);
        }
      
        // Sort events by arrival times
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
      
        // Iterate over all events
        for (int[] event : events) {
            int arrivalTime = event[0];
            int leavingTime = event[1];
            int friendIndex = event[2];
          
            // Release all chairs that are free by the current arrival time
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrivalTime) {
                availableChairs.offer(occupiedChairs.poll()[1]);
            }
          
            // Assign the smallest available chair
            int assignedChair = availableChairs.poll();
          
            // If the current friend is the target friend, return the chair number
            if (friendIndex == targetFriend) {
                return assignedChair;
            }
          
            // Mark the chair as occupied until leavingTime
            occupiedChairs.offer(new int[]{leavingTime, assignedChair});
        }
      
        // If the chair wasn't found (which shouldn't happen), return -1
        return -1;
    }
}
