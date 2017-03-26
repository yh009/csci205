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

import javafx.beans.binding.NumberBinding;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 *
 * @author mac
 */
public class TrafficLightController {

    private final TrafficLightView theView;
    //private TrafficLightModel theModel;

    public TrafficLightController(TrafficLightView theView) {
        this.theView = theView;
        //this.theModel = theModel;
        NumberBinding radBinding = theView.getRootNode().heightProperty().divide(
                6).add(-15);
        for (Circle c : theView.getCircles()) {
            c.radiusProperty().bind(radBinding);
        }

        //theModel.getIsOnProperty().bind(theView.getCircles().);
    }

    public void handler(MouseEvent event) {

    }

}
