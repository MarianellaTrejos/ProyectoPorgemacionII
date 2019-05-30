package threads;

import domain.Point;
import domain.Circle;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import visual.LandFrame;

public class CircleThread extends Thread {

    //variables
    private Circle myCircle;
    private int delayTime;
    private int rail;
    private ArrayList<Circle> array;
    private int value;
    private boolean State;

    public CircleThread(boolean State) {

        this.State = State;
    }

    public CircleThread(Circle myCircle, int delayTime, int rail, ArrayList circlelist, int value) {
        super(myCircle.identification);
        this.myCircle = myCircle;
        this.delayTime = delayTime;
        this.rail = rail;
        this.array = circlelist;
        this.value = value;
    }

    public String getMyCircle() {
        return "" + myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public String getDelayTime() {
        return "" + delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "CircleThread{" + "myCircle=" + myCircle + ", delayTime=" + delayTime + '}';
    }

    @Override
    public void run() {
        LandFrame l = new LandFrame();
        int[] a = {50, 110, 150, 210, 250, 300};
        int barrerX = 300;
        try {
            //sleep for the animation
            sleep(delayTime);
            Random rand = new Random();
            int newY = a[rand.nextInt(rail)];
            int d = -1;
            while (d != 0 && d != 500) {
                for (int i = myCircle.getPointPosition().getX(); i < 610 && LandFrame.revert == false; i = i + 10) {

                    myCircle.setPointPosition(new Point(i, newY));
                    d = d + 1;
                     if (LandFrame.interruption == true) {
                        System.out.println("interrupción");
                          sleep(500);
                        i = i - 10;
                     }else if (LandFrame.State == true && i == barrerX) {
                        System.out.println("barrera");
                        
                        sleep(500);
                        i = i - 10;
                    } else {
                        if (delayTime == 100) {

                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 600) + 500;

                                    sleep(num);
                                } else {
                                    sleep(8000);

                                }

                            }

                        } else if (delayTime == 200) {
                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 400) + 250;
                                    sleep(num);
                                } else {
                                    sleep(4000);
                                }
                            }
                        } else if (delayTime == 300) {
                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 200) + 150;
                                    sleep(num);
                                } else {
                                    sleep(2500);
                                }
                            }
                        } else if (delayTime == 400) {
                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 100) + 10;
                                    sleep(num);
                                } else {
                                    sleep(1000);
                                }
                            }
                        }
                    }
                }

                for (int i = myCircle.getPointPosition().getX(); i > 0 && LandFrame.revert == true; i = i - 10) {

                    myCircle.setPointPosition(new Point(i, newY));
                    d = d - 1;
                     if (LandFrame.interruption == true) {
                        System.out.println("interrupción");
                          sleep(500);
                        i = i +10;
                     }else if (LandFrame.State == true && i == barrerX) {
                        System.out.println("barrera");

                        sleep(500);
                        i = i + 10;
                    } else {
                        if (delayTime == 100) {

                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 600) + 500;

                                    sleep(num);
                                } else {
                                    sleep(8000);

                                }

                            }

                        } else if (delayTime == 200) {
                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 400) + 250;
                                    sleep(num);
                                } else {
                                    sleep(4000);
                                }
                            }
                        } else if (delayTime == 300) {
                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 200) + 150;
                                    sleep(num);
                                } else {
                                    sleep(2500);
                                }
                            }
                        } else if (delayTime == 400) {
                            for (int j = 0; j < value - 1; j++) {

                                if (array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()
                                        || array.get(j).getPointPosition().getX() + 10 != array.get(j + 1).getPointPosition().getX()
                                        && array.get(j).getPointPosition().getY() != array.get(j + 1).getPointPosition().getY()) {

                                    int num = (int) (Math.random() * 100) + 10;
                                    sleep(num);
                                } else {
                                    sleep(1000);
                                }
                            }
                        }
                    }
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(CircleThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//end run

}
