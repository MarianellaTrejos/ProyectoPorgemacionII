/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.placeholder.PlaceHolder;
import data.XMLThreadManager;
import domain.Circle;
import domain.Point;
import domain.RunningCharacter;
import domain.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdom.JDOMException;
import threads.CircleThread;
import threads.RepaintLandThread;

/**
 *
 * @author Fabian
 */
public class LandFrame extends JFrame {

    Image image = new ImageIcon("src/Assets/prograII.png").getImage();
    public int a = 1;//1 significa hacia la derecha o que puede proceder (en caso de interruption) / 0 siginifica hacia la izquierda o que tiene que parar (interruption
    //variables
    public ArrayList<Circle> myCircles;

    JButton create;
    JButton Revert;
    JButton Simulation;
    JButton Interruption;
    JButton Barrer;
    JTextField Value;
    JTextField rails;
    JComboBox Speed;
    JComboBox comp;
    PlaceHolder holder;
    public static boolean State;
    public static boolean revert;
    public static boolean interruption;
    public static int createN;

    public LandFrame() {
    }

    //constructor
    public LandFrame(ArrayList<Circle> myCircles) {
        super("Shape");
        this.State = false;
        this.revert = false;
        this.interruption = false;
        this.myCircles = myCircles;
    
        this.createN = 1;
//        this.setSize(500, 500);

        setBounds(270, 0, 800, 700);
        this.setVisible(true);
        create = new JButton("Create");
        getContentPane().add(create);
        this.create.setBounds(600, 550, 100, 30);

        Revert = new JButton("Revert");
        getContentPane().add(Revert);
        this.Revert.setBounds(150, 550, 100, 30);

        Simulation = new JButton("Simulation");
        getContentPane().add(Simulation);
        this.Simulation.setBounds(300, 550, 100, 30);

        Interruption = new JButton("Interruption");
        getContentPane().add(Interruption);
        this.Interruption.setBounds(450, 550, 100, 30);

        Barrer = new JButton("Barrer");
        getContentPane().add(Barrer);
        this.Barrer.setBounds(0, 600, 100, 30);

        Value = new JTextField("");
        holder = new PlaceHolder(Value, "Value");
        getContentPane().add(Value);
        Value.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
//        Value.p().addListener((observable, oldValue, newValue) -> {
//            if (!newValue.matches("\\d*")) {
//                tfNum.setText(newValue.replaceAll("[^\\d]", ""));
//            }
//        });
        this.Value.setBounds(150, 600, 100, 30);

        rails = new JTextField("");
        holder = new PlaceHolder(rails, "Rails");
        getContentPane().add(rails);
        this.rails.setBounds(300, 600, 100, 30);
        rails.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });

        String[] speeds = {"--Select Speed--", "Slow", "Medium", "Fast", "Very Fast"};
        Speed = new JComboBox(speeds);
        getContentPane().add(Speed);
        Speed.setSelectedIndex(0);
        this.Speed.setBounds(450, 600, 100, 30);
//        Object inicial = "--Select Speed--";
//        
        String[] figure = {"--Select--", "Figure", "Image"};
        comp = new JComboBox(figure);
        comp.setSelectedIndex(0);
        getContentPane().add(comp);
        this.comp.setBounds(600, 600, 100, 30);
//        comp.setSize(100, 30);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String valueS = Value.getText();
                String railsS = rails.getText();
                String speedS = Speed.getSelectedItem().toString();
                String figure = comp.getSelectedItem().toString();
                if (!valueS.equalsIgnoreCase("") && !railsS.equalsIgnoreCase("") && !speedS.equalsIgnoreCase("--Select Speed--") && !figure.equalsIgnoreCase("--Select--")) {
                    int rail = Integer.parseInt(railsS);
                    int value = Integer.parseInt(valueS);

                    if (figure.equalsIgnoreCase("Figure")) {
                        switch (createN) {
                            case 1:
                                for (int i = 0; i < value; i++) {

                                    Circle cir = new Circle("Circulo" + i, new Point(730, 500), 20);
                                    myCircles.add(cir);
                                }

                                for (int i = 0; i < value; i++) {
                                    try {
                                        XMLThreadManager manager = new XMLThreadManager("Threads.xml");

                                        CircleThread CircleThread1 = new CircleThread(myCircles.get(i), speedS, rail, myCircles, value);
                                        manager.insertThread(CircleThread1);
                                        CircleThread1.start();
                                    } catch (IOException | JDOMException ex) {
                                        System.out.println(ex.getMessage());
                                    }

                                }
                                createN = createN + 1;
                                break;
                            case 2:
                                int lastlist = myCircles.size();
                                for (int i = value; i > 0; i--) {

                                    Circle cir = new Circle("Circulo" + i, new Point(730, 500), 20);
                                    myCircles.add(cir);
                                }

                                for (int i = myCircles.size() - 1; i > lastlist - 1; i--) {
                                    try {
                                        XMLThreadManager manager = new XMLThreadManager("Threads.xml");

                                        CircleThread CircleThread1 = new CircleThread(myCircles.get(i), speedS, rail, myCircles, value);
                                        manager.insertThread(CircleThread1);
                                        CircleThread1.start();
                                    } catch (IOException | JDOMException ex) {
                                        System.out.println(ex.getMessage());
                                    }

                                }
                                createN = createN + 1;
                                break;
                            case 3:
                                lastlist = myCircles.size();
                                for (int i = value; i > 0; i--) {

                                    Circle cir1 = new Circle("Circ" + i, new Point(730, 500), 20);
                                    myCircles.add(cir1);
                                }

                                for (int i = myCircles.size() - 1; i > lastlist - 1; i--) {
                                    try {
                                        XMLThreadManager manager = new XMLThreadManager("Threads.xml");

                                        CircleThread CircleThread2 = new CircleThread(myCircles.get(i), speedS, rail, myCircles, value);
                                        manager.insertThread(CircleThread2);
                                        CircleThread2.start();
                                    } catch (IOException | JDOMException ex) {
                                        System.out.println(ex.getMessage());
                                    }

                                }
                                createN = createN + 1;
                                break;
                            case 4:
                                lastlist = myCircles.size();
                                for (int i = value; i > 0; i--) {

                                    Circle cir2 = new Circle("Circul" + i, new Point(730, 500), 20);
                                    myCircles.add(cir2);
                                }

                                for (int i = myCircles.size() - 1; i > lastlist - 1; i--) {
                                    try {
                                        XMLThreadManager manager = new XMLThreadManager("Threads.xml");

                                        CircleThread CircleThread3 = new CircleThread(myCircles.get(i), speedS, rail, myCircles, value);
                                        manager.insertThread(CircleThread3);
                                        CircleThread3.start();
                                    } catch (IOException | JDOMException ex) {
                                        System.out.println(ex.getMessage());
                                    }

                                }
                                createN = createN + 1;
                                break;
                            case 5:
                                lastlist = myCircles.size();
                                for (int i = value; i > 0; i--) {

                                    Circle cir3 = new Circle("Circ" + i, new Point(730, 100), 20);
                                    myCircles.add(cir3);
                                }

                                for (int i = myCircles.size() - 1; i > lastlist - 1; i--) {
                                    try {
                                        XMLThreadManager manager = new XMLThreadManager("Threads.xml");

                                        CircleThread CircleThread4 = new CircleThread(myCircles.get(i), speedS, rail, myCircles, value);
                                        manager.insertThread(CircleThread4);
                                        CircleThread4.start();
                                    } catch (IOException | JDOMException ex) {
                                        System.out.println(ex.getMessage());
                                    }

                                }
                                createN = createN + 1;
                                break;
                        }
                        Value.setText("");
                        rails.setText("");
                        Speed.setSelectedIndex(0);
                        comp.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceso imagen ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe completar todos los espacios para continuar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        Revert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (revert == false) {
                    revert = true;

                    System.out.println("true");
                } else {
                    revert = false;

                    System.out.println("false");
                }

            }
        });
        Barrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (State == false) {
                    State = true;

                    System.out.println("true");
                } else {
                    State = false;

                    System.out.println("false");
                }

            }
        });
        Simulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Circle cir1 = new Circle("Thread-1", new Point(0, 50), 60);
                Circle cir2 = new Circle("Thread-2", new Point(0, 50), 60);
                Circle cir3 = new Circle("Thread-3", new Point(0, 50), 60);
                Circle cir4 = new Circle("Thread-4", new Point(0, 50), 60);
                Circle cir5 = new Circle("Thread-5", new Point(0, 50), 60);
                Circle cir6 = new Circle("Thread-6", new Point(0, 50), 60);
                Circle cir7 = new Circle("Thread-7", new Point(0, 50), 60);
                Circle cir8 = new Circle("Thread-8", new Point(0, 50), 60);
                Circle cir9 = new Circle("Thread-9", new Point(0, 50), 60);
                Circle cir10 = new Circle("Thread-10", new Point(0, 50), 60);
                ArrayList<Circle> CircleList = new ArrayList<>();
//                    CircleList.add(cir1);
//                    CircleList.add(cir2);
//                    CircleList.add(cir3);
//                    CircleList.add(cir4);

//for (int i = 0; i <1; i++) 
                myCircles.add(cir1);

                myCircles.add(cir2);

//                    myCircles.add(cir3);
//                   myCircles.add(cir4);
//                    myCircles.add(cir5);
//                    myCircles.add(cir6);
//                    myCircles.add(cir7);int valueSimu = rd.nextInt(2)+1;
//                    myCircles.add(cir8);
//                    myCircles.add(cir9);
//                    myCircles.add(cir10);
//                    }
                Random rd = new Random();
                int valueSimu = rd.nextInt(2) + 1;
                String arreglo[] = {"Slow", "Medium", "Fast", "Very Fast"};
                int arrV[] = {1, 2};
                for (int i = 0; i < valueSimu; i++) {

                    int circle = rd.nextInt(1);
                    int velocity = rd.nextInt(3);
                    int rails = rd.nextInt(1) + 1;

                    CircleThread CircleThread7 = new CircleThread(myCircles.get(i), arreglo[velocity], rails, myCircles, 2);
                    CircleThread7.start();
                }
            }
        });
        Interruption.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {
                if (interruption == false) {
                    interruption = true;

                    System.out.println("true");
                } else {
                    interruption = false;

                    System.out.println("false");
                }

            }
        });

    }

//    private void draw(Graphics g) {
//        setBackground(Color.black);
//
//        g.drawLine(300, 0, 300, 100);
//
//        g.setColor(colorx());
//    }
//
//    protected void paintComponent(Graphics g) {
//
//        draw(g);
//
//    }
    @Override

    public void paint(Graphics g) {
//        
//        super.paint(g);
        g.drawImage(image, 0, 30, 770, 500, this);

//        super.paint(g);
        //iterate over all circles
        for (Circle myCircle : myCircles) {
            g.setColor(Color.red);
//            g.setColor(colorx());
            g.fillOval(myCircle.getPointPosition().getX(), myCircle.getPointPosition().getY(), myCircle.getSide(), myCircle.getSide());
//            g.drawLine(0, 110, 600, 110);
//            g.drawLine(0, 175, 600, 175);
//            g.drawLine(0, 310, 600, 310);

        } //end for
    }

    public void paint1(Graphics g) {
        g.drawImage(image, 0, 0, 580, 430, this);
        super.paint(g);
        g.drawImage(image, 0, 0, 580, 430, this);
    }

    public Color colorx() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void paintAgain() {
        repaint();
    }

}
