package org.example.mandelbrotview;

import javafx.scene.paint.Color;

/**
 *
 * @author Maurice Amon
 */

public class MandelbrotTuple {

    private Boolean isInMandelbrotSet;

    private Integer color;

    public MandelbrotTuple(Integer color, Boolean isInMandelbrotSet) {
        this.isInMandelbrotSet = isInMandelbrotSet;
        this.color = color;
    }

    public Boolean isInMandelbrotSet() {
        return isInMandelbrotSet;
    }

    public Integer getColor() {
        return color;
    }
}
