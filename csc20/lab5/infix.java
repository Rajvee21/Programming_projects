//In this lab, you are to write an infix evaluator. Given an input string of characters like
//“12+34*(56-7)-18/9”, first print the postfix equivalent “12 34 56 7 - * + 18 9 / -” and then print
//the value of the expression. 



import java.io.*;
import MyStackQueue.*;

class infix {
	static Queue infixToPostfix(String str) 
   {
      Queue Que = new Queue();
      Stack sta = new Stack();
      Tokenizer tok = new Tokenizer(str);
      sta.push(new Operator('#'));
   
      while (tok.moreTokens()) 
      {
         Token Tkn = tok.nextToken();
         if (Tkn instanceof Operand)
         {
            Que.enqueue(Tkn);         
         }
         if (Tkn instanceof Operator)
         {
            Operator Opr = (Operator)Tkn;
            if (Opr.operator=='(')
            {
            sta.push(Opr);
            }
            else if (Opr.operator==')')
            {
               while(((Operator)sta.top()).operator != '(')
               {
                  Que.enqueue(sta.pop());
               }
               sta.pop();
            }  
            else
            {
               while(((Operator)sta.top()).precedence() >= Opr.precedence())
               {
                  Que.enqueue(sta.pop());
               }
               sta.push(Opr);
            } 
          }  
        }
        while(((Operator)sta.top()).operator != '#')
        {
            Que.enqueue(sta.pop());
        }
      return Que;
   }

	static int evaluePostfix(Queue Post) 
   { 
      Stack sta = new Stack();
      int result = 0;
      
      while (!Post.isEmpty())
      {
         Token Tkn = (Token)Post.dequeue();
         if (Tkn instanceof Operand)
         {
            sta.push(Tkn);
         }
         else
         {
            Operator Opr = (Operator)Tkn;
            int opnd2 = ((Operand)sta.pop()).operand;
            int opnd1 = ((Operand)sta.pop()).operand;
            switch(Opr.operator) 
            {
               case '+': result = opnd1 + opnd2; break;
               case '-': result = opnd1 - opnd2; break;
               case '*': result = opnd1 * opnd2; break;
               case '/': result = opnd1 / opnd2; break;
            }
            sta.push(new Operand(result));       
         }  
      }
      
      return result;
	}

	public static void main(String[] args) throws IOException {
	Queue Post;
	while(true) {
		System.out.print("Enter infix: ");
		System.out.flush();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		if ( str.equals("") ) break;
		Post = infixToPostfix(str);
		System.out.println("Postfix is " + Post.toString() + '\n');
		int result = evaluePostfix(Post);
		System.out.println("Result is " + result + '\n');
	}
     }
}
