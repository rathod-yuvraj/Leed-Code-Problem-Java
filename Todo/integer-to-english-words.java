class Solution {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder words = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, helper(num % 1000).trim() + " " + THOUSANDS[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return LESS_THAN_20[num];
        } else if (num < 100) {
            return TENS[num / 10] + " " + LESS_THAN_20[num % 10];
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.numberToWords(123));        // Output: "One Hundred Twenty Three"
        System.out.println(solution.numberToWords(12345));      // Output: "Twelve Thousand Three Hundred Forty Five"
        System.out.println(solution.numberToWords(1234567));    // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }
}
