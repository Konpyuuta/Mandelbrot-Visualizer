package org.example.mandelbrotview.view.components;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Maurice Amon
 */

public class MandelbrotCanvas extends Pane {


    private Canvas canvas;

    private final Integer PIXEL_SIZE = 5;

    private final Integer WIDGET_WIDTH = 1200;

    private final Integer WIDGET_HEIGHT = 700;

    public MandelbrotCanvas() {
        super();
        super.setWidth(WIDGET_WIDTH * PIXEL_SIZE);
        super.setHeight(WIDGET_HEIGHT * PIXEL_SIZE);
        canvas = new Canvas(WIDGET_WIDTH * PIXEL_SIZE, WIDGET_HEIGHT * PIXEL_SIZE);
        super.getChildren().add(canvas);
    }

    public void insertPixelColor(Integer[][] image) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[x].length; y++) {
                graphicsContext.getPixelWriter().setColor(x, y, Color.rgb(0, 0, image[x][y]));

            }
        }
    }
}
