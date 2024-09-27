import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    
  // List to store valid booking intervals
  List<int[]> ranges = new ArrayList<>();
  
  // List to store overlaps between two bookings (double bookings)
  List<int[]> overlaps = new ArrayList<>();

  public boolean book(int start, int end) {
      
    // Step 1: Check for triple bookings
    // Loop through all the previously detected overlaps (double bookings)
    for (int[] overlap : overlaps) {
      // Calculate the overlap between the new booking and existing double bookings
      // Math.max(start, overlap[0]) gets the latest start time between the two intervals
      // Math.min(end, overlap[1]) gets the earliest end time between the two intervals
      // If the two intervals overlap (start < end), it would result in a triple booking
      if (Math.max(start, overlap[0]) < Math.min(end, overlap[1])) {
        // Return false to reject the booking as it would cause a triple booking
        return false;
      }
    }

    // Step 2: Detect new overlaps (double bookings) with existing valid bookings
    // Loop through all existing bookings
    for (int[] range : ranges) {
      // Calculate the overlap between the new booking and an existing booking
      final int maxStart = Math.max(start, range[0]);  // latest start time
      final int minEnd = Math.min(end, range[1]);      // earliest end time
      // If the new booking overlaps with an existing booking, record it as a new double booking
      if (maxStart < minEnd) {
        // Add the new overlap (double booking) to the overlaps list
        overlaps.add(new int[] {maxStart, minEnd});
      }
    }

    // Step 3: Add the new booking to the valid bookings list
    ranges.add(new int[] {start, end});
    
    // Step 4: Return true to indicate the booking was successful
    return true;
  }
}
