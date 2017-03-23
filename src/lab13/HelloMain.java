/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 22, 2017
* Time: 1:51:18 PM
*
* Project: csci205
* Package: lab13
* File: HelloMain
* Description: Simple Hello world for javafx, exercie 1
*
* ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Simple Hello world for javafx
 *
 * @author Yuxuan Huang
 */
public class HelloMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Show my name!");

        //StackPane root = new StackPane();
        Text textNameOutput = new Text();
        textNameOutput.setFont(Font.font(null, FontWeight.BOLD, 30));

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(15, 15, 15, 15));

        HBox topPane = new HBox(10);
        root.getChildren().add(topPane);
        topPane.getChildren().add(new Label("Your name:"));
        TextField txtNameInput = new TextField();
        topPane.getChildren().add(txtNameInput);

        root.getChildren().add(btn);
        root.getChildren().add(new Separator());
        root.getChildren().add(textNameOutput);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        textNameOutput.setFill(Color.GREEN);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setHeight(5);
        dropShadow.setRadius(2);
        dropShadow.setColor(Color.DARKOLIVEGREEN);
        textNameOutput.setEffect(dropShadow);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textNameOutput.setText(txtNameInput.getText());
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
