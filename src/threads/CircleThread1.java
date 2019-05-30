package threads;

import domain.Point;
import domain.Circle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CircleThread1 extends Thread {

    //variables
    private Circle myCircle1;
    private int delayTime;

    public CircleThread1(Circle myCircle1, int delayTime) {
        super(myCircle1.identification);
        this.myCircle1 = myCircle1;
        this.delayTime = delayTime;
    }

    public String getMyCircle1() {
        return "" + myCircle1;
    }

    public void setMyCircle1(Circle myCircle1) {
        this.myCircle1 = myCircle1;
    }

    public String getDelayTime() {
        return "" + delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "CircleThread1{" + "myCircle1=" + myCircle1 + ", delayTime=" + delayTime + '}';
    }

    @Override
    public void run() {

        try {
            //sleep for the animation
            sleep(delayTime);

            int newY = 50;

            for (int i = 450; i > 1; i = i - 10) {

                myCircle1.setPointPosition(new Point(i, newY));
                sleep(delayTime);

            }

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }//end run

}
