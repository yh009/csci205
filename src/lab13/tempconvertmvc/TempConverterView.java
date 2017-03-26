/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 3:10:26 PM
*
* Project: csci205
* Package: lab13.tempconvertmvc
* File: TempConverterView
* Description:
*
* ****************************************
 */
package lab13.tempconvertmvc;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author mac
 */
public class TempConverterView {

    private TempConverterModel theModel;
    private BorderPane root;
    private final Button btnConvert;
    private final Label lblResult;
    private final TextField txtFieldTempInput;
    private Label lblUnits;
    private RadioButton rbFtoC;
    private RadioButton rbCtoF;
    private final ToggleGroup group = new ToggleGroup();
    private VBox leftPane;

    public TempConverterView(TempConverterModel theModel) {
        this.theModel = theModel;
        this.lblUnits = new Label("(F)");

        this.rbCtoF = new RadioButton("C to F");
        this.rbFtoC = new RadioButton("F to C");
        this.rbCtoF.setToggleGroup(group);
        this.rbFtoC.setToggleGroup(group);
        this.rbFtoC.setSelected(true);
        leftPane = new VBox(10);
        leftPane.getChildren().addAll(rbFtoC, rbCtoF);

        root = new BorderPane();

        root.setPrefWidth(300);
        root.setPrefHeight(150);
        root.setPadding(new Insets(10, 15, 15, 15));
        root.setLeft(leftPane);
        //root.setAlignment(Pos.CENTER);

        // Set up top pane to get info from user
        FlowPane topPane = new FlowPane(Orientation.HORIZONTAL);
        topPane.setAlignment(Pos.CENTER);
        topPane.setHgap(10);

        topPane.getChildren().add(new Label("Temperature "));

        txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        topPane.getChildren().add(txtFieldTempInput);
        topPane.getChildren().add(this.lblUnits);

        // Middle section will show the result
        lblResult = new Label("");
        lblResult.setMinWidth(75);
        lblResult.setMinHeight(25);
        lblResult.setBorder(new Border(new BorderStroke(null,
                                                        BorderStrokeStyle.SOLID,
                                                        new CornerRadii(4),
                                                        BorderWidths.DEFAULT)));
        lblResult.setAlignment(Pos.CENTER);

        // Bottom will just be the conversion button
        btnConvert = new Button("Convert!");

        //root.getChildren().addAll(topPane, lblResult, btnConvert);
        root.setTop(topPane);
        root.setCenter(lblResult);
        root.setBottom(btnConvert);
        BorderPane.setAlignment(btnConvert, Pos.CENTER);

    }

    public BorderPane getRootNode() {
        return root;
    }

    public Button getBtnConvert() {
        return btnConvert;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public TextField getTxtFieldTempInput() {
        return txtFieldTempInput;
    }

    public Label getLblUnits() {
        return lblUnits;
    }

    public RadioButton getRbFtoC() {
        return rbFtoC;
    }

    public RadioButton getRbCtoF() {
        return rbCtoF;
    }

}
