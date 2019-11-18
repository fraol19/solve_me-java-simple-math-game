package fraol.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AutoGenerate implements ActionListener{
    private int delay;

    public AutoGenerate() {
       delay  =  5; 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(delay > 0){
        NewJFrame.generateTab.setVisible(true);
        NewJFrame.generateTab.setText("Question in : " + delay +"sec");
        NewJFrame.answerField.setEnabled(false);
        NewJFrame.submitButton.setEnabled(false);
        delay--;
        
       }else{
         NewJFrame.autotimer.stop();
         NewJFrame.generateTab.setText("<Go>");
         newEquation();
         fitLabel();
         NewJFrame.eqLabel.setText(NewJFrame.equation);
         NewJFrame.answerField.setEnabled(true);
         NewJFrame.submitButton.setEnabled(true);
         NewJFrame.timer.start(); 
       }
    }
    
    private void newEquation(){
       
        /*this method call generateEquation method by
         *selecting an object from NewJFrame class based
         *on the level type 
         */ 
        
       switch(NewJFrame.time){
           case 40:
              NewJFrame.equation = NewJFrame.simpleResult.generateEquation();
              NewJFrame.result = NewJFrame.simpleResult.getAnswer();
             break; 
          
           case 70:
              NewJFrame.equation = NewJFrame.mediumResult.generateEquation();
              NewJFrame.result = NewJFrame.mediumResult.getAnswer();
             break;
            
           case 100:
              NewJFrame.equation = NewJFrame.hardResult.generateEquation();
              NewJFrame.result = NewJFrame.hardResult.getAnswer();
             break; 
           
           case 160:
              NewJFrame.equation = NewJFrame.vhardResult.generateEquation();
              NewJFrame.result = NewJFrame.vhardResult.getAnswer();
             break; 
           case 50:
               NewJFrame.sequence.generateSequence();
               NewJFrame.equation = NewJFrame.sequence.getSequence();
               NewJFrame.result = NewJFrame.sequence.getAnswer();
               NewJFrame.hintLable.setText("HINT!!  "+ NewJFrame.sequence.getHint() +"...");
             break; 
           default:
             break;  
            
       }
     
    }
    
    private void fitLabel(){
     /*Fit the equation label based on the size of the equation string*/  
      int eqLength = NewJFrame.equation.length();
      if(eqLength <=54 ){
       NewJFrame.eqLabel.setFont(new java.awt.Font("Tahoma",1,24));
      }
      else if(eqLength > 54 && eqLength <= 75 ){
       NewJFrame.eqLabel.setFont(new java.awt.Font("Tahoma",1,18));
      }
      else if(eqLength > 75 && eqLength <= 92){
       NewJFrame.eqLabel.setFont(new java.awt.Font("Tahoma",1,14));
      }
      else if(eqLength > 92 && eqLength <= 103){
       NewJFrame.eqLabel.setFont(new java.awt.Font("Tahoma",1,12));
      }
      else if(eqLength > 103 && eqLength <= 117){
       NewJFrame.eqLabel.setFont(new java.awt.Font("Tahoma",1,10));
      }
      else{
       NewJFrame.eqLabel.setFont(new java.awt.Font("Tahoma",1,9));
      }
     
    }
    
    
}
