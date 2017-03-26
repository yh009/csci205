/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 3:10:42 PM
*
* Project: csci205
* Package: lab13.tempconvertmvc
* File: TempConverterController
* Description:
*
* ****************************************
 */
package lab13.tempconvertmvc;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author mac
 */
public class TempConverterController implements EventHandler<ActionEvent> {

    private TempConverterModel theModel;
    private TempConverterView theView;

    public TempConverterController(TempConverterModel theModel,
                                   TempConverterView theView) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.getBtnConvert().setOnAction(this);

        // We can tie multiple event generators to one handler
        this.theView.getTxtFieldTempInput().setOnAction(this);

        theModel.getPropDoCtoF().bind(theView.getRbCtoF().selectedProperty());
        theModel.getPropDoFtoC().bind(theView.getRbFtoC().selectedProperty());
        theView.getLblUnits().textProperty().bind(Bindings.when(
                theModel.getPropDoCtoF()).then("(C)").otherwise("(F)"));

    }

    @Override
    public void handle(ActionEvent event) {
        // Set up the event handlers

        try {
            String temp = this.theView.getTxtFieldTempInput().getText();
            if (temp.length() > 0) {
                String result = theModel.stringConvert(temp);
                theView.getLblResult().setText(result);
            }
            //String result = theModel.FStringToC(fTemp);

            //this.theView.getLblResult().setText(result);
        } catch (NumberFormatException numberFormatException) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.setContentText(String.format("Can not convert \"%s\"",
                                               this.theView.getTxtFieldTempInput().getText()));

            alert.show();
        }

    }

}
