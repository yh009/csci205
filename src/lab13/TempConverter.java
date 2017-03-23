/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 22, 2017
* Time: 10:53:21 PM
*
* Project: csci205
* Package: lab13
* File: TempConverter
* Description: Temperature converter, exercise 2
*
* ****************************************
 */
package lab13;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The temperature converter class
 *
 * @author Yuxuan Huang
 */
public class TempConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Convert!");

        //StackPane root = new StackPane();
        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 5, 10, 5));

        root.setPrefWidth(250);

        FlowPane fp = new FlowPane(Orientation.HORIZONTAL);
        fp.setAlignment(Pos.CENTER);
        fp.setHgap(10);
        fp.getChildren().add(new Label("Temperature (F):"));

        final TextField txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        fp.getChildren().add(txtFieldTempInput);

        Label TempOutput = new Label("");
        TempOutput.setPrefWidth(100);
        TempOutput.setPrefHeight(25);
        TempOutput.setAlignment(Pos.CENTER);
        //TempOutput.setFont(Font.font(null, FontWeight.BOLD, 30));

        Border outputBox = new Border(new BorderStroke(Color.BLACK,
                                                       BorderStrokeStyle.SOLID,
                                                       CornerRadii.EMPTY,
                                                       BorderWidths.DEFAULT
        ));
        TempOutput.setBorder(outputBox);

        root.getChildren().add(fp);
        root.getChildren().add(TempOutput);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    String fDegree = txtFieldTempInput.getText();
                    DecimalFormat df = new DecimalFormat("#.00");
                    double fDegreeD = Double.parseDouble(fDegree);
                    double cDegreeD = (fDegreeD - 32.0) / 1.8;
                    String cDegree = df.format(cDegreeD) + " C";
                    TempOutput.setText(cDegree);
                } catch (NumberFormatException numberFormatException) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Incorrect input!");
                    alert.setHeaderText("Incorrect input specified!");
                    alert.setContentText(String.format("Cannot convert \"%s\"",
                                                       txtFieldTempInput.getText()));
                    alert.show();
                }

            }
        });

        txtFieldTempInput.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    String fDegree = txtFieldTempInput.getText();
                    DecimalFormat df = new DecimalFormat("#.00");
                    double fDegreeD = Double.parseDouble(fDegree);
                    double cDegreeD = (fDegreeD - 32.0) / 1.8;
                    String cDegree = df.format(cDegreeD) + " C";
                    TempOutput.setText(cDegree);
                } catch (NumberFormatException numberFormatException) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Incorrect input!");
                    alert.setHeaderText("Incorrect input specified!");
                    alert.setContentText(String.format("Cannot convert \"%s\"",
                                                       txtFieldTempInput.getText()));
                    alert.show();
                }

            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
