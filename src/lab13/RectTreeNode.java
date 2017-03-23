/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 23, 2017
* Time: 1:13:23 AM
*
* Project: csci205
* Package: lab13
* File: RectTreeNode
* Description: The rectangular box class
*
* ****************************************
 */
package lab13;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * RectTreeNode object
 */
public class RectTreeNode extends Rectangle {

    private static final double INIT_WIDTH = 100;
    private static final double INIT_HEIGHT = 75;

    /**
     * constructor
     *
     * @param fillColor
     */
    public RectTreeNode(Paint fillColor) {
        super(INIT_WIDTH, INIT_HEIGHT, fillColor);
        setupEffects();
    }

    /**
     * Setup shadow effect
     */
    private void setupEffects() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(4.0);
        ds.setOffsetY(4.0);
        ds.setColor(Color.BLACK);
        this.setEffect(ds);

    }
}
