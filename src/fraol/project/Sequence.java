package fraol.project;

import java.util.ArrayList;
import java.util.Random;


public class Sequence {
    
    private int answer;
    private String sequence = "";
    private String hint = "";
    private ArrayList<Integer> seqList = new ArrayList<Integer>();
    private Random r = new Random();
    private int num;
    private int position;
    private int side;
    private int randIndex;
    private int seqChooser;
    
    public int getAnswer() {
       return answer;
    }

    public String getSequence() {
       return sequence;
    }

    public String getHint() {
        return hint;
    }
    
  
    public void generateSequence(){
       seqList.removeAll(seqList);      //clear out eqList for the next sequence
       sequence = "";                   //clear sequence string for the next sequence 
       hint = "";
       num = 20 + r.nextInt(21);
       position = num/2;
       side = 1 + r.nextInt(2);
       seqChooser = 1+r.nextInt(6);    //randomly take number to choose sequence type
        switch (seqChooser) {
            case 1:
                fiboncci();
                break;
            case 2:
                sequenceTwo();
                break;
            case 3:
                sequenceThree();
                break;
            case 4:
                sequenceFour();
                break;
            case 5:
                sequenceFive();
                break;
            default:
                sequenceSix();
                break;
        }
       
    }
    
   
    public void fiboncci(){
        int y=0,x=1,sum;		
	   for(int i=0;i<num ;i++)
            {  
              if(side == 1){
                if(i <= position){
                  seqList.add(y);
                }
              }else{
                if(i > position){
                  seqList.add(y);
                }
              }
             if(i < 5){ 
               hint += (y + ", ");
             } 
	     sum=x+y;
	     x=y;
	     y=sum;
            }
       
        if(position > 15){                              //taking random index for the value of the answer
          randIndex = 7 + r.nextInt(seqList.size() - 8);
        }else{ 
          randIndex = 5 + r.nextInt(seqList.size()- 6);
        }  
      
       answer = seqList.get(randIndex);                //saving the answer
       for(int i=0 ; i<seqList.size() ; i++){         //generating sequence string
          if(i == randIndex){
             sequence +="   ,";                      //blank at the index of the answer
           }else{
             sequence += (String.valueOf(seqList.get(i)) + ",");
           }
       }
    }
    
    
    public void sequenceTwo(){
        int value;
	for(int i=1; i<num; i++){
	    value=(int) (Math.pow(i, 2)+(Math.pow((i+1), 2)));
	      if(side == 1){
                if(i <= position){
                  seqList.add(value);
                }
              }else{
                if(i > position){
                  seqList.add(value);
                }
              }
              if(i < 5){ 
               hint += (value+ ", ");
              }
	}
        
        if(position > 15){                              //taking random index for the value of the answer
          randIndex = 5 + r.nextInt(seqList.size()-5);
        }else{ 
          randIndex = 4 + r.nextInt(seqList.size()-4);
        }
        
        answer = seqList.get(randIndex);                //saving the answer
        for(int i=0 ; i<seqList.size() ; i++){        //generating sequence string
          if(i == randIndex){
             sequence +="   ,";
           }else{
             sequence += (String.valueOf(seqList.get(i)) + ",");
           }
        }
	
    }
    
    
    public void sequenceThree(){
	int value;
	for(int i=1; i<num; i++){
	    value=i*(i+1);
	      if(side == 1){
                if(i <= position){
                  seqList.add(value);
                }
              }else{
                if(i > position){
                  seqList.add(value);
                }
              }
              if(i < 5){ 
               hint += (value+ ", ");
              }
	}
        
        if(position > 15){                              //taking random index for the value of the answer
          randIndex = 6 + r.nextInt(seqList.size()-6);
        }else{ 
          randIndex = 4 + r.nextInt(seqList.size()-4);
        }
        
        answer = seqList.get(randIndex);                //saving the answer
        for(int i=0 ; i<seqList.size() ; i++){        //generating sequence string
          if(i == randIndex){
             sequence +="   ,";
           }else{
             sequence += (String.valueOf(seqList.get(i)) + ",");
           }
        }
	
    }
    
	
    public void sequenceFour(){
	int value;
	for(int i=1; i<num; i++){
            value=(int) Math.pow(i, 2);
              if(side == 1){
                if(i <= position){
                  seqList.add(value);
                }
              }else{
                if(i > position){
                  seqList.add(value);
                }
              } 
              if(i < 4){ 
               hint += (value+ ", ");
              }
	}
        
        if(position > 15){                              //taking random index for the value of the answer
          randIndex = 8 + r.nextInt(seqList.size()-8);
        }else{ 
          randIndex = 6 + r.nextInt(seqList.size()-6);
        }
        
        answer = seqList.get(randIndex);                //saving the answer
        for(int i=0 ; i<seqList.size() ; i++){        //generating sequence string
          if(i == randIndex){
             sequence +="   ,";
           }else{
             sequence += (String.valueOf(seqList.get(i)) + ",");
           }
        }
		
		
    }
    
	
    public void sequenceFive(){
	int value;
        num = 40 + r.nextInt(81);
	for(int i=1; i<num; i+=2){
 	    value=(int) Math.pow(i, 2);
	      if(side == 1){
                if(i <= position){
                  seqList.add(value);
                }
              }else{
                if(i > position){
                  seqList.add(value);
                }
              }
              if(i < 9){ 
               hint += (value+ ", ");
              }
	}
        
        if(position > 20){                              //taking random index for the value of the answer
          randIndex = 9+ r.nextInt(seqList.size()-9);
        }else{ 
          randIndex = 5 + r.nextInt(seqList.size()-5);
        }
        
        answer = seqList.get(randIndex);                //saving the answer
        for(int i=0 ; i<seqList.size() ; i++){        //generating sequence string
          if(i == randIndex){
             sequence +="   ,";
           }else{
             sequence += (String.valueOf(seqList.get(i)) + ",");
           }
        }
		
		
    }
    
	
    public void sequenceSix(){
	int value;
        num = 40 + r.nextInt(81);
	for(int i=2; i<num; i+=2){
	    value=(int) Math.pow(i, 2);
	      if(side == 1){
                if(i <= position){
                  seqList.add(value);
                }
              }else{
                if(i > position){
                  seqList.add(value);
                }
              }
              if(i < 10){ 
               hint += (value+ ", ");
              }
        }
        
        if(position > 20){                              //taking random index for the value of the answer
          randIndex = 9 + r.nextInt(seqList.size()-9);
        }else{ 
          randIndex = 4 + r.nextInt(seqList.size()-4);
        }
        
        answer = seqList.get(randIndex);                //saving the answer
        for(int i=0 ; i<seqList.size() ; i++){        //generating sequence string
          if(i == randIndex){
             sequence +="   ,";
           }else{
             sequence += (String.valueOf(seqList.get(i)) + ",");
           }
        }
		
		
    }
    
    
}
