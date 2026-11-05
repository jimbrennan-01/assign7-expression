package assignment;

public class Driver implements ExpressionEvaluatorInterface{
    public static void main(String[] args) {
      String infix = "(5+3)/(2+2)";
      
      Stack<String> stack = new Stack<String>();
      
      stack.push("A");
      System.out.println(stack.pop());
      
      
      
    }

	@Override
	public String infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < infix.length(); i++) {
			stack.push(infix.charAt(i));
		}
		
		
		while(stack.peek() != null) {
			if(stack.peek() == ')') {
				
			}
			if(stack.peek() == '(') {
				
			}
			if(stack.peek() == '+') {
				
			}
			if(stack.peek() == '-') {
				
			}
			if(stack.peek() == '/') {
				
			}
			if(stack.peek() == '*') {
				
			}
			if(Character.isDigit(stack.peek())) {
				sb.append(stack.pop());
			}
		}
		
		return null;
	}

	@Override
	public int evaluatePostfix(String postfix) {
		// TODO Auto-generated method stub
		return 0;
	}
}

