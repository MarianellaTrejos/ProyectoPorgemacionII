
package threads;

import domain.Point;
import domain.Circle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CircleThread2 extends Thread{
    
    //variables
    private Circle myCircle2;
    private int delayTime;

    public CircleThread2(Circle myCircle2, int delayTime) {
        super(myCircle2.identification);
        this.myCircle2 = myCircle2;
        this.delayTime = delayTime;
    }

    public String getMyCircle2() {
        return ""+myCircle2;
    }

    public void setMyCircle2(Circle myCircle2) {
        this.myCircle2 = myCircle2;
    }

    public String getDelayTime() {
        return ""+delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "CircleThread2{" + "myCircle2=" + myCircle2 + ", delayTime=" + delayTime + '}';
    }
    
    
    @Override
    public void run() {
        while (true)
        try {
            //sleep for the animation
            sleep(delayTime);
            
//            //move the object
//            Random random = new Random();
            int newY=300;
           
            for (int i = 1; i < 450; i=i+10) {
              
             myCircle2.setPointPosition(new Point(i,newY));
                sleep(delayTime);
                
            }
//            int newX = (int)(random.nextDouble() * 500);
//            int newY = (int)(random.nextDouble() * 500);
            //mySquare.setPointPosition(new Point(newX, newY));
            
            
                        
        } catch (InterruptedException ex) {
            Logger.getLogger(CircleThread2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end run

    
}
