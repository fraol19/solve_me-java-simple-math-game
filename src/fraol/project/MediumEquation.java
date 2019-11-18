package fraol.project;

import java.util.ArrayList;
import java.util.Random;


public class MediumEquation extends CalculateResult implements Equation{
  
    private int Maxlimit = 9;
    private double answer;
    private final String[] operators = {"+" ,"-" ,"*" ,"/" ,"^"};
    private ArrayList<String> eqList = new ArrayList<String>();
    Random r = new Random();
	
    @Override
    public String generateEquation() {  
      String equation = "";
      int eqLength  = 7 + r.nextInt(6);
        for(int i = 1 ; i<=eqLength ; i++){
	    int number = 1 + r.nextInt(Maxlimit);
	    int opIndex = 2 + r.nextInt(2);
	    eqList.add(String.valueOf(number));
	    if(i<eqLength){
	       eqList.add(operators[opIndex]);   
	    }
	}
	answer = Resultant(eqList); 
	for(String x : eqList){
           equation += x; 
	}
       eqList.removeAll(eqList);
      return equation;	
    }

    @Override
    public void updateDifficulty() {
       Maxlimit += 2;		
    }
	
    public double getAnswer(){
	   return answer;	
	}
   
}
