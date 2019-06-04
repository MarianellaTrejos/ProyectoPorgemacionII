/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsandgraphics;

import data.XMLThreadManager;
import visual.LandFrame;
import threads.RepaintLandThread;
import threads.CircleThread;
import domain.Point;
import domain.Circle;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jdom.JDOMException;


public class ThreadsAndGraphics {

    public static ArrayList<Circle> CircleList = new ArrayList<>();


    public static void main(String[] args) throws IOException, JDOMException {

        LandFrame myLand = new LandFrame(CircleList);

        myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //thread for repainting
        RepaintLandThread repaintThread = new RepaintLandThread(myLand, 200);
        repaintThread.start();
        

    }//end main
    
}
