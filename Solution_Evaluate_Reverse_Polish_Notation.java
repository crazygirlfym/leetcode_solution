package leetcode_top100;

import java.util.Stack;

public class Solution_Evaluate_Reverse_Polish_Notation {
	// 逆波兰表示法
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		  
		  for (int i = 0; i < tokens.length; i++) {
		    switch (tokens[i]) {
		      case "+":
		        stack.push(stack.pop() + stack.pop());
		        break;
		          
		      case "-":
		        stack.push(-stack.pop() + stack.pop());
		        break;
		          
		      case "*":
		        stack.push(stack.pop() * stack.pop());
		        break;

		      case "/":
		        int n1 = stack.pop(), n2 = stack.pop();
		        stack.push(n2 / n1);
		        break;
		          
		      default:
		        stack.push(Integer.parseInt(tokens[i]));
		    }
		  }
		  
		  return stack.pop();
}
}
