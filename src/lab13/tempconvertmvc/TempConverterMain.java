/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 3:04:45 PM
*
* Project: csci205
* Package: lab13.tempconvertmvc
* File: TempConverter
* Description:
*
* ****************************************
 */
package lab13.tempconvertmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TempConverter - a very basic JavaFX application to perform a simple
 * temperature conversion
 *
 */
public class TempConverterMain extends Application {

    private TempConverterModel theModel;
    private TempConverterView theView;
    private TempConverterController theCtrl;

    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.theModel = new TempConverterModel();
        this.theView = new TempConverterView(theModel);
        this.theCtrl = new TempConverterController(theModel, theView);

    }

    /**
     * start - the primary method that is called by the JavaFX application to
     * set up the initial stage
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        // Now, set up the scene, and connect it to the stage!
        Scene scene = new Scene(this.theView.getRootNode());

        primaryStage.setTitle(
                "Temperature Calculator");
        primaryStage.setScene(scene);

        primaryStage.sizeToScene();

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
