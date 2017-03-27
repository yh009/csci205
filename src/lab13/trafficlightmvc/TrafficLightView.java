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
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author mac
 */
public class TrafficLightView {

    private VBox root;
    private ArrayList<Circle> lights;
    private ArrayList<Color> colors;
    //private TrafficLightModel theModel;
    public Color red;
    public Color yellow;
    public Color green;

    public TrafficLightView() {
        //this.theModel = theModel;
        red = Color.DARKRED;
        yellow = Color.DARKKHAKI;
        green = Color.DARKGREEN;
        colors = new ArrayList<>();
        colors.add(red);
        colors.add(yellow);
        colors.add(green);

        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(300);
        lights = new ArrayList<>();
        Circle lr = new Circle(50, colors.get(0));
        Circle ly = new Circle(50, colors.get(1));
        Circle lg = new Circle(50, colors.get(2));
        //lr.setOnMouseClicked(new TrafficLightController(this));
        //ly.setOnMouseClicked(new TrafficLightController(this));
        //lg.setOnMouseClicked(new TrafficLightController(this));
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

    public ArrayList<Color> getColors() {
        return colors;
    }

}
