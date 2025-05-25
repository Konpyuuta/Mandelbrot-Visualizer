package org.example.mandelbrotview;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Maurice Amon
 */

public class DrawerWidget extends Stage {

    private final Integer PIXEL_SIZE = 5;

    private final Integer WIDGET_WIDTH = 1200;

    private final Integer WIDGET_HEIGHT = 700;

    private final String WINDOW_TITLE = "Mandelbrot Viewer";

    private Scene scene;

    public DrawerWidget() {
        Canvas canvas = new Canvas(WIDGET_WIDTH * PIXEL_SIZE, WIDGET_HEIGHT * PIXEL_SIZE);
        drawGrid(canvas.getGraphicsContext2D());
        Pane rootPane = new Pane();
        scene = new Scene(rootPane);
        setScene(scene);
        setTitle(WINDOW_TITLE);
        show();
    }


    private void drawGrid(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.LIGHTBLUE);
        graphicsContext.setLineWidth(0.5);
        for (int x = 0; x < WIDGET_WIDTH; x++) {
            graphicsContext.strokeLine(x * PIXEL_SIZE, 0, x * PIXEL_SIZE, WIDGET_HEIGHT * PIXEL_SIZE);
        }
        for (int y = 0; y < WIDGET_HEIGHT; y++) {
            graphicsContext.strokeLine(y * PIXEL_SIZE, 0, y * PIXEL_SIZE, WIDGET_HEIGHT * PIXEL_SIZE);
        }
    }

}
