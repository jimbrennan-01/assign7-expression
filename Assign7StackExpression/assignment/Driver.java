package assignment;

public class Driver implements ExpressionEvaluatorInterface{
    public static void main(String[] args) {
      String infix = "(5 + 3)/(2 + 2)";
    }

	@Override
	public String infixToPostfix(String infix) {
		Stack stack = new Stack();
		
		for(int i = 0; i < infix.length(); i++) {
			Node node = new Node(infix.charAt(i));
			stack.push(node);
		}
		
		return null;
	}

	@Override
	public int evaluatePostfix(String postfix) {
		// TODO Auto-generated method stub
		return 0;
	}
}

