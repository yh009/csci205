/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 9:24:13 PM
*
* Project: csci205
* Package: lab13.trafficlightmvc
* File: TrafficLightModel
* Description:
*
* ****************************************
 */
package lab13.trafficlightmvc;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author mac
 */
public enum TrafficLightModel {
    RED, YELLOW, GREEN, DARKRED, DARKKHAKI, DARKGREEN;

    private BooleanProperty isOn;

    private TrafficLightModel() {
        isOn = new SimpleBooleanProperty(false);
    }

    public void toggle() {
        isOn.set(!isOn.get());
    }

    public boolean isLightOn() {
        return isOn.get();
    }

    public BooleanProperty getIsOnProperty() {
        return isOn;
    }
}
