class Solution {
  public int findComplement(int num) {
    // Start with i = 1 (binary 000...001) and will shift it left in each iteration
    for (long i = 1; i <= num; i <<= 1)
      // XOR the current num with i to flip the corresponding bit in num
      num ^= i;
    // Return the final value of num, which is now the complement of the original number
    return num;
  }
}
