class Solution {
  public String reverseParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (final char c : s.toCharArray()) {
      if (c == '(') {
        // Push the current length of the StringBuilder onto the stack
        stack.push(sb.length());
      } else if (c == ')') {
        // Reverse the corresponding substring between ()
        StringBuilder reversed = new StringBuilder();
        // Get the position of the last unmatched '('
        int start = stack.pop();
        // Reverse the substring from 'start' to the current length of sb
        for (int i = sb.length() - 1; i >= start; --i) {
          reversed.append(sb.charAt(i));
        }
        // Delete the reversed part from sb
        sb.setLength(start);
        // Append the reversed substring
        sb.append(reversed);
      } else {
        // Append current character to the StringBuilder
        sb.append(c);
      }
    }

    return sb.toString();
  }
}
