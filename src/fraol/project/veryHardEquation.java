package fraol.project;

import java.util.ArrayList;
import java.util.Random;

public class veryHardEquation extends CalculateResult implements Equation{

    private int Maxlimit = 9;
    private double answer;
    private final String[] operators = {"+" ,"-" ,"*" ,"/" ,"^"};
    private ArrayList<String> eqList = new ArrayList<String>();
    Random r = new Random();
	
    @Override
    public String generateEquation() {
      String equation = "";
      int eqLength  = 6 + r.nextInt(6);
        for(int i = 1 ; i<=eqLength ; i++){
	    int number = 1 + r.nextInt(Maxlimit);
	    int opIndex = r.nextInt(5);
            if(opIndex == 4){ 
                number = 2 + r.nextInt(7);
                
            }
            if(!eqList.isEmpty() && eqList.get(eqList.size() -1).equals("^")){
                number = 2 + r.nextInt(7);
            }
            eqList.add(String.valueOf(number));
	    if(i<eqLength){
	       eqList.add(operators[opIndex]);   
	    }
            if(eqLength == i && !eqList.contains("^")){
               eqLength += 1;
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
       Maxlimit += 1;		
    }
	
    public double getAnswer(){
	   return answer;	
    }
    
}
