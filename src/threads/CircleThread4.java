
package threads;

import domain.Point;
import domain.Circle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CircleThread4 extends Thread{
    
    //variables
    private Circle myCircle4;
    private int delayTime;

    public CircleThread4(Circle myCircle4, int delayTime) {
        super(myCircle4.identification);
        this.myCircle4 = myCircle4;
        this.delayTime = delayTime;
    }

    public String getMyCircle4() {
        return ""+myCircle4;
    }

    public void setMyCircle4(Circle myCircle4) {
        this.myCircle4 = myCircle4;
    }

    public String getDelayTime() {
        return ""+delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }
    
    
    @Override
    public void run() {
        while (true)
        try {
            //sleep for the animation
            sleep(delayTime);
            
//            //move the object
//            Random random = new Random();
            int newY=550;
           
            for (int i = 1; i < 450; i=i+10) {
              
             myCircle4.setPointPosition(new Point(i,newY));
                sleep(delayTime);
                
            }
//            int newX = (int)(random.nextDouble() * 500);
//            int newY = (int)(random.nextDouble() * 500);
            //mySquare.setPointPosition(new Point(newX, newY));
            
            
                        
        } catch (InterruptedException ex) {
            Logger.getLogger(CircleThread4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end run

    
}
