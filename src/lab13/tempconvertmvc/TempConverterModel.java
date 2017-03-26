/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2017
*
* Name: Yuxuan Huang
* Date: Mar 25, 2017
* Time: 3:10:59 PM
*
* Project: csci205
* Package: lab13.tempconvertmvc
* File: TempConverterModel
* Description:
*
* ****************************************
 */
package lab13.tempconvertmvc;

import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Yuxuan
 */
public class TempConverterModel {

    private SimpleBooleanProperty propDoFtoC;
    private SimpleBooleanProperty propDoCtoF;

    public TempConverterModel() {
        this.propDoFtoC = new SimpleBooleanProperty(true);
        this.propDoCtoF = new SimpleBooleanProperty(false);

    }

    public SimpleBooleanProperty getPropDoFtoC() {
        return propDoFtoC;
    }

    public SimpleBooleanProperty getPropDoCtoF() {
        return propDoCtoF;
    }

    public String stringConvert(String temp) {
        if (propDoFtoC.get()) {
            return this.FStringToC(temp);
        }
        if (propDoCtoF.get()) {
            return this.CStringToF(temp);
        }
        return temp;
    }

    /**
     * FStringToC - Convert a Fahrenheit string to a Celsius String
     *
     * @param sFTemp - the Fahrenheit string
     * @return the Celsius String
     *
     */
    public String FStringToC(String sFTemp) {
        double fTemp = Double.parseDouble(sFTemp);
        double cTemp = (fTemp - 32.0) * 5.0 / 9.0;
        String result = String.format("%.1f C", cTemp);
        return result;
    }

    public String CStringToF(String sCTemp) {
        double cTemp = Double.parseDouble(sCTemp);
        double fTemp = cTemp * 9.0 / 5.0 + 32.0;
        String result = String.format("%.1f F", fTemp);
        return result;
    }

}
