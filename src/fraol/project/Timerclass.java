package fraol.project;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Timerclass implements ActionListener{
    
    public static int time;
    public static int bounus;
    private static Toastclass toast; 
    public static Timer toastTimer;
    
    
    public Timerclass(int time) {
       Timerclass.time = time;
       toast = new Toastclass();
       toastTimer = new Timer(300,toast);
    }
   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(time > 0){
          time--;
          NewJFrame.timeLabel.setText("TOTAL TIME  : " + time + "sec");
          NewJFrame.generateTab.setVisible(false);
       }else{
         NewJFrame.timer.stop();                        //timer stops when the time is zero
         NewJFrame.generateTab.setVisible(true);
         NewJFrame.generateTab.setText("Game over!!!");
         toastTimer.stop();
         NewJFrame.toastLabel.setVisible(false);
         Toolkit.getDefaultToolkit().beep();           //beep to show the game is over
         NewJFrame.answerField.setText("");
         NewJFrame.answerField.setEnabled(false);      //disable input field
         NewJFrame.submitButton.setEnabled(false);      
         NewJFrame.replayTab.setVisible(true);         
         NewJFrame.eqLabel.setText("The Answer is " + NewJFrame.result);
          
         //check best score at the end of the game
         if(NewJFrame.getScore() > NewJFrame.getBestScore()){
            NewJFrame.setBestScore(NewJFrame.getScore());
            NewJFrame.bestScoreLabel.setText("Best Score                   : "+ NewJFrame.getScore());
            NewJFrame.scoreOperation("update", NewJFrame.time);   //update 
            
         }
        
       } 
    }

    public void addBounus(int bounustime){
       //toast a bounus icon if bounus is add 
        toastTimer.start();
        NewJFrame.bounusLabel.setText("BOUNUS        : " + bounus + "sec");
        time += bounustime; 
    }
    
}

 //to animate bounus adding step 
class Toastclass implements ActionListener{
  
    private int delay;

    public Toastclass() {
      delay = 2;  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(delay > 1){
          delay--;
          NewJFrame.toastLabel.setVisible(true);
        }
        else{
          NewJFrame.toastLabel.setVisible(false);
          delay = 2;
        }
    }
   
  
   
}
