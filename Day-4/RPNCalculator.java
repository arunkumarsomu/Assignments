//package theIronYard;

import java.util.*;
	 
public class RPNCalculator {

		private int var1;

	// Method to Push in to the stack	
	   public void push(Stack<Integer> st, int a) {
	      st.push(new Integer(a));
	      System.out.println("push(" + a + ")  ---> stack "+st);
	      
	   }
		// Method to pop out of the stack
	   public int pop(Stack<Integer> st) {
	      
	     int num = (int) st.pop();
	      System.out.print("pop <---  "+ num);
//	      System.out.println(num);
	      this.var1 = num;
	      System.out.println("  stack: " + st);
	      return this.var1;
	   }

	   // Main method 
	   public static void main(String args[]) {
		   RPNCalculator rpn = new RPNCalculator();
		   String input[] = {"120","20","+","10","*","10","/","20","-"};
		   int len = 9,val=0;
		   int arith1, arith2, result=0;
		   
		   Stack<Integer> st = new Stack<Integer>();
		// Print the problem    
		   System.out.printf(" Problem is : ");
		   for (int z = 0; z < input.length; z++){
			   System.out.printf(" %s ",input[z]);
			}
		   System.out.println(" ");
		// Parse through String array and do arithmetic calculation   
		   for (int i = 0; i < input.length; i++){
			   // Convert each position of string to integer 
			   if (Character.getNumericValue(input[i].charAt(0)) >= 0 ){
				   for (int k = 0; k < input[i].length(); k++){
					    val = 10 * val + Character.getNumericValue(input[i].charAt(k));  
				   }
			    rpn.push(st, val);
			    val = 0;  // reset val for next number calculation
			   }
			   else{
				   arith2 = rpn.pop(st);
				   arith1 = rpn.pop(st);
				  
				// case for doing math functions   
				   switch(input[i].charAt(0)){
				   
				   case '+':
					   System.out.printf("Add both numbers and  ");
					   	result =  arith1 + arith2;
					   	break;
				   case '*':
					   System.out.printf("Multiply both numbers and  ");
					   	result =  arith1 * arith2;
					   	break;
				   case '-':
					   System.out.printf("Subtract numbers and  ");
					   	result =  arith1 - arith2;
					   	break;
					   	
				   case '/':
					   System.out.printf("Divide the numbers and  ");
					   	result =  arith1 / arith2;
					   	break;
										   	
				   }
				  
				   rpn.push(st, result);
				  
			   }
			}
		  
		   System.out.println("Result is : " + result);
	   }
	
}
