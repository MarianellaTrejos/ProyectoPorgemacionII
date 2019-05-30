package domain;


import domain.RunningCharacter;

import Utility.Variables;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.BufferOverflowException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window extends javax.swing.JFrame{

    
    private Thread thread;
    private Scene scene;
    private Pane pane;
    private Canvas canvas;
    private Image image;
    
   
    private RunningCharacter rc;
    
    
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Graphics and Threads");
        initComponents(primaryStage);
        primaryStage.setOnCloseRequest(exit);
        primaryStage.show();
    }

    
    public void run() {
        
        long start;
        long elapsed;
        long wait;
        int fps = 30;
        long time = 1000/fps;

        while(true){
            try {
                start=System.nanoTime();
                elapsed=System.nanoTime()-start;                    
                wait = time-elapsed/1000000;
                Thread.sleep(wait);
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                draw(gc);
            } 
            catch (InterruptedException ex) {}
        }
    }

    private void initComponents(Stage primaryStage) {
        try {
            this.pane = new Pane();
            this.scene = new Scene(this.pane, Variables.WIDTH, Variables.HEIGHT);
            this.canvas = new Canvas(Variables.WIDTH, Variables.HEIGHT);
            this.image = new Image(new FileInputStream("src/Assets/background.png"));
            
            this.pane.getChildren().add(this.canvas);

            primaryStage.setScene(this.scene);
            
            this.rc = new RunningCharacter(1, 500, 0);
            this.rc.start();
            
            //Inicializamos cada hilo (personaje) y lo iniciamos
            
            
            this.thread = new Thread((Runnable) this);
            this.thread.start();
        } 
        catch (FileNotFoundException ex){}
        catch (BufferOverflowException ex){}
    }

    private void draw(GraphicsContext gc){
        gc.clearRect(0, 0, Variables.WIDTH, Variables.HEIGHT);
        gc.drawImage(this.image, 0, 0);
        
        gc.drawImage(this.rc.getImage(), this.rc.getX(), this.rc.getY());
       
    }
    
    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };
}
