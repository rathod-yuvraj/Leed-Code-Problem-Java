import java.util.ArrayList;
import java.util.List;

class MyCalendar {
  
  // A private list to keep track of booked events, each event is stored as an int[] array with start and end times.
  private List<int[]> timeline = new ArrayList<>();
  
  // The 'book' method is used to try booking a new event with a given start and end time.
  public boolean book(int start, int end) {
    
    // Loop through all existing events in the timeline
    for (int[] t : timeline) {
      
      // Check if the new event overlaps with any existing event
      // Math.max(t[0], start) gets the later start time between the two events
      // Math.min(t[1], end) gets the earlier end time between the two events
      // If the later start is still earlier than the earlier end, there is an overlap
      if (Math.max(t[0], start) < Math.min(t[1], end)) {
        return false; // Overlapping found, so booking is not possible
      }
    }
    
    // If no overlap is found, add the new event to the timeline
    timeline.add(new int[] {start, end});
    
    // Return true to indicate that the booking was successful
    return true;
  }
}
