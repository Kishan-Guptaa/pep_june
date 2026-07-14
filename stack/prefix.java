import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public static int evaluatePrefix(String expression) {
		Deque<Integer> stack = new ArrayDeque<>();
		String[] tokens = expression.trim().split("\\s+");

		for (int i = tokens.length - 1; i >= 0; i--) {
			String token = tokens[i];

			if (token.length() == 1 && isOperator(token.charAt(0))) {
				int left = stack.pop();
				int right = stack.pop();
				stack.push(apply(token.charAt(0), left, right));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int apply(char operator, int left, int right) {
		switch (operator) {
			case '+':
				return left + right;
			case '-':
				return left - right;
			case '*':
				return left * right;
			case '/':
				return left / right;
			default:
				throw new IllegalArgumentException("Unsupported operator: " + operator);
		}
	}
}
