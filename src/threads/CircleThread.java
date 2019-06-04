package threads;

import domain.Point;
import domain.Circle;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import visual.LandFrame;

public class CircleThread extends Thread {

    //variables
    private Circle myCircle;
    private String delayTime;
    private int rail;
    private ArrayList<Circle> array;
    private int value;

    public CircleThread(Circle myCircle, String delayTime, int rail, ArrayList circlelist, int value) {
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

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "CircleThread{" + "myCircle=" + myCircle + ", delayTime=" + delayTime + '}';
    }

    @Override
    public void run() {

        int[] a = {416, 440, 464, 482, 506};
        int barrerX = 260;
        try {
            //Thread.sleep for the animation
//            Thread.sleep(delayTime);
            Random rand = new Random();
     //       int newY = a[rand.nextInt(rail)];
           int newY = a[rail - 1];
            //recta inicio de la carrera
            switch (newY) {
                case 416:

                    for (int i = myCircle.getPointPosition().getX(); i > 200 && LandFrame.revert == false && newY >= 416; i = i - 10) {
                        myCircle.setPointPosition(new Point(i, newY));
                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                        } else {
                            movement();
                        }
                    }
//revert inicio de carrera
                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {
                        myCircle.setPointPosition(new Point(i, newY));
                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");
                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Primera doblada hacia arriba
                    for (int i = myCircle.getPointPosition().getX(); i > 100 && LandFrame.revert == false && newY > 225; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            //newY=newY+5;
//                        newY = newY - 10;
                        } else if (newY > 112 && i > 160) {

                            newY = newY - 5;
                        } else if (newY > 112 && i > 145) {
                            i = i + 5;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 119) {
                            i = i + 7;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 110) {
                            i = i + 9;
                            newY = newY - 5;
                        } else {
                            i = i + 10;
                            newY = newY - 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY + 5;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Segunda doblar hacia arriba     
                    for (int i = myCircle.getPointPosition().getX(); i < 211 && i > 100 && LandFrame.revert == false && newY > 112; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                            //newY = newY - 10;

                        } else if (newY > 112 && i < 113) {
                            i = i - 9;
                            newY = newY - 5;

                        } else if (newY > 112 && i < 149) {
                            i = i - 7;
                            newY = newY - 5;
                        } else {

                            newY = newY - 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//recta izquierda-derecha
                    for (int i = myCircle.getPointPosition().getX(); i < 530 && LandFrame.revert == false && newY == 111; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY + 10));
                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {
                        myCircle.setPointPosition(new Point(i, newY));
                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Primer doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i < 630 && i >= 200 && LandFrame.revert == false && newY < 320; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 416 && i < 550) {
//                    i = i - 8;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 568) {
                            i = i - 6;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 610) {
                            i = i - 4;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 620) {
                            i = i - 9;
                            newY = newY + 5;
                        } else {
                            i = i - 10;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Segundo doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i <= 620 && i > 567 && LandFrame.revert == false && newY < 490; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 490 && i > 610) {
//                    i = i+ 9;
                            newY = newY + 5;
                        } else if (newY < 490 && i > 580) {
                            i = i + 7;
                            newY = newY + 5;
                        } else {
                            i = i + 4;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    break;

//**************************
                case 440:
                    for (int i = myCircle.getPointPosition().getX(); i > 190 && LandFrame.revert == false && newY >= 440; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                        } else {
                            movement();
                        }
                    }
//revert inicio de carrera
                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Primera doblada hacia arriba
                    for (int i = myCircle.getPointPosition().getX(); i > 70 && LandFrame.revert == false && newY > 230; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            //newY=newY+5;
//                        newY = newY - 10;
                        } else if (newY > 112 && i > 140) {

                            newY = newY - 5;
                        } else if (newY > 112 && i > 115) {
                            i = i + 5;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 94) {
                            i = i + 7;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 83) {
                            i = i + 9;
                            newY = newY - 5;
                        } else {
                            i = i + 10;
                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY + 5;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Segunda doblar hacia arriba     
                    for (int i = myCircle.getPointPosition().getX(); i < 211 && i > 82 && LandFrame.revert == false && newY > 95; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                            //newY = newY - 10;

                        } else if (newY > 112 && i < 89) {
                            i = i - 9;
                            newY = newY - 5;

                        } else if (newY > 112 && i < 128) {
                            i = i - 7;
                            newY = newY - 5;
                        } else {

                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//recta izquierda-derecha
                    newY = newY - 5;
                    for (int i = myCircle.getPointPosition().getX(); i < 530 && LandFrame.revert == false && newY == 90; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY + 10));
//                    if(newY>)
//                    i = i + 10;
//                    newY = newY - 10;

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Primer doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i < 680 && i >= 528 && LandFrame.revert == false && newY < 296; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 416 && i < 600) {
//                    i = i - 8;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 618) {
                            i = i - 8;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 633) {
                            i = i - 5;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 652) {
                            i = i - 9;
                            newY = newY + 5;
                        } else {
                            i = i - 10;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Segundo doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i <= 652 && i > 567 && LandFrame.revert == false && newY < 396; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 490 && i > 649) {
                            i = i + 9;
                            newY = newY + 5;
                        } else if (newY < 490 && i > 615) {
                            i = i + 7;
                            newY = newY + 5;
                        } else {
                            i = i + 4;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    break;

//**************************
                case 464:
                    for (int i = myCircle.getPointPosition().getX(); i > 180 && LandFrame.revert == false && newY >= 464; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                        } else {
                            movement();
                        }
                    }
//revert inicio de carrera
                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Primera doblada hacia arriba
                    for (int i = myCircle.getPointPosition().getX(); i > 40 && LandFrame.revert == false && newY > 235; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            //newY=newY+5;
//                        newY = newY - 10;
                        } else if (newY > 112 && i > 120) {

                            newY = newY - 5;
                        } else if (newY > 112 && i > 95) {
                            i = i + 5;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 75) {
                            i = i + 7;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 56) {
                            i = i + 9;
                            newY = newY - 5;
                        } else {
                            i = i + 10;
                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY + 5;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Segunda doblar hacia arriba     
                    for (int i = myCircle.getPointPosition().getX(); i < 193 && i > 55 && LandFrame.revert == false && newY < 235; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                            //newY = newY - 10;

                        } else if (newY > 112 && i < 64) {
                            i = i - 9;
                            newY = newY - 5;

                        } else if (newY > 112 && i < 112) {
                            i = i - 7;
                            newY = newY - 5;
                        } else {

                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//recta izquierda-derecha
                    newY = newY - 5;
                    for (int i = myCircle.getPointPosition().getX(); i < 550 && LandFrame.revert == false && newY == 64; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY + 10));
//                    if(newY>)
//                    i = i + 10;
//                    newY = newY - 10;

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Primer doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i < 680 && i >= 522 && LandFrame.revert == false && newY < 310; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 416 && i < 602) {
//                    i = i - 8;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 640) {
                            i = i - 5;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 660) {
                            i = i - 7;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 675) {
                            i = i - 9;
                            newY = newY + 5;
                        } else {
                            i = i - 10;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 5;
                    //Segundo doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i <= 675 && i > 567 && LandFrame.revert == false && newY < 396; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 490 && i > 671) {
                            i = i + 9;
                            newY = newY + 5;
                        } else if (newY < 490 && i > 615) {
                            i = i + 7;
                            newY = newY + 5;
                        } else {
                            i = i + 4;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    break;
//**************************
                case 482:
                    for (int i = myCircle.getPointPosition().getX(); i > 160 && LandFrame.revert == false && newY >= 482; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                        } else {
                            movement();
                        }
                    }
//revert inicio de carrera
                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Primera doblada hacia arriba
                    for (int i = myCircle.getPointPosition().getX(); i > 20 && LandFrame.revert == false && newY > 235; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            //newY=newY+5;
//                        newY = newY - 10;
                        } else if (newY > 112 && i > 100) {

                            newY = newY - 5;
                        } else if (newY > 112 && i > 75) {
                            i = i + 5;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 45) {
                            i = i + 7;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 30) {
                            i = i + 9;
                            newY = newY - 5;
                        } else {
                            i = i + 10;
                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY + 5;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Segunda doblar hacia arriba     
                    for (int i = myCircle.getPointPosition().getX(); i < 180 && i > 19 && LandFrame.revert == false && newY < 241; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                            //newY = newY - 10;

                        } else if (newY > 112 && i < 42) {
                            i = i - 9;
                            newY = newY - 5;

                        } else if (newY > 100 && i < 101) {
                            i = i - 7;
                            newY = newY - 5;
                        } else {

                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//recta izquierda-derecha
                    newY = newY - 5;
                    for (int i = myCircle.getPointPosition().getX(); i < 550 && LandFrame.revert == false && newY == 42; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY + 10));
//                    if(newY>)
//                    i = i + 10;
//                    newY = newY - 10;

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Primer doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i < 710 && i >= 522 && LandFrame.revert == false && newY < 307; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 416 && i < 637) {
//                    i = i - 8;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 652) {
                            i = i - 5;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 679) {
                            i = i - 7;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 700) {
                            i = i - 9;
                            newY = newY + 5;
                        } else {
                            i = i - 10;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 5;
                    //Segundo doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i <= 700 && i > 567 && LandFrame.revert == false && newY < 400; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 490 && i > 689) {
                            i = i + 9;
                            newY = newY + 5;
                        } else if (newY < 490 && i > 615) {
                            i = i + 7;
                            newY = newY + 5;
                        } else {
                            i = i + 4;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    break;
//**************5*********************************
                case 506:
                    
                    for (int i = myCircle.getPointPosition().getX(); i > 160 && LandFrame.revert == false && newY >= 506; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                        } else {
                            movement();
                        }
                    }
//revert inicio de carrera
                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Primera doblada hacia arriba
                    for (int i = myCircle.getPointPosition().getX(); i > 20 && LandFrame.revert == false && newY > 235; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            //newY=newY+5;
//                        newY = newY - 10;
                        } else if (newY > 112 && i > 100) {

                            newY = newY - 5;
                        } else if (newY > 112 && i > 75) {
                            i = i + 5;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 45) {
                            i = i + 7;
                            newY = newY - 5;
                        } else if (newY > 112 && i > 30) {
                            i = i + 9;
                            newY = newY - 5;
                        } else {
                            i = i + 10;
                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY + 5;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//Segunda doblar hacia arriba     
                    for (int i = myCircle.getPointPosition().getX(); i < 180 && i > 19 && LandFrame.revert == false && newY < 241; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                            //newY = newY - 10;

                        } else if (newY > 112 && i < 42) {
                            i = i - 9;
                            newY = newY - 5;

                        } else if (newY > 100 && i < 101) {
                            i = i - 7;
                            newY = newY - 5;
                        } else {

                            newY = newY - 5;
                        }

                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
//recta izquierda-derecha
                    newY = newY - 5;
                    for (int i = myCircle.getPointPosition().getX(); i < 550 && LandFrame.revert == false && newY == 42; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY + 10));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
                            newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 10;
                    //Primer doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i < 710 && i >= 522 && LandFrame.revert == false && newY < 307; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 416 && i < 637) {
//                    i = i - 8;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 652) {
                            i = i - 5;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 679) {
                            i = i - 7;
                            newY = newY + 5;
                        } else if (newY < 416 && i < 700) {
                            i = i - 9;
                            newY = newY + 5;
                        } else {
                            i = i - 10;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    newY = newY + 5;
                    //Segundo doblar hacia abajo
                    for (int i = myCircle.getPointPosition().getX(); i <= 700 && i > 567 && LandFrame.revert == false && newY < 400; i = i - 10) {

                        myCircle.setPointPosition(new Point(i, newY));
//                    

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else if (newY < 490 && i > 689) {
                            i = i + 9;
                            newY = newY + 5;
                        } else if (newY < 490 && i > 615) {
                            i = i + 7;
                            newY = newY + 5;
                        } else {
                            i = i + 4;
                            newY = newY + 5;
                        }
                        if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i + 10;
//                    newY = newY - 10;
                        } else {
                            movement();
                        }
                    }

                    for (int i = myCircle.getPointPosition().getX(); i < 730 && LandFrame.revert == true; i = i + 10) {

                        myCircle.setPointPosition(new Point(i, newY));

                        if (LandFrame.interruption == true) {
                            System.out.println("interrupción");
                            Thread.sleep(500);
                            i = i - 10;
                        } else if (LandFrame.State == true && i == barrerX) {
                            System.out.println("barrera");

                            Thread.sleep(500);
                            i = i - 10;
                        } else {
                            movement();
                        }
                    }
                    break;
            }

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }//end run

    public int velocity() {

        if (delayTime.equalsIgnoreCase("Slow")) {
            int num = (int) (Math.random() * 600) + 500;
            return num;
        } else if (delayTime.equalsIgnoreCase("Medium")) {
            int num = (int) (Math.random() * 400) + 250;
            return num;
        } else if (delayTime.equalsIgnoreCase("Fast")) {
            int num = (int) (Math.random() * 200) + 150;
            return num;
        } else if (delayTime.equalsIgnoreCase("Very Fast")) {
            int num = (int) (Math.random() * 100) + 10;
            return num;
        }
        return 0;
    }

    private boolean place() {
        for (int j = 0; j < array.size() - 1; j++) {

            if (array.get(j).getPointPosition().getX() + 10 == array.get(j + 1).getPointPosition().getX()
                    && array.get(j).getPointPosition().getY() == array.get(j + 1).getPointPosition().getY()) {
                return false;
            }
        }
        return true;
    }

    private void movement() {
        try {
            if (delayTime.equalsIgnoreCase("Slow")) {
                if (value != 1) {
                    if (place() == false) {
                        Thread.sleep(8000);
                    } else {
                        Thread.sleep(velocity());
                    }
                } else {
                    Thread.sleep(velocity());
                }
            } else if (delayTime.equalsIgnoreCase("Medium")) {
                if (value != 1) {
                    if (place() == false) {
                        Thread.sleep(4000);
                    } else {
                        Thread.sleep(velocity());
                    }
                } else {
                    Thread.sleep(velocity());
                }
            } else if (delayTime.equalsIgnoreCase("Fast")) {
                if (value != 1) {
                    if (place() == false) {
                        Thread.sleep(2500);
                    } else {
                        Thread.sleep(velocity());
                    }
                } else {
                    Thread.sleep(velocity());
                }
            } else if (delayTime.equalsIgnoreCase("Very Fast")) {
                if (value != 1) {
                    if (place() == false) {
                        Thread.sleep(1000);
                    } else {
                        Thread.sleep(velocity());
                    }
                } else {
                    Thread.sleep(velocity());
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CircleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
