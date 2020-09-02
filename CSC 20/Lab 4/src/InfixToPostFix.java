import java.util.*;

public class InfixToPostFix {
	
	private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/';
	private static final char MOD ='%';

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String ans = "yes";

		while (ans.equalsIgnoreCase("yes")) {
			
			System.out.println("Enter your infix expression");
			String s = sc.nextLine();

			String[] infix_str = {s};
			InfixToPostFix convert = new InfixToPostFix();
			
			for (int i=0; i<infix_str.length; i++) {
			      System.out.println("infix: " + infix_str[i]);
			      System.out.println("postfix: " + convert.infixtopostfix(sc, infix_str[i]));
			      //System.out.println("postfix evaluation: " + convert.evaluate( convert.convertToPostfix(testString[i])));
			      
			      System.out.println();
			   }
			
			do {
				
				System.out.print("Do you have another expression to evaluate: \n " + "Answer must be yes or no: ");
				ans = sc.nextLine();
				System.out.println();
			}

			while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"));

		}
		System.out.println("\n");

	}
	
   private static boolean isOperator(char c) { // Tell whether c is an operator.

	     return c == '+'  ||  c == '-'  ||  c == '*'  ||  c == '/'  ||  c == '^'
	           || c=='(' || c==')';
	   
	   }//end isOperator

	
	private static String infixtopostfix(Scanner sc, String s) {
		MyStack inp = new MyStack();
		char c;
		StringTokenizer st = new StringTokenizer(s, "+-*/%()",true);
		StringBuffer postfix = new StringBuffer(s.length());
		while (st.hasMoreTokens()) {
			
			String token = st.nextToken();
			c = token.charAt(0);   
			if ( (token.length() == 1) && isOperator(c) ) {    
	              while (!inp.isEmpty() &&
	                  !lowerPrecedence(((String)inp.peek()).charAt(0), c))
	             
	                 postfix.append(" ").append((String)inp.pop());
	              if (c==')') {
	                    String operator = (String)inp.pop();
	                    
	                    while (operator.charAt(0)!='(') {
	                       postfix.append(" ").append(operator);
	                       operator = (String)inp.pop();  
	                    }
	              }
	              else
	                 inp.push(token);
	           }
	           else if ( (token.length() == 1) && isSpace(c) ) {   
	               }
	           else { 
	             postfix.append(" ").append(token);  
	           }
	         }
	        while (!inp.isEmpty())
	           postfix.append(" ").append((String)inp.pop());
	     
	        return postfix.toString();
	   }
			
	   private static boolean isSpace(char c) {  // Tell whether c is a space.

		     return (c == ' ');
		   
		   }//end isSpace

	   private static boolean lowerPrecedence(char op1, char op2) {
		      // Tell whether op1 has lower precedence than op2, where op1 is an
		      // operator on the left and op2 is an operator on the right.
		      // op1 and op2 are assumed to be operator characters (+,-,*,/,^).
		
		   if(op1 == '+' || op1 == '-') {
			   return !(op2=='+' || op2=='-');
		   }
		   else if(op1 == '*' || op1 == '/') {
	           return op2=='%' || op2=='(';
		   }
		   else if(op1 == '%') {
			   return op2=='(';
		   }
		   else if(op1 == '(') {
			   return true;
		   }
		   else {
			   return false;
		   }
		   
	   } // end lowerPrecedence
	   
	   
	   private static int evalSingleOp(char operation, int op1, int op2) {
		        int result = 0;

		        switch (operation) {
		            case ADD :
		                result = op1 + op2;
		                break;
		            case SUBTRACT :
		                result = op1 - op2;
		                break;
		            case MULTIPLY :
		                result = op1 * op2;
		                break;
		            case DIVIDE :
		                result = op1 / op2;
		            case MOD :
		                result = op1 % op2;
		        }

		        return result;
		    }

	   
	public static int postFixEvaluate(String postFix) {

		MyStack inp = new MyStack();
		StringTokenizer st = new StringTokenizer(postFix);
		int op1, op2, result = 0;
        String token;

		try {

			while (st.hasMoreTokens()) {

				token = st.nextToken();

				Character A = token.charAt(0);
				if (isOperator(A)) {
	                op2 = ((Integer) inp.pop()).intValue();
	                op1 = ((Integer) inp.pop()).intValue();
	                result = evalSingleOp(token.charAt(0), op1, op2);
	                inp.push(new Integer(result));
	            }
	            else
	                inp.push(new Integer(Integer.parseInt(token)));
			}

		}
		


		catch (NullPointerException o) {

			System.out.println("Invalid Expression.");

		}
        result = ((Integer) inp.pop()).intValue();
        return result;

	}
}
