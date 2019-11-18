package fraol.project;

import java.util.ArrayList;
import java.util.Stack;


public class CalculateResult {
    	
	
    public ArrayList<String> infixTopostfix(ArrayList<String> list){
        Stack<String> stack = new Stack<>();
	ArrayList<String> postfix = new ArrayList<String>();
	for(int i=0 ; i<list.size() ; i++){
	    String ch = list.get(i);
	    if(isOperator(ch)){
	        if(!stack.isEmpty() && !isLower(ch,stack.peek())){
	            stack.push(ch);
		}else{
		   while(!stack.isEmpty() && isLower(ch,stack.peek())){
		      String top = stack.pop();
		      postfix.add(top);
		   }
	         stack.push(ch);
               }		
	    }else{
	      postfix.add(ch);
	    }
	}
		
	while(!stack.isEmpty()){
	  postfix.add(stack.pop());
	}
        
     return postfix;	
    }
    
    public boolean isLower(String s,String s1){
	switch(s){
	   case "+":
	       return true;
	   case "-":		
	       return true;
	   case "*":  
	   case "/":
	      return "/".equals(s1) || "^".equals(s1);
	   case "^":		
	       return false;
	   default:
	       return false;
	}
		
    }
    
    public boolean isOperator(String x){
     	return x.equals("+") ||x.equals("-") ||x.equals("*") ||x.equals("/") || x.equals("^");
    }
    
    public double Resultant(ArrayList<String> list){
    	list = infixTopostfix(list);
        //System.out.printf("%s", list);
    	Stack<String> stack = new Stack<String>();
    	for(int i=0 ;i<list.size() ; i++){
    	   if(isOperator(list.get(i))){
    		Double result;
    		Double temp;
    		switch(list.get(i)){
    		  case "+":
    		    result = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
    		    stack.push(String.valueOf(result));
    		    break;
    		  case "*":
      		    result = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
      		    stack.push(String.valueOf(result));
      		    break; 
    		  case "/":
    		    temp = Double.parseDouble(stack.pop());
    		    result = Double.parseDouble(stack.pop()) / temp;
    		    stack.push(String.valueOf(result));
    		    break;
    		  case "-":
      		    temp = Double.parseDouble(stack.pop());
      		    result = Double.parseDouble(stack.pop()) - temp;
      		    stack.push(String.valueOf(result));
      		    break;
    		  case "^":
    		    temp = Double.parseDouble(stack.pop());
    		    result = Math.pow(Double.parseDouble(stack.pop()) , temp);
                    stack.push(String.valueOf(result));
      		  default:
      		    break;	 
    	        } 
    	   }
    	   else{
    		  stack.push(list.get(i)); 
    	   }
    	}
        
       return Double.parseDouble(stack.pop());	
    }
    
    
}
