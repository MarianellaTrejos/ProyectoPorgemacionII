package domain;

import Interface.Window;
import java.io.IOException;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

public class Interface {

    VBox vbWindows, vbMain;

    public Scene ThreadCompetition() {

        GridPane GpInsert = new GridPane();
        GpInsert.setVgap(15);
        GpInsert.setHgap(15);
        GpInsert.setMinSize(900, 500);
        GpInsert.setAlignment(Pos.CENTER);
        vbMain = new VBox();
        vbWindows = new VBox();
        VBox prueba = new VBox();
        TextArea taprueba = new TextArea();
//        prueba.setMinSize(600,400);

        GpInsert.add(prueba, 1, 1);
        Scene Scene = new Scene(vbMain, 900, 500);
        Label lblTitle = new Label("Thread Competition");
        lblTitle.setFont(Font.font("Cambria", 25));
        GpInsert.add(lblTitle, 0, 0);

        Button btnCreate = new Button("Create");
        GpInsert.add(btnCreate, 0, 14);

        Button btnRevert = new Button("Revert");
        GpInsert.add(btnRevert, 1, 14);

        Button btnSimulation = new Button("Simulation");
        GpInsert.add(btnSimulation, 2, 14);

        Button btnBarrer = new Button("Barrer");
        GpInsert.add(btnBarrer, 3, 14);

        Button btnInterruption = new Button("Interruption");
        GpInsert.add(btnInterruption, 4, 14);

        final ComboBox cbSpeed = new ComboBox();
        cbSpeed.setValue("--Select Speed--");
        cbSpeed.getItems().add("Slow");
        cbSpeed.getItems().add("Medium");
        cbSpeed.getItems().add("Fast");
        cbSpeed.getItems().add("Very fast");
        GpInsert.add(cbSpeed, 0, 15);

        TextField tfValue = new TextField();
        tfValue.setPromptText("Value");
        GpInsert.add(tfValue, 1, 15);

        TextField tfRails = new TextField();
        tfRails.setPromptText("Rails");
        GpInsert.add(tfRails, 2, 15);

        final ComboBox cbThreads = new ComboBox();
        cbThreads.setValue("--Select--");
        cbThreads.getItems().add("Figures");
        cbThreads.getItems().add("Images");
        GpInsert.add(cbThreads, 3, 15);

        btnCreate.setOnAction((event) -> {
            Window w = new Window();
            String Speed = cbSpeed.getValue().toString();
            String railsS = tfRails.getText();
            String thread = cbThreads.getValue().toString();
            String ValueS = tfValue.getText();

            if (!Speed.equals("--Select Speed--") && !ValueS.equals("") && !railsS.equals("") && !thread.equals("--Select--")) {
                int rails = Integer.parseInt(railsS);
                int value = Integer.parseInt(ValueS);
                GraphicsContext gc = null;
                for (int i = 1; i <= rails; i++) {
                    
                }
                cbSpeed.setValue("--Select Speed--");
                cbThreads.setValue("--Select--");
                tfRails.setText("");
                tfValue.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Debe completar todos los espacios para continuar", "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        ((VBox) Scene.getRoot()).getChildren().addAll(vbWindows, GpInsert);
        return Scene;

    }

}
