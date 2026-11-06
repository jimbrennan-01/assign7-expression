package assignment;

import java.util.Scanner;

public class Driver implements ExpressionEvaluatorInterface{
    public static void main(String[] args) {
    	
      Scanner console = new Scanner(System.in);
      Driver drive = new Driver();
      System.out.printf("Enter an infix expression (e.g., (3 + 5) * 2): ");
      String infix = console.nextLine();
      console.close();
      
      String postfix = drive.infixToPostfix(infix);
      System.out.println();
      System.out.printf("--- Results ---\n");
      System.out.printf("Infix Expression:\t%s\n", infix);
      System.out.printf("Postfix Expression:\t%s\n", postfix);
      System.out.printf("Evaluated Result:\t%d\n", drive.evaluatePostfix(postfix));
      
      
    }

	@Override
	public String infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < infix.length(); i++) {
			if(Character.isDigit(infix.charAt(i))) {
				sb.append(infix.charAt(i));
				sb.append(" ");
			} else if (infix.charAt(i) == '(') {
				stack.push(infix.charAt(i));
			} else if(infix.charAt(i) == '+' || infix.charAt(i) == '-' || 
					  infix.charAt(i) == '*' || infix.charAt(i) == '/') {
				
	            boolean lowPrec = (infix.charAt(i) == '+' || infix.charAt(i) == '-');
	            
	            while (stack.head != null && stack.peek() != '('
	                    && (lowPrec || stack.peek() == '*' || stack.peek() == '/')) {
	                sb.append(stack.pop()).append(" ");
	            }
	            stack.push(infix.charAt(i));
			} else if(infix.charAt(i) == ')') {
				while(stack.head != null && stack.peek() != '(') {
					sb.append(stack.pop());
					sb.append(" ");
		            if (stack.head != null) {
		                stack.pop();
		            }
				}
			}
		}
		while(stack.head != null) {
			if(stack.peek() == '(' || stack.peek() == '(') {
				stack.pop();
			}else {
				sb.append(stack.pop());
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	@Override
	public int evaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < postfix.length(); i++) {
			if(Character.isDigit(postfix.charAt(i))) {
				int digit = postfix.charAt(i) - '0';
				stack.push(digit);
			}else if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*' || postfix.charAt(i) == '/') {
				int right = stack.pop();
				int left = stack.pop();
				int result = 0;
				
				if(postfix.charAt(i) == '+') {
					result = left + right;
				}
				if(postfix.charAt(i) == '-') {
					result = left - right;
				}
				if(postfix.charAt(i) == '*') {
					result = left * right;
				}
				if(postfix.charAt(i) == '/') {
					result = left / right;
				}
				
				stack.push(result);
			}
		}
		return stack.pop();
	}
}

