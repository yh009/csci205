/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 23, 2017
* Time: 12:36:02 AM
*
* Project: csci205
* Package: lab13
* File: SimpleTree
* Description: Intro to Javafx, exercise 3
*
* ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * The simple tree graph
 *
 * @author Yuxuan Huang
 */
public class SimpleTree extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.DARKGREY);

        RectTreeNode r1 = new RectTreeNode(Color.BLUE);
        r1.setX(200);
        r1.setY(100);
        RectTreeNode r2 = new RectTreeNode(Color.LIGHTBLUE);
        r2.setX(75);
        r2.setY(250);
        RectTreeNode r3 = new RectTreeNode(Color.LIGHTBLUE);
        r3.setX(325);
        r3.setY(250);

        Line line1to2 = new Line();
        line1to2.setStrokeWidth(3);
        updateLinePosition(line1to2, r1, r2);

        Line line1to3 = new Line();
        line1to3.setStrokeWidth(3);
        updateLinePosition(line1to3, r1, r3);

        root.getChildren().addAll(line1to2, line1to3);
        root.getChildren().addAll(r1, r2, r3);

        primaryStage.setTitle("Shapes Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Helper function for align the lines
     *
     * @param line - the line object to be aligned
     * @param r1 - from node
     * @param r2 - to node
     */
    private void updateLinePosition(Line line, RectTreeNode r1, RectTreeNode r2) {
        line.setStartX(r1.getX() + r1.getWidth() / 2);
        line.setStartY(r1.getY() + r1.getHeight() / 2);
        line.setEndX(r2.getX() + r2.getWidth() / 2);
        line.setEndY(r2.getY() + r2.getHeight() / 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
