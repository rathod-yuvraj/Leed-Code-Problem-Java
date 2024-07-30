   public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer for the end of the initial part of nums1
        int p2 = n - 1; // Pointer for the end of nums2
        int p = m + n - 1; // Pointer for the end of nums1
        
        // While there are elements to compare in both nums1 and nums2
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        
        // If there are remaining elements in nums2, copy them over
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        
        // No need to copy remaining elements from nums1 since they are already in place
    }
