/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 9:49:35 PM
*
* Project: csci205
* Package: lab13.trafficlightmvc
* File: TraffficLightController
* Description:
*
* ****************************************
 */
package lab13.trafficlightmvc;

//import java.awt.event.MouseEvent;
import javafx.beans.binding.NumberBinding;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author mac
 */
public class TrafficLightController implements EventHandler<MouseEvent> {

    private final TrafficLightView theView;
    //private TrafficLightModel red;

    public TrafficLightController(TrafficLightView theView) {
        //this.red = TrafficLightModel();
        this.theView = theView;

        //this.theModel = theModel;
        NumberBinding radBinding = theView.getRootNode().heightProperty().divide(
                6).add(-15);
        for (Circle c : theView.getCircles()) {
            c.radiusProperty().bind(radBinding);
        }

        this.theView.getCircles().get(0).setOnMouseClicked(this);
        this.theView.getCircles().get(1).setOnMouseClicked(this);
        this.theView.getCircles().get(2).setOnMouseClicked(this);
        //this.theView.getRootNode().setOnMouseClicked(this);
        //theModel.getIsOnProperty().bind(theView.getCircles().);
    }

    @Override
    public void handle(MouseEvent event) {
        //if (event.equals(MouseEvent.MOUSE_CLICKED)) {
        //Point p = event.
        int i = this.theView.getCircles().indexOf(event.getSource());
        System.out.printf("clicked! %f,%f\n", event.getX(), event.getY());
        //for (int i = 0; i < this.theView.getCircles().size(); i++) {
        //if (this.theView.getCircles().get(i).contains(event.,
        //event.getScreenY()) == true) {
        //System.out.printf("%d, %f, %f\n", i, event.getX(),
        //event.getY()
        // );
        if (TrafficLightModel.values()[i].isLightOn() == false) {
            this.theView.getCircles().get(i).setFill(Paint.valueOf(
                    TrafficLightModel.values()[i].toString()));
            System.out.printf("%d, brighter!\n", i);

            TrafficLightModel.values()[i].toggle();

        }
        else {
            this.theView.getCircles().get(i).setFill(Paint.valueOf(
                    TrafficLightModel.values()[i + 3].toString()));
            System.out.printf("%d, darker!\n", i);
            TrafficLightModel.values()[i].toggle();
        }

    }
}

//}
//}

//}
