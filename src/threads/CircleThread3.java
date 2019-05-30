
package threads;

import domain.Point;
import domain.Circle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CircleThread3 extends Thread{
    
    //variables
    private Circle myCircle3;
    private int delayTime;

    public CircleThread3(Circle myCircle3, int delayTime) {
        super(myCircle3.identification);
        this.myCircle3 = myCircle3;
        this.delayTime = delayTime;
    }

    public String getMyCircle3() {
        return ""+myCircle3;
    }

    public void setMyCircle3(Circle myCircle3) {
        this.myCircle3 = myCircle3;
    }

    public String getDelayTime() {
        return ""+delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "CircleThread3{" + "myCircle3=" + myCircle3 + ", delayTime=" + delayTime + '}';
    }
    
    
    @Override
    public void run() {
        while (true)
        try {
            //sleep for the animation
            sleep(delayTime);
            
//            //move the object
//            Random random = new Random();
            int newY=450;
           
            for (int i = 1; i < 450; i=i+10) {
              
             myCircle3.setPointPosition(new Point(i,newY));
                sleep(delayTime);
                
            }
//            int newX = (int)(random.nextDouble() * 500);
//            int newY = (int)(random.nextDouble() * 500);
            //mySquare.setPointPosition(new Point(newX, newY));
            
            
                        
        } catch (InterruptedException ex) {
            Logger.getLogger(CircleThread3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end run

    
}
