/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 9:29:31 PM
*
* Project: csci205
* Package: lab13.trafficlightmvc
* File: TrafficLightMain
* Description:
*
* ****************************************
 */
package lab13.trafficlightmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mac
 */
public class TrafficLightMain extends Application {

    private TrafficLightView theView;
    private TrafficLightController theCtrl;
    //private TrafficLightModel theModel;

    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new TrafficLightView();
        this.theCtrl = new TrafficLightController(this.theView);
        //this.theModel = new TrafficLightModel();
    }

    @Override
    public void start(Stage primaryStage) {

        //theCtrl = new TrafficLightController(theView);
        Scene scene = new Scene(theView.getRootNode());
        primaryStage.sizeToScene();

        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
