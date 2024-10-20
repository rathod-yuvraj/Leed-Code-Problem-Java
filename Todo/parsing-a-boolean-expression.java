class Solution {
    public boolean parseBoolExpr(String expression) {
        // Stack to hold characters representing boolean values and operators
        Deque<Character> stack = new ArrayDeque<>();
      
        // Iterate through each character in the expression
        for (char c : expression.toCharArray()) {
            if (c != '(' && c != ')' && c != ',') {
                // If the character is not a parenthesis or comma, push it onto the stack
                stack.push(c);
            } else if (c == ')') {
                // When a closing parenthesis is encountered, evaluate the expression inside
                int countTrue = 0; // Count of 't' (true) characters
                int countFalse = 0; // Count of 'f' (false) characters
              
                // Pop characters from the stack until the corresponding operator is found
                while (stack.peek() == 't' || stack.peek() == 'f') {
                    if (stack.peek() == 't') {
                        countTrue++;
                    } else {
                        countFalse++;
                    }
                    stack.pop();
                }
              
                // Pop the operator ('!', '&', or '|')
                char operator = stack.pop();
              
                // Evaluate the expression based on the operator
                if (operator == '!' && countFalse > 0) {
                    // For '!', the expression is true if it has any 'f' (since '!' is a negation)
                    c = 't';
                } else if (operator == '&' && countFalse == 0) {
                    // For '&', the expression is true if all are 't'
                    c = 't';
                } else if (operator == '|' && countTrue > 0) {
                    // For '|', the expression is true if at least one is 't'
                    c = 't';
                } else {
                    // In all other cases, the expression is false
                    c = 'f';
                }
              
                // Push the result of the evaluated expression back onto the stack
                stack.push(c);
            }
        }
        // The result of the entire expression is at the top of the stack
        // Return true if the top of the stack is 't', otherwise false
        return stack.peek() == 't';
    }
}
