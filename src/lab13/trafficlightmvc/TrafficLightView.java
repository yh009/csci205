/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 9:31:08 PM
*
* Project: csci205
* Package: lab13.trafficlightmvc
* File: TrafficLightView
* Description:
*
* ****************************************
 */
package lab13.trafficlightmvc;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author mac
 */
public class TrafficLightView {

    private VBox root;
    private ArrayList<Circle> lights;

    public TrafficLightView() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(300);
        lights = new ArrayList<>();
        Circle lr = new Circle(50, Paint.valueOf("DARKRED"));
        Circle ly = new Circle(50, Paint.valueOf("DARKKHAKI"));
        Circle lg = new Circle(50, Paint.valueOf("DARKGREEN"));
        lr.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        lights.add(lr);
        lights.add(ly);
        lights.add(lg);
        root.getChildren().addAll(lights);

    }

    public VBox getRootNode() {
        return root;
    }

    public ArrayList<Circle> getCircles() {
        return lights;
    }

}
